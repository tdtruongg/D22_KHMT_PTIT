import java.util.Scanner;

class TienDien {
    private String hoten;
    private String loaiHo;
    private long csdau;
    private long cscuoi;

    public TienDien() {
    }

    public void input(Scanner in) {
        hoten = in.nextLine();
        loaiHo = in.nextLine();
        csdau = in.nextLong();
        cscuoi = in.nextLong();
        hoten = chuanHoa(hoten);
    }

    private String chuanHoa(String hoten) {
        hoten = hoten.trim().toLowerCase();
        String[] words = hoten.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)))
              .append(word.substring(1))
              .append(" ");
        }
        return sb.toString().trim();
    }

    private long getDinhMuc() {
        switch (loaiHo) {
            case "A":
                return 100;
            case "B":
                return 500;
            case "C":
                return 200;
            default:
                return 0;
        }
    }

    public long getTien() {
        long soDien = cscuoi - csdau;
        long dinhMuc = getDinhMuc();
        long tienTrongDinhMuc = Math.min(soDien, dinhMuc) * 450;
        long tienVuotDinhMuc = (soDien > dinhMuc) ? (soDien - dinhMuc) * 1000 : 0;
        return tienTrongDinhMuc + tienVuotDinhMuc;
    }

    public long getThue() {
        return (long) (getTien() * 0.05);
    }

    @Override
    public String toString() {
        long tien = getTien();
        long thue = getThue();
        long tongTien = tien + thue;
        return hoten + " " + tien + " " + thue + " " + tongTien;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TienDien td = new TienDien();
        td.input(in);
        System.out.println(td.toString());
    }
}