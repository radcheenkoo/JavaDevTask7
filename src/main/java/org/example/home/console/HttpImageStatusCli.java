package org.example.home.console;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner sc = new Scanner(System.in);
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        System.out.println("Enter HTTP status code:");

        try {
            int statusCode = sc.nextInt();
            downloader.downloadStatusImage(statusCode);
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}

