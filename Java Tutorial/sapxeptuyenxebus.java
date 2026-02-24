import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
class TuyenXeBus {
    private String ma;
    private String hoTen;
    private String ngayDi;
    private String soHieuTuyen;
    private int soLuotDi;
    private String kieuNgay;
    private int doanhThu;

    private static int count = 1; // Biến đếm số tuyến xe buýt đã tạo

    public TuyenXeBus(String hoTen, String ngayDi, String soHieuTuyen, int soLuotDi, String kieuNgay) {
        this.hoTen = hoTen;
        this.ngayDi = ngayDi;
        this.soHieuTuyen = soHieuTuyen;
        this.soLuotDi = soLuotDi;
        this.kieuNgay = kieuNgay;
        this.ma = "HN" + soHieuTuyen + String.format("%02d", count++);
        this.doanhThu = tinhDoanhThu();
    }

    private int tinhDoanhThu() {
        int giaVe;
        if (soLuotDi < 5) {
            giaVe = 800;
        } else if (soLuotDi <= 10) {
            giaVe = 780;
        } else {
            giaVe = 750;
        }

        int doanhThu = soLuotDi * giaVe;

        // Tăng doanh thu nếu ngày nghi hoặc lễ
        if (kieuNgay.equalsIgnoreCase("nghi")) {
            doanhThu *= 1.1;
        } else if (kieuNgay.equalsIgnoreCase("le")) {
            doanhThu *= 1.2;
        }

        return (int) Math.round(doanhThu); // Làm tròn doanh thu
    }
    public int getDoanhThu(){
        return doanhThu;
    }
    public String getMa(){
        return ma;
    }
    @Override
    public String toString() {
        return ma + " " + hoTen + " " + ngayDi + " " + soHieuTuyen + " " + soLuotDi + " " + kieuNgay + " " + doanhThu;
    }
}

public class sapxeptuyenxebus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.print("Nhập số tuyến xe buýt: ");
        int soTuyen = Integer.parseInt(scanner.nextLine());
        List<TuyenXeBus> tuyenXeBuses = new ArrayList<>();

        for (int i = 0; i < soTuyen; i++) {
            //System.out.println("Nhập thông tin cho tuyến xe buýt " + (i + 1) + ":");
           // System.out.print("Họ tên tài xế: ");
            String hoTen = scanner.nextLine();
           // System.out.print("Ngày đi (dd/MM/yyyy): ");
            String ngayDi = scanner.nextLine();
            //System.out.print("Số hiệu tuyến: ");
            String soHieuTuyen = scanner.nextLine();
            //System.out.print("Số lượt đi được: ");
            int soLuotDi = Integer.parseInt(scanner.nextLine());
           // System.out.print("Kiểu ngày (thuong/nghi/le): ");
            String kieuNgay = scanner.nextLine();

            TuyenXeBus tuyenXeBus = new TuyenXeBus(hoTen, ngayDi, soHieuTuyen, soLuotDi, kieuNgay);
            tuyenXeBuses.add(tuyenXeBus);
        }
        Collections.sort(tuyenXeBuses, new Comparator<TuyenXeBus>() {
            public int compare(TuyenXeBus o1, TuyenXeBus o2){
                if(o1.getDoanhThu() != o2.getDoanhThu()){
                    return Integer.compare(o2.getDoanhThu(),o1.getDoanhThu());
                }
                return o2.getMa().compareTo(o1.getMa());
            }
        });
        // In thông tin các tuyến xe buýt
        for (TuyenXeBus tuyenXeBus : tuyenXeBuses) {
            System.out.println(tuyenXeBus);
        }
    }
}