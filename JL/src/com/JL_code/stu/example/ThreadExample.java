package com.JL_code.stu.example;

public class ThreadExample {
    public static void main(String[] args) {
        PrimeThread x1=new PrimeThread();
        x1.start();
        for(int i=1;i<=5;i++) {
            System.out.println("主线程运行了"+i);
        }/**
         * 开启线程
         * 启动后便调用run方法
         * */
    }
}
class PrimeThread extends Thread {
    long minPrime;
    PrimeThread () {
        this.minPrime = minPrime;
    }
    @Override
    public void run() {
        // compute primes larger than minPrime
        for(int i=1;i<=5;i++) {
            System.out.println("子子线程运行了"+i);
        }
    }
}