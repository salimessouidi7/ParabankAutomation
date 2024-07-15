package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CSVUtils {
	private static final String CSV_PATH = "/DataRegister.csv";
	private static final Random random = new Random();
	private static List<String[]> csvDataCache; // Cache to hold CSV data
	private static String dynamicUsername; // Holds the dynamically generated username

	public static List<String[]> readCSV(String filePath) throws CsvValidationException {
		List<String[]> data = new ArrayList<>();
		try (CSVReader reader = new CSVReader(new InputStreamReader(CSVUtils.class.getResourceAsStream(filePath)))) {
			String[] line;
			while ((line = reader.readNext()) != null) {
				data.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	@DataProvider(name = "csvData")
	public static Object[][] getDataFromCSV() throws CsvValidationException {
		if (csvDataCache == null) {
			csvDataCache = readCSV(CSV_PATH); // Read CSV file only once
		}
		Object[][] data = new Object[csvDataCache.size()][];
		for (int i = 0; i < csvDataCache.size(); i++) {
			String[] row = csvDataCache.get(i);
			if (dynamicUsername == null) {
				dynamicUsername = generateDynamicUsername(); // Generate username once
			}
			row[8] = dynamicUsername; // Assuming username is at index 8 in your CSV structure
			data[i] = row;
		}
		return data;
	}

	private static String generateDynamicUsername() {
		String baseUsername = "testRegister";
		int randomNumber = random.nextInt(900) + 100; // Generate a random number between 100 and 999
		String formattedRandomNumber = String.valueOf(randomNumber);
		String username = baseUsername + formattedRandomNumber;
		return username;
	}

	public static String getDynamicUsername() {
		if (dynamicUsername == null) {
			dynamicUsername = generateDynamicUsername(); // Generate username if not already generated
		}
		return dynamicUsername;
	}
}
