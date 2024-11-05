package org.example;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        Timer timer = new Timer();
        Compare compare = new Compare();

        // Schedule the task to run every 5 seconds
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String s = compare.compareCourses(null, null);
                System.out.println(s);
            }
        }, 0, 5000); // 5000 ms = 5 seconds


    }


}