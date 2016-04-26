package health.med;

public class Runner {

	public static void main(String[] args) throws Exception {
	/*	String a = args[0];
	    String b = args[1];
		if( args.length<=0){
		 	a= args[0];
		 	b= args[1];
		 }*/
		TimeVerifyWithEexcle exRunner = new TimeVerifyWithEexcle();
		exRunner.beforeMethod();
		exRunner.test1(args[0],args[1],args[2]);
		exRunner.afterMethod();
	}

}
