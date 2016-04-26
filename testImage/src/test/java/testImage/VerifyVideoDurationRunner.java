package testImage;



public class VerifyVideoDurationRunner {
	public static void main(String[] args) throws Exception {
		/*	String a = args[0];
		    String b = args[1];
			if( args.length<=0){
			 	a= args[0];
			 	b= args[1];
			 }*/
		Step1HyOnlinePrepTimeVerification exRunner = new Step1HyOnlinePrepTimeVerification();
		exRunner.beforeMethod();
		exRunner.testJar(args[0], args[1], args[2]);
		exRunner.afterMethod();
	}

}
