package med.qbank;


public class QBankRegressionRunner {

	public static void main(String[] args) {
		
		AnalysisAndReviewPage regRunner = new AnalysisAndReviewPage();
		
		regRunner.beforeMethod();
		regRunner.VerifyTestAnalysisReviewpageforQbankOLP();
		regRunner.afterMethod();
		
		regRunner.beforeMethod();
		regRunner.VerifyAnalysispageforQbankOLPproducts();
		regRunner.afterMethod();
		
		regRunner.beforeMethod();
		regRunner.VerifyExplanationforQbankOLPproducts();
		regRunner.afterMethod();
		
		regRunner.beforeMethod();
		regRunner.VerifyReviewpageforQbankOLPproducts();
		regRunner.afterMethod();
		
		regRunner.beforeMethod();
		regRunner.VerifyAnalysispageforQbankOLP();
		regRunner.afterMethod();
	}
}
