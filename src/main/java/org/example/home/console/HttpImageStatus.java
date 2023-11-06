package org.example.home.console;

import java.util.Scanner;

public class HttpImageStatus {
    public void askStatus(){

        System.out.println("Enter HTTP status code:");
        Scanner sc = new Scanner(System.in);

        new HttpStatusImageDownloader().downloadStatusImage(sc.nextInt());

    }
}
