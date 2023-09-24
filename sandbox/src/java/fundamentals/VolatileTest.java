public class VolatileTest {
	private static final Logger LOGGER = MyLoggerFactory.getSimplestLogger();
	
	private static volatile int MY_INT = 0;
	
	public static void main(String[] args) {
		new ChangeListener().start();
		new ChangeMaker().start();
	}
	
	public static class ChangeListener extends Thread {
		@Override
		public void run() {
			int local_value = MY_INT;
			while ( local_value < 5){
				if( local_value!= MY_INT){
					LOGGER.log(Level.INFO,"Got Change for MY_INT : {0}", MY_INT);
					local_value= MY_INT;
				}
			}
		}
	}
	
	public static class ChangeMaker extends Thread{
		@Override
		public void run() {
			
			int local_value = MY_INT;
			while (MY_INT <5){
				LOGGER.log(Level.INFO, "Incrementing MY_INT to {0}", local_value+1);
				MY_INT = ++local_value;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) { e.printStackTrace(); }
			}
		}
	}
}
