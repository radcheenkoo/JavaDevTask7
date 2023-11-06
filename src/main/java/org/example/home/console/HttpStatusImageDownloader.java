package org.example.home.console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code){
        String url = new HttpStatusChecker().getStatusImage(code);

        try( InputStream in = new URL(url).openStream()) {

            String path = "cats/" + code + ".jpg";

            if (!new File(path).exists()) {

                Files.copy(in, Paths.get(path));
            } else {

                System.out.println(String.format("File with code %s already exist!", code));
            }
        } catch(Exception e) {
            try {

                throw new FileNotFoundException(String.format("File with code %s not found!", code));
            } catch (FileNotFoundException ex) {

                throw new RuntimeException(ex);
            }
        }

    }
}
