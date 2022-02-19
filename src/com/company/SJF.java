package com.company;

public class SJF {

    String[] processName;
    int[] arrivalTime;
    int[] startTime;
    int[] burstTime;
    int[] completeTime;
    int[] turnAround;
    int[] waitingTime;
    int[] flag;
    int[] dataQueue;

    public SJF(int count){
        processName = new String[count];
        arrivalTime = new int[count];
        startTime = new int[count];
        burstTime = new int[count];
        completeTime = new int[count];
        turnAround = new int[count];
        waitingTime = new int[count];
        flag = new int[count];
        dataQueue = new int[count];
    }

    public void processSJF(int count, int currentTime, int totalTime){
        Queue queue = new Queue(count);

        while(true) {
            int c = count, min = 999;
            if (totalTime == count)

                break;

            for (int i = 0; i < count; i++) {

                if ((arrivalTime[i] <= currentTime) && (flag[i] == 0) && (burstTime[i] < min)) {
                    min = burstTime[i];
                    c = i;
                }
            }

            if (c == count) {

                currentTime++;

            } else {

                startTime[c] = currentTime;
                completeTime[c] = currentTime + burstTime[c];
                currentTime += burstTime[c];
                turnAround[c] = completeTime[c] - arrivalTime[c];
                waitingTime[c] = turnAround[c] - burstTime[c];
                flag[c] = 1;
                totalTime++;

                queue.enqueue(c);
            }
        }

        for (int j = 0; j < count; j++){
            dataQueue[j] = queue.dequeue();
        }

    }

    public void printSJF(float avgWaitingTime, float avgTurnAround, int count){

        String tableFromat = "| %-11s | %-12s | %-10s | %-13s |%-14s | %-12s | %-14s | %n";
        System.out.format("+-------------+--------------+------------+---------------+---------------+--------------+----------------+%n");
        System.out.format("| NAMA PROSES | ARRIVAL TIME | BURST TIME | START TIME    | COMPLETE TIME | TURN ARROUND | WAITING TIME   |%n");
        System.out.format("+-------------+--------------+------------+---------------+---------------+--------------+----------------+%n");

        for(int i = 0; i < count; i++) {
            avgWaitingTime += waitingTime[i];
            avgTurnAround += turnAround[i];

            System.out.format(tableFromat,processName[dataQueue[i]],arrivalTime[dataQueue[i]],burstTime[dataQueue[i]],startTime[dataQueue[i]],completeTime[dataQueue[i]],turnAround[dataQueue[i]],waitingTime[dataQueue[i]]);
        }


        System.out.format("+-------------+--------------+------------+---------------+---------------+--------------+----------------+%n");
        System.out.println ("Rata - rata Turn Around Time = "+ (float)(avgTurnAround/count));
        System.out.println ("Rata - rata Waiting Time = "+ (float)(avgWaitingTime/count));
    }

}
