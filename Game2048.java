import java.util.*;

public class Game2048 {
    static int[][]b=new int[4][4];
    static Random r=new Random();

    static void add(){
        int i,j;
        while(true){
            i=r.nextInt(4);
            j=r.nextInt(4);
            if(b[i][j]==0){
                b[i][j]=r.nextInt(2)==0?2:4;
                break;
            }
        }
    }
    static void print(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(b[i][j]+"\t");
            }
            System.out.println();
        }
    }
    static void left(){
        for(int i=0;i<4;i++){
            int[]t=new int[4];
            int k=0;
            for(int j=0;j<4;j++){
                if(b[i][j]!=0){
                    if(k>0&&t[k-1]==b[i][j]){
                        t[k-1]*=2;
                    }else{
                        t[k++]=b[i][j];
                    }
                }
            }
            b[i]=t;
        }
    }
    static void right(){
        reverse();
        left();
        reverse();
    }
    static void up(){
        transpose();
        left();
        transpose();
    }
    static void down(){
        transpose();
        right();
        transpose();
    }
    static void reverse(){
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                int t=b[i][j];
                b[i][j]=b[i][3-j];
                b[i][3-j]=t;
            }
        }
    }
    static void transpose(){
        for(int i=0;i<4;i++){
            for(int j=i+1;j<4;j++){
                int t=b[i][j];
                b[i][j]=b[j][i];
                b[j][i]=t;
            }
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        add();
        add();

        while(true){
            print();
            System.out.println("W=UP S=DOWN A=LEFT D=RIGHT X=EXIT");
            char c=sc.next().charAt(0);

            if(c=='a')left();
            else if(c=='d')right();
            else if(c=='w')up();
            else if(c=='s')down();
            else if(c=='x')break;

            add();
        }
    }
}
