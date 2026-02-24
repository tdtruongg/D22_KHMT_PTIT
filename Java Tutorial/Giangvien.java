import java.util.Scanner;

class Giangvien {
    private String maGV;
    private String hoTen;
    private int luongCoBan;
    private String heSoKhuyenKhich;

    public Giangvien() {
    }

    public void input() {
        Scanner in = new Scanner(System.in);
        maGV = in.nextLine();
        hoTen = in.nextLine();
        luongCoBan = Integer.parseInt(in.nextLine());
        heSoKhuyenKhich = in.nextLine();
    }

    private double getHeSoKhuyenKhich() {
        switch (heSoKhuyenKhich) {
            case "A":
                return 1.5;
            case "B":
                return 1.2;
            case "C":
                return 1.0;
            default:
                return 1.0;
        }
    }

    public long getThuNhap() {
        double heSo = getHeSoKhuyenKhich();
        return (long) (luongCoBan * heSo * 250000);
    }

    public void out() {
        double thuNhap = getThuNhap();
        System.out.println(maGV + " " + hoTen + " " + heSoKhuyenKhich + " " + String.format("%.0f",thuNhap));
    }

    public static void main(String[] args) {
        Giangvien gv = new Giangvien();
        gv.input();
        gv.out();
    }
}