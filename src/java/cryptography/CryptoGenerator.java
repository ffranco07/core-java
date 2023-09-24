//package com.gameteclabs.bizlogic.util;

import java.io.*;

import java.util.Map;
import javax.crypto.SecretKey;

//import com.gameteclabs.util.ByteHelper;

/**
 * CryptoGenerator is a class used to generate
 * cryptography data
 *
 * <p>Copyright: Copyright (c) by GameTecLabs, Inc. 2021</p> 
 *
 * @author Francisco Franco 
 * @version %I%, %G%
 * @since 1.0
 */

public class CryptoGenerator {
	private static final String DEFAULT_PLAIN_TEXT_FILE = CryptoConstants.DEFAULT_PLAIN_TEXT_FILE;
	private static final String DEFAULT_ENCRYPTED_FILE = CryptoConstants.DEFAULT_ENCRYPTED_FILE;
	private static final String DEFAULT_SECRET_KEY = CryptoConstants.DEFAULT_SECRET_KEY;
	
	private static final String AES_KEY_GEN_ALGORITHM = CryptoConstants.AES_KEY_GEN_ALGORITHM;
	private static final String AES_ALGORITHM = CryptoConstants.AES_ALGORITHM;
	private static final String MD5_ALGORITHM = CryptoConstants.MD5_ALGORITHM;
	
	// ==========================
	// Public methods
	// ==========================
	
	public static void main(String[] args) throws Exception {
		final SecretKey secretKey = CryptoUtils.getDecodedSecretKey(DEFAULT_SECRET_KEY, AES_KEY_GEN_ALGORITHM);
		//System.out.println("***************");
		if (args == null || args.length != 1) {
			CryptoUtils.generateEncryptedDigestFile(DEFAULT_PLAIN_TEXT_FILE, MD5_ALGORITHM, AES_ALGORITHM, secretKey, DEFAULT_ENCRYPTED_FILE);
			String decryptedFileContent = CryptoUtils.decryptFile(AES_ALGORITHM, secretKey, DEFAULT_ENCRYPTED_FILE);
			System.out.println("Decrypted Content:" + "\n" + decryptedFileContent);
			System.out.println(DEFAULT_ENCRYPTED_FILE + " FILE GENERATED");
			System.out.println("DONE!");
		}
		else {
			String arg1 = args[0];
			if (arg1.equals("-h")) {
				File directoryPath = new File("builds");
				//List of all files and directories
				File filesList[] = directoryPath.listFiles();
				System.out.println("List of files and directories in the specified directory: \"" + directoryPath + "\"");
				String componentName = null;
				String fileHexHash = null;
				String digestKey = null;
				StringBuilder digestBuilder = new StringBuilder();
				int count = 0;
				for(File file : filesList) {
					count+=1;
					componentName = file.getName();
					System.out.println("FILE NAME: "+ componentName);
					System.out.println("FILE PATH: "+file.getAbsolutePath());
					System.out.println("FILE SIZE: "+file.getTotalSpace());
					digestKey = CryptoConstants.componentMap.get(componentName);
					fileHexHash = CryptoUtils.digestFile(file.getAbsolutePath(), MD5_ALGORITHM);
					digestBuilder.append(digestKey + ":" + fileHexHash);
					//System.out.println("count:" + count + " filesList length:" + filesList.length);
					if (count != filesList.length) {
						digestBuilder.append("\n");
					}
				}
				System.out.println(digestBuilder.toString());
				FileUtil.writeToFile(DEFAULT_PLAIN_TEXT_FILE, digestBuilder.toString());
				//System.out.println("***************");
				//System.out.println("DONE!");
			}
			else if (arg1.equals("-e")) {
				CryptoUtils.generateEncryptedDigestFile(DEFAULT_PLAIN_TEXT_FILE, MD5_ALGORITHM, AES_ALGORITHM, secretKey, DEFAULT_ENCRYPTED_FILE);
				//System.out.println("***************");
				//System.out.println("DONE!");
			}
			else if (arg1.equals("-d")) {
				Map<String, String> decryptedFileMap = CryptoUtils.decryptFileAsMap(AES_ALGORITHM, secretKey, DEFAULT_ENCRYPTED_FILE, ":");
				System.out.println("DECRYPTED FILE MAP:" + "\n" + decryptedFileMap);
				//System.out.println("***************");
				//System.out.println("DONE!");
			}
			else {
				System.out.println("Usage: java CryptoGenerator <-h hash> <-e encrypt> <-d decrypt> <No args to encrypt and generate GLI.enc>");
				System.exit(1);
			}
		}
	}
}
	
