package org.example.home.console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code){
        String stringUrl = "https://http.cat/" + code + ".jpg";

        try {

        HttpURLConnection connection = (HttpURLConnection) new URL(stringUrl).openConnection();
        int responseCode = connection.getResponseCode();

        if(responseCode == 404) {
            throw new FileNotFoundException(String.format("File with code %s not found!", code));
        }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        return stringUrl;
    }
}
