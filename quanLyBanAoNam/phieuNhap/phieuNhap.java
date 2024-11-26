package quanLyBanAoNam.phieuNhap;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.sanPham.DS_Ao;
import quanLyBanAoNam.taiKhoan.taiKhoan;
import quanLyBanAoNam.nhanVien.nhanVien;

public class phieuNhap{
    private String IDphieuNhap;
    SimpleDateFormat dF = new SimpleDateFormat("dd-MM-yyyy");
    private String ngayNhap = dF.format(new Date());
    private nhanVien NhanVien;
    private chiTietPhieuNhap[] dsChiTietPhieuNhap = new chiTietPhieuNhap[0];
    private int soLuongChiTiet = 0; //quản lý mảng chi tiết phiếu nhập
    private double tongGia = 0;
    private boolean trangThai = true;
    private DS_Ao dsNhap = new DS_Ao();
    public static Scanner sc = new Scanner(System.in);
    @SuppressWarnings("deprecation")
    Locale locale = new Locale("en", "EN");
    NumberFormat nF = NumberFormat.getInstance(locale);
    
    public phieuNhap(){};

    public phieuNhap(String iDphieuNhap, String ngayNhap, nhanVien nhanVien, chiTietPhieuNhap[] dsChiTietPhieuNhap,
            int soLuongChiTiet, double tongGia, boolean trangThai, DS_Ao dsNhap) {
        this.IDphieuNhap = iDphieuNhap;
        this.ngayNhap = ngayNhap;
        this.NhanVien = nhanVien;
        this.dsChiTietPhieuNhap = dsChiTietPhieuNhap;
        this.soLuongChiTiet = soLuongChiTiet;
        this.tongGia = tongGia;
        this.trangThai = trangThai;
        this.dsNhap = dsNhap;
    }

    public phieuNhap(String IDphieuNhap, String ngayNhap, nhanVien NhanVien, double tongGia, boolean trangThai){
        this.IDphieuNhap = IDphieuNhap;
        this.ngayNhap = ngayNhap;
        this.NhanVien = NhanVien;
        this.tongGia = tongGia;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return keBien.ke2() + "Phieu Nhap: " + "\n" + 
        "IDphieuNhap : '" + IDphieuNhap + '\'' 
        + "\n" + this.toStringNhap() + keBien.ke2Nho() +
        "Tong gia tien : " + nF.format(this.tongGia) + "\n" + 
        " ngayNhap : " + ngayNhap +
        "\n Nhan Vien Nhap : '" + this.NhanVien.getTen() + '\'' + '\n';
    }

    public String toStringNhap(){   // trả về chuỗi trong dsNhap
        String s = "";
        for(int i = 0; i < this.dsNhap.getSoLuong(); i++){
            s += this.dsNhap.getDs()[i].toString3();    //toString3 bên sản phẩm
            s += "So luong nhap : " + this.dsChiTietPhieuNhap[i].getSoLuongChiTietNhap() + "\n";
        }
        return(s);
    }

    public String toString2(){  //to string cho file
        String s = "";
        s += this.IDphieuNhap + "#" + this.ngayNhap + "#" + this.NhanVien.getId() + "#" + 
        this.tongGia + "#" + this.trangThai + "\n";
        for(int i = 0; i < dsNhap.getSoLuong(); i++){
            s += this.dsChiTietPhieuNhap[i].getIdChiTietNhap() + "#"
            + this.dsChiTietPhieuNhap[i].getSoLuongChiTietNhap() + "#";
        }
        s += "end";
        return(s);
    }

    public void them1ChiTietNhap(chiTietPhieuNhap x){
        chiTietPhieuNhap[] dsChiTietPhieuNhapNew = 
        Arrays.copyOf(this.dsChiTietPhieuNhap, soLuongChiTiet + 1);
        dsChiTietPhieuNhapNew[soLuongChiTiet] = x;
        this.dsChiTietPhieuNhap = dsChiTietPhieuNhapNew;
        soLuongChiTiet++;
    }

    public void nhapPhieuNhap(taiKhoan TaiKhoan){ 
        System.out.println("Ngay nhap: " + ngayNhap);

        this.NhanVien = TaiKhoan.getNhanVien();
        System.out.println("Nhan vien nhap : " + TaiKhoan.getNhanVien().getTen());
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
                dsNhap.them1Ao(p.getAoByID(ID));    // đã tăng biến soLuong trong class DS_Ao
                System.out.print("Vui long nhap vao so luong muon nhap hang : ");
                int n = Integer.parseInt(sc.nextLine());    //số lương nhập
                //thêm chi tiết nhập cho dsChiTietPhieuNhap
                chiTietPhieuNhap x = new chiTietPhieuNhap(ID, n);
                them1ChiTietNhap(x);
                //thêm chi tiết nhập cho dsChiTietPhieuNhap
                int soLuongNew = n + p.getAoByID(ID).getSoLuongSP();    // cộng số lượng trong danh sách tồn kho
                p.getAoByID(ID).setSoLuongSP(soLuongNew);
                p.ghiDSVaoFile();
            }
            else{
                System.out.println("Khong co ao id : " + ID + " ,Vui long nhap lai !");
            }
        }
        this.tongGia = this.tinhTongGia();
    }

    public double tinhTongGia(){
        double tong = 0;
        for(int i = 0; i < this.dsNhap.getSoLuong(); i++){
            tong += this.dsNhap.getDs()[i].getGiaNhapVao() * this.dsChiTietPhieuNhap[i].getSoLuongChiTietNhap();
        }
        return(tong);
    }

    public void xuat(){
        System.out.println(toString());
    }

    public String getIDphieuNhap() {
        return IDphieuNhap;
    }

    public void setIDphieuNhap(String IDphieuNhap) {
        this.IDphieuNhap = IDphieuNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }


    public nhanVien getNhanVien() {
        return NhanVien;
    }

    public void setNhanVien(nhanVien nhanVien) {
        this.NhanVien = nhanVien;
    }
    
    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public chiTietPhieuNhap[] getDsChiTietPhieuNhap() {
        return dsChiTietPhieuNhap;
    }

    public void setDsChiTietPhieuNhap(chiTietPhieuNhap[] dsChiTietPhieuNhap) {
        this.dsChiTietPhieuNhap = dsChiTietPhieuNhap;
    }

    public DS_Ao getDsNhap() {
        return dsNhap;
    }

    public void setDsNhap(DS_Ao dsNhap) {
        this.dsNhap = dsNhap;
    }

    public double getTongGia() {
        return tongGia;
    }

    public void setTongGia(double tongGia) {
        this.tongGia = tongGia;
    }

    
    
}
