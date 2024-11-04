package cn.remeber.pintia;
import java.util.Arrays;
import java.util.Scanner;
public class UpSort {
    public static void main(String[] args) throws OutOfRangeException {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        Test AX=new Test(a);
        while (true){
            String x_input=sc.nextLine();
            if(x_input.equals("end")){
                break;
            }
            if(x_input.startsWith("#N:")) {
                Question x=new Question(x_input);
                AX.QuestionIn(x);
            }
            if(x_input.trim().startsWith("#A:")){
                String[] Ans=x_input.trim().split("#A:");
                AX.AnsInput(Ans);
            }
        }
        AX.OutQuestion();
    }
}
class Question{
    public int id;
    private String name;
    private String RightAnswer;
    private String InputAnswer;
    boolean IsRight =false;
    public Question (){}
    public Question(int id,String name,String RightAnswer){
        this.id=id;
        this.name=name;
        this.RightAnswer=RightAnswer;
    }
    public Question(String str){
        String[] strs = str.split("#");
        for(int i=0;i<strs.length;i++){
            if(strs[i].isEmpty()){continue;}
            /*
            * 由于Split()函数会将String返回为数组，且首元素为空字符,即：""
            * 我真的服了，空字符串居然是元素！直接消了不行吗？
            * 还是python舒服
            */
            if(strs[i].startsWith("N:")){
                this.id=Integer.parseInt(strs[i].substring(2).trim());
            }
            if(strs[i].startsWith("Q:")){
                this.name=strs[i].substring(2).trim();
            }
            if(strs[i].startsWith("A:")){
                this.RightAnswer=strs[i].substring(2).trim();
            }
        }
    }
    public int UpSortById(Object o) {
        Question stu = (Question)o;
        return this.id-stu.id;//按id排序
        //this-参数：升序；
    }
    public int LowSortById(Object o) {
        Question stu = (Question)o;
        return stu.id-this.id;//按id排序
        //this-参数：降序；
    }
    public void setInputAnswer(String x){
        if(x.trim().equals(RightAnswer.trim())){
            this.IsRight=true;
        }
        this.InputAnswer=x;
    }
    public void PrintTail(){
        System.out.println(this.name.trim()+'~'+this.InputAnswer);
    }
    public String  PrintIsRight(){
        if(this.IsRight)return "true";
        else return "false";
    }
}
class OutOfRangeException extends Exception{
    public OutOfRangeException(String mes){
        super(mes);
    }
    @Override
    public String toString(){
        return super.getMessage();
    }
}
class Test  {
    private Question[] ask;
    private int i_q = 0,len=0;
    public Test(int len) {this.len=len;this.ask = new Question[len];}
    public void QuestionIn(Question x) throws OutOfRangeException {
     if(i_q>this.len){
     /**
      * so f**king werid
      * i_q>len can't run but i_q>len+1 can
     */
         throw new OutOfRangeException("It's out of range ~~~~~");
     }else {
         int No = x.id;
         ask[No - 1] = x;
         i_q++;
     }
    }
    public void AnsInput(String[] ans) {
/*
* 老子服了
* java!!!
* 又要考虑这个空字符串
* */
        Arrays.sort(this.ask, (s1,s2)->s1.UpSortById(s2));
        for(Question x:ask){
            for(int i=0;i<ans.length;i++){
                if(i== x.id){x.setInputAnswer(ans[i]);}
            }
        }
    }
    public void OutQuestion() {
        for (Question question : ask) {
            for (int j = 0; j < ask.length; ++j) {
                if (question.id == j + 1) {
                    question.PrintTail();
                }
            }
        }
        for (Question question : ask) {
            for (int j = 0; j < ask.length; ++j) {
                if (question.id == j + 1) {
                    System.out.print(question.PrintIsRight());
                    if (j + 1 != ask.length) {
                        System.out.print(' ');
                    }
                }
            }
        }
    }
}
/*7-1 答题判题程序-1
设计实现答题程序，模拟一个小型的测试，要求输入题目信息和答题信息，根据输入题目信息中的标准答案判断答题的结果。
输入格式:
程序输入信息分三部分：


1、题目数量
   格式：整数数值，若超过1位最高位不能为0，
   样例：34

2、题目内容

   一行为一道题，可以输入多行数据。

   格式："#N:"+题号+" "+"#Q:"+题目内容+" "#A:"+标准答案

   格式约束：题目的输入顺序与题号不相关，不一定按题号顺序从小到大输入。

   样例：#N:1 #Q:1+1= #A:2

         #N:2 #Q:2+2= #A:4

3、答题信息

   答题信息按行输入，每一行为一组答案，每组答案包含第2部分所有题目的解题答案，答案的顺序号与题目题号相对应。

   格式："#A:"+答案内容

   格式约束：答案数量与第2部分题目的数量相同，答案之间以英文空格分隔。

   样例：#A:2 #A:78

      2是题号为1的题目的答案
      78是题号为2的题目的答案
   答题信息以一行"end"标记结束，"end"之后的信息忽略。

输出格式:
1、题目数量

   格式：整数数值，若超过1位最高位不能为0，

   样例：34

2、答题信息

   一行为一道题的答题信息，根据题目的数量输出多行数据。

   格式：题目内容+" ~"+答案

   样例：1+1=~2

              2+2= ~4

3、判题信息

   判题信息为一行数据，一条答题记录每个答案的判断结果，答案的先后顺序与题目题号相对应。

   格式：判题结果+" "+判题结果

   格式约束：

     1、判题结果输出只能是true或者false，
     2、判题信息的顺序与输入答题信息中的顺序相同
   样例：true false true

输入样例1:
单个题目。例如：

1
#N:1 #Q:1+1= #A:2
#A:2
end
输出样例1:
在这里给出相应的输出。例如：

1+1=~2
true
输入样例2:
单个题目。例如：

1
#N:1 #Q:1+1= #A:2
#A:4
end
输出样例2:
在这里给出相应的输出。例如：

1+1=~4
false
输入样例3:
多个题目。例如：

2
#N:1 #Q:1+1= #A:2
#N:2 #Q:2+2= #A:4
#A:2 #A:4
end
输出样例3:
在这里给出相应的输出。例如：

1+1=~2
2+2=~4
true true
输入样例4:
多个题目。例如：

2
#N:1 #Q:1+1= #A:2
#N:2 #Q:2+2= #A:4
#A:2 #A:2
end
输出样例4:
在这里给出相应的输出。例如：

1+1=~2
2+2=~2
true false
输入样例5:
多个题目，题号顺序与输入顺序不同。例如：

2
#N:2 #Q:1+1= #A:2
#N:1 #Q:5+5= #A:10
#A:10 #A:2
end
输出样例5:
在这里给出相应的输出。例如：

5+5=~10
1+1=~2
true true
输入样例6:
含多余的空格符。例如：

1
#N:1 #Q: The starting point of the Long March is #A:ruijin
#A:ruijin
end
输出样例6:
在这里给出相应的输出。例如：

The starting point of the Long March is~ruijin
true

输入样例7:
含多余的空格符。例如：

1
#N: 1 #Q: 5 +5= #A:10
#A:10
end
输出样例7:
在这里给出相应的输出。例如：

5 +5=~10
true

设计建议:
以下是针对以上题目要求的设计建议，其中的属性、方法为最小集，实现代码中可根据情况添加所需的内容：

题目类（用于封装单个题目的信息）：

属性：题目编号、题目内容、标准答案-standardAnswer
方法：数据读写set\get方法、
     判题方法(答案-answer）：判断答案-answer是否符合标准答案-standardAnswer
试卷类（用于封装整套题目的信息）

属性：题目列表(题目类的对象集合)、题目数量
方法：判题方法(题号-num、答案-answer）：判断答案-answer是否符合对应题号的题目标准答案-standardAnswer
     保存题目(题号-num、题目-question）：将题目保存到题目列表中，保存位置与num要能对应
答卷类（用于封装答题信息）

属性：试卷（试卷类的对象）、答案列表（保存每一题的答案）、判题列表（保存每一题的判题结果true/false）
方法：判题方法(题号-num）：判断答案列表中第num题的结果是否符合试卷中对应题号的题目标准答案
     输出方法(题号-num）：按照题目的格式要求，输出题号为num的题目的内容和答题结果。
     保存一个答案(题号-num,答案-answer)：保存题号为num的题目的答题结果answer。
代码长度限制
16 KB
时间限制
400 ms
内存限制
64 MB
栈限制
8192 KB
* */