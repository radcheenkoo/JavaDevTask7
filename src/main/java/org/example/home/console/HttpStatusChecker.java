package org.example.home.console;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        int respCode = connection.getResponseCode();

        if (respCode == HttpURLConnection.HTTP_OK) {
            return url;
        } else if (respCode == HttpURLConnection.HTTP_NOT_FOUND) {
            throw new RuntimeException("Image not found for HTTP status " + code);
        } else {
            throw new RuntimeException("Unexpected response code: " + respCode);
        }
    }
}

