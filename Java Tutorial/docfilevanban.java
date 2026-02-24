import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class docfilevanban{
    public static void main(String[] args) {
        File f = new File("DATA.in");
        try{
            Scanner in = new Scanner(f);
            while(in.hasNextLine()){
                String s = in.nextLine();
                System.out.println(s);
            }
        }catch(FileNotFoundException e) {
        }
    }
}