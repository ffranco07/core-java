public class RegExTestor {

	//public String digitLP = "*5555#";
	public String digitMultiLP = "*5555*3*1*9*123#";
	//public String digitSelfPick = "*5555*12345#";
	//public String digitSelfPick = "555512345";
	public String lottoLP = "*6639#";
	public String resultSubscription = "*225*14#";
	//public String lottoMultiLP = "*6639*10#"; 
	//public String lottoSelfPick = "*6639*10*12*20*32*33*39#"; 
	//public String lottoSelfPick = "*6639*10*12*20*32*33*39";
	//public String lottoSelfPick = "10*12*20*32*39";
	//public String lottoSelfPick = "10,12,20,32,39";
	//public String lottoSelfPick = "10-12-20-32-39";
	public String lottoSelfPick = "10 12 20 32 39";
	//public String lottoSelfPick = "*639*##########";
	//public String lottoSelfPick = "*639*###";
	//public String lottoSelfPick = "*639*...";
	//public String lottoSelfPick = "*639*******#";
	//public String lottoSelfPick = "*639#";
	//public String lottoLP = "*6241#";
	//public String lottoLP = "*6241*9#";
	//public String lottoLP = "*6241*1*3#";
	String leagueError = "SbsTblleague lsportsLeagueId:4146 not found in database!";
	
	public RegExTestor() {
		String[] splitStrArray;
		//String myVar = lottoSelfPick;
		String myVar = leagueError;
		String delimiter = null;
		//String myVar = lottoLP;
		//String myVar = digitMultiLP;
		//String myVar = resultSubscription;
		//boolean matches = myVar.matches("\\*6639#");
		//boolean matches = myVar.matches("\\*\\d+\\*(#)*");
		//boolean matches = myVar.matches("\\*\\d+\\*\\d+(.*)");
		//boolean matches = myVar.matches("\\*\\d+(\\*\\d+)*(\\*\\d+\\*\\d+\\*\\d+\\*\\d+\\*\\d+)*(#)*");
		//boolean matches = myVar.matches("\\*\\d+(\\*\\d+)*#");
		//boolean matches = myVar.matches("\\*\\d+\\*[1-2]\\*10#");
		//boolean matches = myVar.matches("\\*\\d+\\*[1-9]#");
		
		boolean matches = false;
		if (myVar.startsWith("SbsTblleague lsportsLeagueId")) {
			delimiter = null;
			matches = true;
		}
		if (myVar.matches("\\d{1,2}\\*\\d{1,2}\\*\\d{1,2}\\*\\d{1,2}\\*\\d{1,2}")) {
			delimiter = "\\*";
			matches = true;
		}
		else if (myVar.matches("\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}")) {
			delimiter = "\\,";
			matches = true;
		}
		else if (myVar.matches("\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}\\-\\d{1,2}")) {
			delimiter = "\\-";
			matches = true;
		}
		else if (myVar.matches("\\d{1,2}\\s\\d{1,2}\\s\\d{1,2}\\s\\d{1,2}\\s\\d{1,2}")) {
			delimiter = "\\s";
			matches = true;
		}
		
		System.out.println("format: " + myVar + " matches: " + matches + " delimiter: " + delimiter);
		myVar = myVar.split(delimiter)[0];
		System.out.println("myVar is: " + myVar + " after FIRST SPLIT");
		//splitStrArray = myVar.split("\\*");
		//splitStrArray = myVar.split("\\*\\d+\\*");
		//splitStrArray = myVar.split("\\*\\d+\\*[3-5]");
		//splitStrArray = myVar.split("\\*\\d+\\*");
		//splitStrArray = splitStrArray[1].split("\\*");
		//for (int i = 0; i < splitStrArray.length; i++) {
		//System.out.println("splitStrArray[" + i + "] is: " + splitStrArray[i]);
		//}
		//if (splitStrArray[1].equals("6639")) {
		//System.out.println("Message is lotto game");
		//}
		//else if (splitStrArray[1].equals("5555")) {
		//System.out.println("Message is digit game");
		//}
		//System.out.println("splitStrArray length is: " + splitStrArray.length);
	}
	
	public static void main(String...args) {
		RegExTestor testor = new RegExTestor();
	} 
}
