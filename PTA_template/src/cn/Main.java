package cn;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        System.out.print(Card24.count(x));
    }
}
class Card24{
    public static int count(int x) {
        List<String> list = new ArrayList<String>();
        int i,j,k,l,count=0;
        int a[]=new int[4];
        for(i=1;i<=x;i++) {
            for(j=i;j<=x;j++) {
                for(k=j;k<=x;k++) {
                    for(l=k;l<=x;l++) {
                        a[0]=i;a[1]=j;a[2]=k;a[3]=l;
                        String str;
                        str=Arrays.toString(a);
                        list.add(str);
                    }
                }
            }
        }
        Set<String> set=new HashSet<String>();
        for(i=0;i<list.size();i++)
        {
            set.add(list.get(i));
        }
        return set.size();
    }
}