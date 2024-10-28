package com.JL_code.stu.cuit;
public class x1 {
     public static void main(String[] args) {
         int a = 1;
         class_x1 tmp0 = new class_x1();
         class_x1 tmp1 = new class_x1();
         tmp1.main(1);
         tmp0.main(2);
         System.out.println(class_x1.a);
     }
}
class class_x1 {
    static int a = 1;
    static{
        System.out.println(a);
        a=a+1;
    }
    public void main(int y) {
        System.out.printf("strange:%d \n",y+a);
    }
}
class A{
    private static A a = new A();
    private A(){
    }
    public static A getObject(){
        return a;
    }
}

