import java.io.*;
import java.util.ArrayList;

public class J07006 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream("DATA.in");
        ObjectInputStream in = new ObjectInputStream(f);
        ArrayList<Integer> v = (ArrayList <Integer>) in.readObject();
        in.close();
        int a[] = new int[1000];
        for(Integer x : v){
            a[x]++;
        }
        for(int i =0; i < 1000; i++){
            System.out.println(i + " " + a[i]);
        }
    }
}