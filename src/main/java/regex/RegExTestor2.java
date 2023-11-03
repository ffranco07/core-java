public class RegExTestor2 {
	//public String myStr = "0000";
	public String myStr = "*5555*0";
	//public String myStr = "1*2*3*4*5*6";
	
	public RegExTestor2() {
		String myVar = myStr;
		//boolean matches = myVar.matches("[1-2]");
		//boolean matches = (myVar.matches("[1-9]") || myVar.matches("10")) ? true : false;
		boolean matches = myVar.matches("\\*\\d+\\*[0-9]");
		//boolean matches = myVar.matches("\\d{5}");
		//boolean matches = myVar.matches("\\d{1,2}\\*\\d{1,2}\\*\\d{1,2}\\*\\d{1,2}\\*\\d{1,2}\\*\\d{1,2}");
		System.out.println("format is: " + myVar + " matches ok: " + matches);
	}
	
	public static void main(String...args) {
		RegExTestor2 testor = new RegExTestor2();
	} 
}
