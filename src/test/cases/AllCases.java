package test.cases;

import com.zongrong.web.Suite;

public class AllCases {

	public void run() {
		Suite suite = new Suite();

		suite.addTest(test.cases.example.ExampleCases.class);
		
		suite.run();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AllCases cases=new AllCases();
		cases.run();
	}
}
