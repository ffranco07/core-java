import java.util.*;

/**
 *
 * @author Francisco Franco
 * @version %I%, %G%
 * @since 1.0
 */

public final class CryptoConstants {
	private static final String TAG = CryptoConstants.class.getSimpleName();
	 
	// Default plain text file
	public static final String DEFAULT_PLAIN_TEXT_FILE = "output/GLI.txt";

	// Default encrypted file
	public static final String DEFAULT_ENCRYPTED_FILE = "output/GLI.enc";

	// Secret key
	public static final String DEFAULT_SECRET_KEY = "ruyo3+h78OsUn0oQOUpBiQ==";

	// Encryption key
	public static final String ENCRYPTION_KEY = "D3599C13";
	
	// SHA1 pseudo random number generator
	public static final String SHA1PRNG = "SHA1PRNG";
	
	// Algorithms
	public static final String AES_KEY_GEN_ALGORITHM = "AES";
	public static final String AES_ALGORITHM = "AES/CBC/PKCS5Padding";
	public static final String MD5_ALGORITHM = "MD5";
	public static final String SHA256_ALGORITHM = "SHA-256";
	public static final String SHA512_ALGORITHM = "SHA-512";
	public static final String BLOWFISH_ALGORITHM = "Blowfish";
	public static final String BLOWFISH_TRANSFORMATION = "Blowfish/CBC/NoPadding";
	
	// Initial value / Initial vector bytes
	public static final byte[] IV_BYTES = new byte[]{00, 00, 00, 00, 00, 00, 00, 00};
	
	// Component map with digest keys
	public static final HashMap<String, String> componentMap;
	
	static {
		componentMap = new HashMap<String, String>();
		componentMap.put("admin-pf-jamaica.war", "adminDigest");
		componentMap.put("common-jamaica.jar", "commonDigest");
		componentMap.put("msgsubsys-jamaica.jar", "msgsubsysDigest");
		componentMap.put("msgsubsys-rest-jamaica.war", "msgsubsysRestDigest");
		componentMap.put("cp-manager-jamaica.jar", "cpManagerDigest");
		componentMap.put("scheduler-jamaica.jar", "schedulerDigest");
		componentMap.put("rng.jar", "rngDigest");
		componentMap.put("common-cs.jar", "commonCsDigest");
		componentMap.put("em-wallet-jamaica.war", "emWalletDigest");
	}
}
