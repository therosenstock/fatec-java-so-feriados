package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import model.Holiday;

import java.io.File;

public class FileController {

    private static final String DOWNLOAD_URL = "https://date.nager.at/api/v2/publicholidays/2020/US";

    

    public List<Holiday> downloadFile() throws IOException {

        String tempDir = System.getProperty("os.name").toLowerCase().contains("win") ? "C:\\TEMP" : "/tmp/";
        String filePath = tempDir + File.separator + "hol.json";

        File directory = new File(tempDir);

        if (!directory.exists()) {
        	
            if (directory.mkdirs()) {
                System.out.println("Diretório criado com sucesso: " + directory.getAbsolutePath());
            } else {
                System.out.println("Não foi possível criar o diretório: " + directory.getAbsolutePath());
            }   
        }
        
        try (
        		BufferedInputStream in = new BufferedInputStream(new URL(DOWNLOAD_URL).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(filePath)
            ) {
               	byte dataBuffer[] = new byte[1024]; 
               	int bytesRead;
               	while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                   fileOutputStream.write(dataBuffer, 0, bytesRead);
               	}
               	System.out.println("Arquivo baixado com sucesso!");
           } catch (IOException e) {
               e.printStackTrace();
           }
        
        HolidayFinderController holiday = new HolidayFinderController();
        
        return holiday.readHolidaysFromFile(filePath);
        
        
    }
    
    
    


}
