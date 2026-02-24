import java.util.Scanner;

class Sach {

    private String ma;
    private String ten;
    private String nhaXB;
    private double gia;
    private static int sMa = 1;

    public Sach(String ten, String nhaXB, double gia){
        this.ten = ten;
        this.nhaXB = nhaXB;
        this.gia = gia;
        this.ma = generateMa(nhaXB);
    }

    private String generateMa(String nhaXB){
        String[] words = nhaXB.split(" ");
        StringBuilder code = new StringBuilder();
        for(String word : words){
            code.append(word.charAt(0));
        }
        code.append(String.format("%03d", sMa++));
        return code.toString().toUpperCase();
    }

    public String getTen(){
        return ten;
    }

    public void setTen(String ten){
        this.ten = ten;
    }

    public String getNhaXB(){
        return nhaXB;
    }

    public void setNhaXB(String nhaXB){
        this.nhaXB = nhaXB;
    }

    public double getGia(){
        return gia;
    }

    public void setGia(double gia){
        this.gia = gia;
    }

    public String getMa(){
        return ma;
    }
}

public interface lSach {
    double getGiaBan();
}

class SachThamKhao extends Sach implements lSach{
    private boolean dungChung;

    public SachThamKhao(String ten, String nhaXB, double gia, boolean dungChung){
        super(ten, nhaXB, gia);
        this.dungChung = dungChung;
    }

    public void nhap(Scanner in){
        System.out.print("Nhập tên sách: ");
        setTen(in.nextLine());
        System.out.print("Nhập nhà xuất bản: ");
        setNhaXB(in.nextLine());
        System.out.print("Nhập giá sách ");
        setGia(in.nextDouble());
        System.out.print("Sách dùng chung (true/false): ");
        dungChung = in.nextBoolean();
        in.nextLine();
    }
    @Override
    public double getGiaBan(){
        double giaBan = getGia();
        if(getNhaXB().equalsIgnoreCase("giao duc")){
            giaBan *= 0.95;
        }
        if(dungChung){
            giaBan *= 0.9;
        }
        return Math.round(giaBan);
    }
    @Override
    public String toString(){
        return getMa() + " " + getTen() + " " + getNhaXB() + " " + (dungChung ? "Dung chung sgk": "khong") + " " + (int) getGiaBan();
    }
}

public class lSach {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SachThamKhao s = new SachThamKhao();
        ((SachThamKhao) s).nhap(in);
        System.out.println(s);
        ((SachThamKhao) s).nhap(in);
        System.out.println(s);
    }
}
