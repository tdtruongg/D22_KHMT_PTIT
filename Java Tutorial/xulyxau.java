import java.util.Scanner;

public class xulyxau {

   public static Scanner ip = new Scanner(System.in);

    public static boolean isCodeValid(String code){
        String pattern = "^[Bb]\\d{2}(DC | CN | AT | dc | cn | at)\\{3}$";
        return code.matches(pattern);
    }
    public static boolean isBillCode(String code){
        String adString = "^[Nn][Xx]\\d{2}(PTIT|ptit)?\\d{2,4}$";
        return code.matches(adString);
    }

    public static  void main(String[] args){
        Scanner in=new Scanner(System.in);
        xulyxau x=new xulyxau();
        String st=in.nextLine();
        System.out.println(x.isCodeValid(st));
        st=in.nextLine();
        System.out.println(x.isBillCode(st));
    }
}

