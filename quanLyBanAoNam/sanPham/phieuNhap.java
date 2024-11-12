package quanLyBanAoNam.sanPham;

import java.util.Date;
import java.util.Scanner;

public class phieuNhap{
    protected String IDphieuNhap;
    protected Date ngayNhap;
    protected String IDnhanVien;
    protected DS_Ao dsNhap = new DS_Ao();
    
    public phieuNhap(){};

    public phieuNhap(String IDphieuNhap, Date ngayNhap, String IDnhanVien, DS_Ao dsNhap) {
        this.IDphieuNhap = IDphieuNhap;
        this.ngayNhap = ngayNhap;
        this.IDnhanVien = IDnhanVien;
        this.dsNhap = dsNhap;
    }

    public String getIDphieuNhap() {
        return IDphieuNhap;
    }

    public void setIDphieuNhap(String IDphieuNhap) {
        this.IDphieuNhap = IDphieuNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getIDnhanVien() {
        return IDnhanVien;
    }

    public void setIDnhanVien(String IDnhanVien) {
        this.IDnhanVien = IDnhanVien;
    }

    Scanner sc = new Scanner(System.in);

    public void nhapNPhanTuDau(){
        System.out.println("Nhap ID phieu nhap: ");
        IDphieuNhap = sc.nextLine();
        System.out.println("Ngay nhap: " + new Date());
        ngayNhap = new Date();
        System.out.println("Nhap ID nhan vien: ");
        IDnhanVien = sc.nextLine();
        dsNhap.nhapNPhanTuDau();
    }

    public void them1Ao(ao x){
        dsNhap.them1Ao(x);
    }

    public void them1Ao(){
        dsNhap.them1Ao();
    }


    public void themKAo(){
        dsNhap.themKAo();
    }
    
    public void thongKe(){
        dsNhap.thongKe();
    }

    // public void ghiDSVaoFile(){
    // }

    // public void docDSAoTuFile(){}

    @Override
    public String toString() {
        return "Phieu Nhap: " +
        "IDphieuNhap='" + IDphieuNhap + '\'' +
        ", ngayNhap=" + ngayNhap +
        ", IDnhanVien='" + IDnhanVien + '\'' +
        '.';
    }

    public void xuat(){
        System.out.println(toString());
        dsNhap.xuat();
    }
}
