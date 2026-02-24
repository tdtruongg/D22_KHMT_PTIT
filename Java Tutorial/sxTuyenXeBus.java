import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class TuyenXB {
    
    private int ma;
    private String hoTen;
    private String ngayDi;
    private String soHieuTuyen;
    private int soLuotDi;
    private String kieuNgay;
    private int doanhThu;

    private static int count = 1;

    public tuyenXeBus(String hoTen, String ngayDi, String soHieuTuyen, int soLuotDi, String kieuNgay) {
        this.hoTen = hoTen;
        this.ngayDi = ngayDi;
        this.soHieuTuyen = soHieuTuyen;
        this.soLuotDi = soLuotDi;
        this.kieuNgay = kieuNgay;
        this.ma = "HN" + soHieuTuyen + String.format("%02d", count++);
        this.doanhThu = tinhDoanhThu();
    }

    private int tinhDoanhThu(){
        int giaVe;
        if(soLuotDi < 5){
            giaVe = 800;
        }else if(soLuotDi <= 10){
            giaVe = 780;
        }else{
            giaVe = 750;
        }

        int doanhThu = giaVe * soLuotDi;

        if (kieuNgay.equalsIgnoreCase("nghi")){
            doanhThu *= 1.1;
        }
        if (kieuNgay.equalsIgnoreCase("le")){
            doanhThu *= 1.2;
        }

        return (int) Math.round(doanhThu);
    }

    public int getDoanhThu(){
        return doanhThu;
    }

    public String getMa(){
        return ma;
    }

    @Override
    public String toString(){
        return ma + " " + " " + hoTen + " " + ngayDi + " " + soHieuTuyen + " " + soLuotDi + " " + kieuNgay + " " + doanhThu;
    }
    
}

public class sxTuyenXeBus {
        
}
