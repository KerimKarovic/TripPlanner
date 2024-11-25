import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public List<Destination> readDestinationsFromExcel(String filePath) {
        List<Destination> destinations = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(new File(filePath))) {
            // Create Workbook instance holding reference to .xlsx file
            Workbook workbook = new XSSFWorkbook(file);

            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row in the sheet
            for (Row row : sheet) {
                String name = row.getCell(0).getStringCellValue();  // Destination name
                double distance = row.getCell(1).getNumericCellValue();  // Distance from Zivinice
                int minutes = (int) row.getCell(2).getNumericCellValue();  // Minutes of travel from Zivinice

                // Add new Destination object to the list
                destinations.add(new Destination(name, distance, minutes));
            }

            // Close the workbook
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return destinations;
    }
}
