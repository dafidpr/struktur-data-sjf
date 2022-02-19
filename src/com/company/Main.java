package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int currentTime = 0, totalTime = 0;
        float avgWaitingTime = 0, avgTurnAround = 0;

        Scanner in = new Scanner(System.in);
        System.out.print ("Masukan Jumlah Proses : ");
        int n = in.nextInt();

        SJF sjf = new SJF(n);

        for(int i = 0; i < n; i++) {

            System.out.print("Masukan nama proses "+ (i+1) +" : ");
            sjf.processName[i] = in.next();
            System.out.print ("Masukan proses " + (i+1) + " (arrival time) : ");
            sjf.arrivalTime[i] = in.nextInt();
            System.out.print ("Masukan proses " + (i+1) + " (burst time) : ");
            sjf.burstTime[i] = in.nextInt();
            sjf.flag[i] = 0;
        }

        in.close();

        sjf.processSJF(n, currentTime, totalTime);
        sjf.printSJF(avgWaitingTime, avgTurnAround, n);
    }
}
