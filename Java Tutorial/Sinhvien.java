package kiemtra9_9;

import java.util.Scanner;

public class Sinhvien {
    String code, name;
    boolean sex;
    int point;
    public Sinhvien(){
    }
    void input(){
        Scanner sc=new Scanner(System.in);
        //String code, name, sex, point;
        code=sc.nextLine();
        name=sc.nextLine();
        sex=sc.nextBoolean();
        point=sc.nextInt();
    }
    void out(){
        System.out.print(code.toUpperCase() + " " + name + " ");
        if(sex) System.out.print("nam ");
        else System.out.print("nu ");
        if(point<5) System.out.print("hoc lai");
        else System.out.println("dat");
    }
    public static void main(String[] args) {
        Sinhvien sv=new Sinhvien();
        //input
        sv.input();
        //output
        sv.out();
    }
}
