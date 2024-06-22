package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import model.Holiday;

public class HolidayFinderController {

    public static List<Holiday> readHolidaysFromFile(String filePath) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(filePath);
        Type holidayListType = new TypeToken<List<Holiday>>() {}.getType();
        return gson.fromJson(reader, holidayListType);
    }
    
    public static Holiday findHolidayByName(List<Holiday> holidays, String holidayName) {
        for (Holiday holiday : holidays) {
            if (holiday.getName().equalsIgnoreCase(holidayName)) {
                return holiday;
            }
        }
        return null;
    }
	
}
