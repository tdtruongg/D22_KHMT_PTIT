import java.util.Scanner;

public class J02006_Hopcua2dayso {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            int[] x = new int[1005];

            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                x[a[i]] = 1;
            }

            for(int i = 0; i < m; i++){
                b[i] = sc.nextInt();
                x[b[i]] = 1;
            }

            for(int i = 1; i <= 1000;  i++){
                if(x[i] == 1){
                    System.out.print(i + " ");
                }
            }
        }
}
