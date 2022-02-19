package com.company;

public class Queue {
    int[] element;
    int front;
    int rear;
    int maxQueue;

    public Queue(int max){
        front = 0;
        rear = -1;
        maxQueue = max - 1;
        element = new int[max];
    }

    public boolean isEmpty(){
        boolean flag;
        if (rear < 0){
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean isFull(){
        boolean flag;
        if (rear == maxQueue){
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void enqueue(int data){
        if (isFull()){
            System.out.println("Queue penuh, tidak dapat mengisi data lagi");
        } else {
            rear += 1;
            element[rear] = data;
        }
    }

    public int dequeue(){
        int data = 0;
        if (isEmpty()){
            System.out.println("Queue kosong");
        } else {
            data = element[front];
            element[front] = 0;
            front += 1;
        }
        return data;
    }
}
