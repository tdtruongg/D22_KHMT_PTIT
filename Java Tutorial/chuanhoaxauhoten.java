import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class J07021 {
    public static void main(String[] args) throws FileNotFoundException{
        File f=new File("DATA.in");
        try {
            Scanner in=new Scanner(f);
            while(in.hasNextLine()){
                String s=in.nextLine();
                if(s.equals("END")) break;
                s=s.trim().toLowerCase();
                String a[]=s.split("\\s+");
                for(int i=0;i<a.length;i++){
                    char arr[]=a[i].toCharArray();
                    arr[0]-=32;
                    System.out.print(String.valueOf(arr));
                    if(i!=a.length-1) System.out.print(" ");
                }
                System.out.println();
                
            }
        } catch (FileNotFoundException e) {

        }
    }
}
