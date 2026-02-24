import java.util.*/**
 * tinhLuonggiangvien
 */

    private String magv, ten, heso;
    private long tien;
    public void input(){
        Scanner sc = new Scanner(System.in);
        magv = sc.nextLine();
        ten = sc.nextLine();
        tien = long.parselong(sc.nextLine());
        heso = sc.nextLine();
    }
    public void out(){
        double so = 1.0;
        switch (heso) {
            case "A":
                so = 1.5;
                break;
        
            case "B":
                so = 1.5;
                break;
            
            case "C":
                so = 1.0;
                break;
        }
        long thunhap = (long)(tien*so*250000);
        System.out.printf("%s %s %s %d\n", magv, ten, heso, thunhap);
    }
public class tinhLuonggiangvien {
    
    public static void main(String[] args) {
        
    }
}

