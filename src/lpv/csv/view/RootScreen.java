package lpv.csv.view;

import static lpv.csv.controller.DataController.*;

public class RootScreen {

	public static void main(String[] args) {
		try {
			System.out.println(getSUSFinalGrade("/home/ljnferreira/development/teste.csv"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
