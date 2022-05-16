package lpv.csv.controller;

import static lpv.csv.model.CommaSeparatedValueFileHandler.*;

import java.io.FileReader;
import java.util.List;

public class DataController {
	public static double getSUSFinalGrade(String location) throws Exception{
		FileReader csv = new FileReader(location);
		List<String[]> data = readAll(csv);
		return calculateGrade(data);
	}
	
	private static double calculateGrade(List<String[]> data) {
		boolean firstIteration = true;
		double[] averages = new double[(data.size()-1)];
		int counter = 0; 
		double grade = 0;
		
		for(String[] test : data) {
			if(firstIteration) {
				firstIteration = false;
				continue;
			}
			for(int index = 0; index < test.length; index++) {
				if(((index + 1) % 2) == 0) {
					averages[counter] += 5 - Double.parseDouble(test[index]);
				}else {
					averages[counter] += Double.parseDouble(test[index]) - 1;
				}
			}
			averages[counter] = averages[counter] * 2.5; 
			counter++;
		}
		
		for(double avg : averages) {
			grade += avg;
		}
		
		grade = grade / averages.length;
		
		return grade;
	}
}
