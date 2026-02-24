package oop_ptit;

import java.util.*;

public class J05081 {
    public static int cnt;

    public static class hang {
        String ten, mmh, dvi;
        long mua, ban, ln;

        public hang(String a, String b, long c, long d) {
            cnt++;
            String xau = Integer.toString(cnt);
            while (xau.length() < 3) xau = "0" + xau;
            mmh = "MH" + xau;
            ten = a;
            dvi = b;
            mua = c;
            ban = d;
            ln = ban - mua;
        }

        public void output() {
            System.out.printf("%s %s %s %d %d %d\n", mmh, ten, dvi, mua, ban, ln);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        cnt = 0;
        List<hang> v = new ArrayList<>(); // ArrayList instead of Vector

        for (int i = 0; i < t; i++) {
            String ten = in.nextLine();
            String dvi = in.nextLine();
            long mua = in.nextLong();
            long ban = in.nextLong();
            in.nextLine(); // Consume the leftover newline
            hang a = new hang(ten, dvi, mua, ban);
            v.add(a);
        }
        v.sort((hang a, hang b)->{
            if(a.ln==b.ln){
                return a.mmh.compareTo(b.mmh);
            }
            else{
                if(a.ln>b.ln) return -1;
                else return 1;
            }
        });
        for (hang h : v) {
            h.output();
        }
    }
}