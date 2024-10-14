import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        Test AX=new Test(a);
        while (true){
            String x_input=sc.nextLine();
            if(x_input.equals("end")){
                break;
            }
            if(x_input.startsWith("#N:")) {
                String[] strs = x_input.split("#");
                Question x=new Question(strs);
                AX.QuestionIn(x);
            }
            if(x_input.startsWith("#A:")){
                String[] Ans=x_input.split("#A:");
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
    public Question(String[] strs){
        this.id=Integer.parseInt(strs[0].substring(2));
        this.name=strs[1].substring(2);
        this.RightAnswer=strs[2].substring(2);
    }
    public void setInputAnswer(String x){
        if(x.equals(RightAnswer)){
            this.IsRight=true;
        }
        this.InputAnswer=x;
    }
    public void PrintTail(){
        System.out.println(this.name+'~'+this.InputAnswer);
    }
    public String  PrintIsRight(){
        if(this.IsRight)return "true";
        else return "false";
    }
}
class Test{
    Question[] ask;
    private  int i_q=0;
    public Test(int len) {
        this.ask=new Question[len];
    }
    public void QuestionIn(Question x){
        ask[i_q]=x;
        i_q++;
    }
    public void AnsInput(String[] ans){
        for(int i=0;i< ans.length;++i){
            for (int j=0;j< ans.length;++j){
                if(ask[j].id==i){
                    ask[j].setInputAnswer(ans[i]);
                    break;
                }
            }
        }
    }
    public void OutQuestion(){
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



