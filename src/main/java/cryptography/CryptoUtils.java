//package com.gameteclabs.bizlogic.util;

import java.io.*;

import java.nio.file.Paths;
import java.nio.file.Files;

import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import java.util.Scanner;
import java.util.Base64;
import java.util.Map;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

//import com.gameteclabs.util.ByteHelper;

/**
 * CryptoUtils is a class used to create message digest, 
 * encrypt, and decrypt files
 * 
 * <p>Copyright: Copyright (c) by GameTecLabs, Inc. 2011</p> 
 *
 * @author Francisco Franco 
 * @version %I%, %G%
 * @since 1.0
 */

public final class CryptoUtils {
	// Encryption Key
	private static final String ENCRYPTION_KEY = CryptoConstants.ENCRYPTION_KEY;

	// SHA1 pseudo random number generator
	private static final String SHA1PRNG = CryptoConstants.SHA1PRNG;
	
	// Algorithms
	private static final String AES_KEY_GEN_ALGORITHM = CryptoConstants.AES_KEY_GEN_ALGORITHM;
	private static final String AES_ALGORITHM = CryptoConstants.AES_ALGORITHM;
	private static final String MD5_ALGORITHM = CryptoConstants.MD5_ALGORITHM;
	private static final String BLOWFISH_ALGORITHM = CryptoConstants.BLOWFISH_ALGORITHM;
	private static final String BLOWFISH_TRANSFORMATION = CryptoConstants.BLOWFISH_TRANSFORMATION;
	private static final byte[] IV_BYTES = CryptoConstants.IV_BYTES;

	// ==========================
	// Private methods
	// ==========================

