import java.util.*;
class Giangvien{
    private String magv,ten;
    private char heso;
    private int tien;
    private double so;
    public Giangvien(){}
    public void input(){
        Scanner sc=new Scanner(System.in);
        magv=sc.nextLine();
        ten=sc.nextLine();
        tien=Integer.parseInt(sc.nextLine());
        heso=sc.nextLine().charAt(0);
    }
    public void out(){
        switch (heso) {
            case 'A':
                so=1.5;
                break;
            case 'B':
                so=1.2;
                break;
            case 'C':
                so=1.0;
                break;
            default:
                so=1.0;
                break;
        }
        double thunhap=(tien*so*250000);
        System.out.println(magv+" "+ten+" "+heso+" "+String.format("%.0f",thunhap));
    }

    
}
public class Bai1 {
    public static void main(String[] args) {
        Giangvien gv=new Giangvien();
        //input
        gv.input();
        //output
        gv.out();
    }
}