package quanLyBanAoNam.phieuNhap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.sanPham.DS_Ao;
import quanLyBanAoNam.sanPham.ao;

public class phieuNhap{
    private String IDphieuNhap;
    private Date ngayNhap;
    private String IDnhanVien;
    private DS_Ao dsNhap = new DS_Ao();
    
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
        return keBien.ke2() + "Phieu Nhap: " + "\n" + 
        "IDphieuNhap : '" + IDphieuNhap + '\'' 
        + "\n" + dsNhap.toStringNhap() +
        ", ngayNhap : " + ngayNhap +
        " IDnhanVien : '" + IDnhanVien + '\'' + '\n';
    }

    public void nhapPhieuNhap(){
        System.out.println("Nhap ID phieu nhap: ");
        this.IDphieuNhap = sc.nextLine();
        Date dt = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy"); 
        System.out.println("Ngay nhap: " + dt1.format(dt));
        this.ngayNhap = dt;
        System.out.println("Nhap ID nhan vien: ");
        this.IDnhanVien = sc.nextLine();
        DS_Ao p = new DS_Ao();
        p.docDSTuFile();
        while(true){    // nhập 1 danh sách các áo có sẵn, nhấn y để kết thúc
            String key;
            System.out.println("Nhap vao id de them san pham nhap, nhan y de hoan tat nhap hang");
            key = sc.nextLine();
            if(key.equals("y")){
                break;
            }
            String ID = key;
            if(p.getAoByID(ID) != null){
                ao x = new ao(); x = p.getAoByID(ID);
                dsNhap.them1Ao(x);    // đã tăng biến soLuong trong class DS_Ao
                System.out.println("Vui long nhap vao so luong muon nhap hang : ");
                int n = Integer.parseInt(sc.nextLine());    
                int m = dsNhap.getSoLuong() - 1;    // chỉ số phần tử vừa thêm vào mảng dsNhap.ds
                dsNhap.getDs()[m].setSoLuongNhap(n) ; // thêm số lượng nhập cho danh sách nhập hàng
                int soLuongNew = n + p.getAoByID(ID).getSoLuongSP();    // cộng số lượng trong danh sách tồn kho
                p.getAoByID(ID).setSoLuongSP(soLuongNew);
                p.ghiDSVaoFile();
            }
            else{
                System.out.println("Vui long nhap lai !");
            }
        }
    }

    public void xuat(){
        System.out.println(toString());
    }

    
}
