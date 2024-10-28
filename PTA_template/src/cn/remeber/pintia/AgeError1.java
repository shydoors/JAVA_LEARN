package cn.java.pintia;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int y,m,d;
        y=sc.nextInt();
        m=sc.nextInt();
        d=sc.nextInt();
        sc.close();
        Age father=new Age(1980);
        father.setMonth(2);
        father.setDay(18);
        Age son=new Age(y,m,d);
        try{System.out.print(father.Compare(son));
        }
        catch(AgeException e){
            System.out.println(e.toString());
        }
    }
}
class Age{
    int age,month=2,day=18;
    public void setAge(int age) {this.age = age;}
    public void setMonth(int month) {this.month = month;}
    public void setDay(int day) {this.day = day;}
    public int getAge() {return age;}
    public int getMonth() {return month;}
    public int getDay() {return day;}
    public Age(int age, int month, int day) {
        this.age = age;this.month = month;this.day = day;}
    public Age(int age) {this.age = age;}
    public int Compare(Age son) throws AgeException{
        int tmp=son.age-this.age;
        if(tmp<20){
            throw new AgeException("too young");
        }else if(tmp>70){
            throw new AgeException("too old");
        }
        return tmp;
    }
}
class AgeException extends Exception{
    public AgeException(String Message){
        super(Message);
    }
    @Override
    public String toString() {
        return super.getMessage();
    }
}