	/**
	 * Convert byte array to hex string
	 * @param bytes
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	
	/**
	 * Convert string to byte array
	 * @param s
	 */
	private static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}
	
	/**
	 * Get SecretKeySpec using keyFile
	 * @param keyFile
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	private static SecretKeySpec getSecretKeySpec(File keyFile) throws NoSuchAlgorithmException, IOException {
		//byte[] key = DomainConstants.ENCRYPTION_KEY.getBytes();
		byte[] key = ENCRYPTION_KEY.getBytes();
		SecretKeySpec sks = new SecretKeySpec(key, BLOWFISH_ALGORITHM);
		return sks;
	}
	
	/**
	 * Read keyFile and return hex string byte array
	 * @param keyFile
	 * @throws FileNotFountException
	 */
	private static byte[] readKeyFile(File keyFile) throws FileNotFoundException {
		Scanner scanner = new Scanner(keyFile).useDelimiter("\\Z");
		String keyValue = scanner.next();
		scanner.close();
		return hexStringToByteArray(keyValue);
	}
	
	// Generate salt (randomly generated text) for more secure hash
	private static byte[] getSalt() throws NoSuchAlgorithmException {
		//Create array for salt
    byte[] salt = new byte[16];
		
		//Always use a SecureRandom generator
    SecureRandom sr = SecureRandom.getInstance(SHA1PRNG);
    
		//Get a random salt
    sr.nextBytes(salt);
		System.out.println("salt:" + Base64.getEncoder().encodeToString(salt)); 
		
		//return salt
    return salt;
	}
	
	private static byte[] getRandomNonce(int numBytes) {
		byte[] nonce = new byte[numBytes];
		new SecureRandom().nextBytes(nonce);
		return nonce;
	}

	// ==========================
	// Protected methods
	// ==========================

	protected static String getEncodedSecretKey(SecretKey secretKey) {
		String encodedSecretKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		System.out.println("encodedSecretKey:" + encodedSecretKey);
		return encodedSecretKey;
	}

	protected static SecretKey getDecodedSecretKey(String encodedSecretKey, String keyGeneratorAlgorithm) {
		byte[] decodedKey = Base64.getDecoder().decode(encodedSecretKey);
		SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, keyGeneratorAlgorithm);
		System.out.println("secretKey:" + secretKey);
		return secretKey;
	}
	
	// ==========================
	// Public methods
	// ==========================

	/**
   * @param filePath
   * @param algorithm
   * @return String
   */
	public static String digestFile(String filePath, String algorithm) throws IOException {
		MessageDigest md = null;
    try {
			md = MessageDigest.getInstance(algorithm);
		}
    catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		// File hashing with DigestInputStream
		try (DigestInputStream dis = new DigestInputStream(new FileInputStream(filePath), md)) {
			while (dis.read() != -1) ; //empty loop to clear the data
			md = dis.getMessageDigest();
		}
		
		// bytes to hex
		StringBuilder result = new StringBuilder();
		for (byte b : md.digest()) {
			result.append(String.format("%02x", b));
		}
		return result.toString();
	}

	/**
   * @param message
   * @param algorithm
   * @return String
   */
  public static String digestMessage(String message, String algorithm) {
    MessageDigest md = null;
    try {
			md = MessageDigest.getInstance(algorithm);
		}
    catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(message.getBytes());
		byte[] hash = md.digest();
		//System.out.println("hash length:" + hash.length);
		String hexHashStr = ByteHelper.toHexString(hash);
		//System.out.println("hexHashStr:" + hexHashStr);
		//System.out.println("hexHashStr length:" + hexHashStr.length());
		return hexHashStr;
  }
	
	/**
   * @param content
   * @param algorithm
	 * @param secretKey
	 * @param fileName
	 * @throws GeneralSecurityException
	 * @throws IOException
   */
	public static void encryptFile(String content, String algorithm, SecretKey secretKey, String fileName) throws GeneralSecurityException, IOException {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		// Initial value or inital vector for random bytes
		byte[] iv = cipher.getIV();
		FileOutputStream fileOut = new FileOutputStream(fileName);
		CipherOutputStream cipherOut = new CipherOutputStream(fileOut, cipher);
		fileOut.write(iv);
		cipherOut.write(content.getBytes());
		fileOut.write(cipher.doFinal());
    fileOut.flush();
	}

	/**
	 * @param algorithm
	 * @param secretKey
	 * @param fileName
	 * @throws GeneralSecurityException
	 * @throws IOException
	 * @return String
   */
	public static String decryptFile(String algorithm, SecretKey secretKey, String fileName) throws GeneralSecurityException, IOException {
		String content = null;
		FileInputStream fileIn = new FileInputStream(fileName);
		// Initial value or inital vector for random bytes
		byte[] fileIv = new byte[16];
		fileIn.read(fileIv);
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(fileIv));
		CipherInputStream cipherIn = new CipherInputStream(fileIn, cipher);
		InputStreamReader inputReader = new InputStreamReader(cipherIn);
		BufferedReader reader = new BufferedReader(inputReader);
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		content = sb.toString();
		return content;
	}

		/**
	 * @param algorithm
	 * @param secretKey
	 * @param fileName
	 * @throws GeneralSecurityException
	 * @throws IOException
	 * @return String
   */
	public static Map<String, String> decryptFileAsMap(String algorithm, SecretKey secretKey, String fileName, String delimiter) throws GeneralSecurityException, IOException {
		String content = null;
		FileInputStream fileIn = new FileInputStream(fileName);
		// Initial value or inital vector for random bytes
		byte[] fileIv = new byte[16];
		fileIn.read(fileIv);
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(fileIv));
		CipherInputStream cipherIn = new CipherInputStream(fileIn, cipher);
		InputStreamReader inputReader = new InputStreamReader(cipherIn);
		BufferedReader reader = new BufferedReader(inputReader);
		String line;
		String[] keyValueArray;
		Map<String, String> keyValueMap = new HashMap<String, String>();
		while ((line = reader.readLine()) != null) {
			keyValueArray = line.split(delimiter);
			keyValueMap.put(keyValueArray[0], keyValueArray[1]);
		}
		return keyValueMap;	
	}
	
	/**
	 * Encrypt a long value and generate a keyFile
	 * if the keyFile is not found then a new one is created
	 * @param value
	 * @param keyFile
	 * @throws GeneralSecurityException
	 * @throws IOException
	 */
	public static byte[] encrypt(long value, File keyFile) throws GeneralSecurityException, IOException {
		if (keyFile != null && !keyFile.exists()) {
			KeyGenerator keyGen = KeyGenerator.getInstance(BLOWFISH_ALGORITHM);
			keyGen.init(32);
			SecretKey sk = keyGen.generateKey();
			FileWriter fw = new FileWriter(keyFile);
			fw.write(byteArrayToHexString(sk.getEncoded()));
			fw.flush();
			fw.close();
		}
		SecretKeySpec sks = getSecretKeySpec(keyFile);
		// Initial value or inital vector for random bytes
		IvParameterSpec ivps = new IvParameterSpec(IV_BYTES);
		Cipher cipher = Cipher.getInstance(BLOWFISH_TRANSFORMATION);
		cipher.init(Cipher.ENCRYPT_MODE, sks, ivps);
		byte[] valueBytes = new byte[8];
		ByteHelper.longToByteArray(value, valueBytes, 0);
		byte[] encryptedBytes = cipher.doFinal(valueBytes);
		return encryptedBytes;
	}
	
	/**
	 * Decrypt valueBytes using keyFile
	 * @param valueBytes
	 * @param keyFile
	 * @throws GeneralSecurityException
	 * @throws IOException
	 */
	public static byte[] decrypt(byte[] valueBytes, File keyFile) throws GeneralSecurityException, IOException {
		SecretKeySpec sks = getSecretKeySpec(keyFile);
		Cipher cipher = Cipher.getInstance(BLOWFISH_TRANSFORMATION);
		IvParameterSpec ivps = new IvParameterSpec(IV_BYTES);
		cipher.init(Cipher.DECRYPT_MODE, sks, ivps);
		byte[] decryptedBytes = cipher.doFinal(valueBytes);
		return decryptedBytes;
	}
	
	/**
	 * Convert byte array to hex string
	 * @param b
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	public static SecretKey generateSecretKey(String keyGeneratorAlgorithm) throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance(keyGeneratorAlgorithm);
		keyGen.init(128, SecureRandom.getInstanceStrong());
		// Generate secret key from key generator
		SecretKey secretKey = keyGen.generateKey();
		return secretKey;
	}
	
	public static void generateEncryptedDigestFile(String messageFileName, String digestAlgorithm, String encryptionFileAlgorithm, SecretKey secretKey, String digestFileName) throws GeneralSecurityException, IOException {
		byte[] fileContentBytes = Files.readAllBytes(Paths.get(messageFileName));
		String content = new String(fileContentBytes).trim();
		System.out.println("DIGEST PLAIN TEXT CONTENT:" + "\n" + content);
		String[] msgArray = content.split("\n");
		System.out.println("DIGEST MESSAGE COUNT:" + msgArray.length);
		encryptFile(content, encryptionFileAlgorithm, secretKey, digestFileName);
	}
}
	
