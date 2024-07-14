package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
	// Path to the CSV file
	private static final String CSV_PATH = "/DataRegister.csv";

	// Method to read data from a CSV file
	public static List<String[]> readCSV(String filePath) throws CsvValidationException {
		// Create a list to store the read data
		List<String[]> data = new ArrayList<>();
		try (
				// Use a CSVReader to read the CSV file from an input stream
				CSVReader reader = new CSVReader(new InputStreamReader(CSVUtils.class.getResourceAsStream(filePath)))) {
			String[] line;
			// Read each line of the CSV file until there are no more lines
			while ((line = reader.readNext()) != null) {
				// Add the read line to the data list
				data.add(line);
			}
		} catch (IOException e) {
			// Handle exceptions related to reading the CSV file
			e.printStackTrace();
		}
		// Return the data read from the CSV file
		return data;
	}

	// Method providing data for tests from the CSV file
	@DataProvider(name = "csvData")
	public static Object[][] getDataFromCSV() throws CsvValidationException {
		// Read the data from the CSV file
		List<String[]> csvData = readCSV(CSV_PATH);
		// Create a two-dimensional object array to store the read data
		Object[][] data = new Object[csvData.size()][];
		// Fill the array with the read data
		for (int i = 0; i < csvData.size(); i++) {
			data[i] = csvData.get(i);
		}
		// Return the data array for tests
		return data;
	}
}
