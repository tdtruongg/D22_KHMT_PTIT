import java.util.Scanner;

class NhanCong {
    private static int sma = 1;
    private String ma;
    private String hoVaten;
    private long luongNgay;
    private int soNgay;

    public NhanCong() {
        this.ma = String.format("NV%03d", sma++);
    }

    public void input(Scanner in) {
        hoVaten = in.nextLine();
        luongNgay = Long.parseLong(in.nextLine());
        soNgay = Integer.parseInt(in.nextLine());
    }

    public String getMa() {
        return ma;
    }

    public long getLuongThang() {
        long luongThang = luongNgay * soNgay;
        double thuong = 0;
        if (soNgay >= 25) {
            thuong = 0.2 * luongThang;
        } else if (soNgay >= 22) {
            thuong = 0.1 * luongThang;
        }
        return (long) (luongThang + thuong);
    }

    @Override
    public String toString() {
        return ma + " " + hoVaten + " " + getLuongThang();
    }
}

class QLNhanCong {
    private NhanCong[] a;

    public QLNhanCong(NhanCong[] a) {
        this.a = a;
    }

    public void out() {
        for (NhanCong nc : a) {
            System.out.println(nc);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        NhanCong[] nn = new NhanCong[n];
        for (int i = 0; i < n; i++) {
            nn[i] = new NhanCong();
            nn[i].input(in);
        }
        QLNhanCong q = new QLNhanCong(nn);
        q.out();
    }
}