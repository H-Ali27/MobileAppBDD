package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<String[]> getData(String filePath) throws Exception {
        List<String[]> testData = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            testData.add(values);
        }

        br.close();
        return testData;
    }
}
