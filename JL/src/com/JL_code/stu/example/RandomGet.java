package com.JL_code.stu.cuit;
import java.util.Random;
import java.util.Scanner;
public class RandomGet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int a=rand.nextInt(-100,100);
        while (true){
            Scanner sc1 = new Scanner(System.in);
            int x=sc1.nextInt();
            if(a==x){
                System.out.println("猜对了，就是"+a);
                System.out.println("是否继续游戏？(Y/N)");
                char ch=sc.next().charAt(0);
                if(ch=='N'){
                    break;
                }else{
                    a=rand.nextInt(-100,100);
                }
            }else if(x>a){
                System.out.println("猜大了");
            }else if(x<a){
                System.out.println("猜小了");
            }
        }
    }
}