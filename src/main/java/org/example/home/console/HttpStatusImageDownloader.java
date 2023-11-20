package org.example.home.console;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws IOException {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try (InputStream in = connection.getInputStream()) {
            File file = new File("cats");
            if (!file.exists()) {
                file.mkdir();
            }

            Path path = Paths.get("cats", code + ".jpg");
            FileOutputStream out = new FileOutputStream(path.toString());

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.println("Image downloaded successfully: " + path.toAbsolutePath());
        }
    }
}
