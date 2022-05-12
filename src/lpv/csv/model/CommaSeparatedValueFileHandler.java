package lpv.csv.model;

import java.io.Reader;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.*;

public class CommaSeparatedValueFileHandler {
	public static List<String[]> readAll(Reader reader) throws Exception {
	    CSVReader csvReader = new CSVReader(reader);
	    List<String[]> list = new ArrayList<>();
	    list = csvReader.readAll();
	    reader.close();
	    csvReader.close();
	    return list;
	}
	
}
