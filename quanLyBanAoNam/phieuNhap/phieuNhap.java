package quanLyBanAoNam.phieuNhap;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.sanPham.DS_Ao;
import quanLyBanAoNam.sanPham.ao;

public class phieuNhap{
    private String IDphieuNhap;
    SimpleDateFormat dF = new SimpleDateFormat("dd-MM-yyyy");
    private String ngayNhap = dF.format(new Date());
    private String IDnhanVien;
    private chiTietPhieuNhap[] dsChiTietPhieuNhap = new chiTietPhieuNhap[0];
    private int soLuongChiTiet = 0; //quản lý mảng chi tiết
    private DS_Ao dsNhap = new DS_Ao();
    Scanner sc = new Scanner(System.in);
    
    public phieuNhap(){};

    public phieuNhap(String IDphieuNhap, String ngayNhap, String IDnhanVien, chiTietPhieuNhap[] dsChiTietPhieuNhap,
            DS_Ao dsNhap) {
        this.IDphieuNhap = IDphieuNhap;
        this.ngayNhap = ngayNhap;
        this.IDnhanVien = IDnhanVien;
        this.dsChiTietPhieuNhap = dsChiTietPhieuNhap;
        this.dsNhap = dsNhap;
    }

    public phieuNhap(String IDphieuNhap, String ngayNhap, String IDnhanVien){
        this.IDphieuNhap = IDphieuNhap;
        this.ngayNhap = ngayNhap;
        this.IDnhanVien = IDnhanVien;
    }

    @Override
    public String toString() {
        return keBien.ke2() + "Phieu Nhap: " + "\n" + 
        "IDphieuNhap : '" + IDphieuNhap + '\'' 
        + "\n" + this.toStringNhap() +
        " ngayNhap : " + ngayNhap +
        " IDnhanVien : '" + IDnhanVien + '\'' + '\n';
    }

    public String toStringNhap(){
        String s = "";
        for(int i = 0; i < this.dsNhap.getSoLuong(); i++){
            s += this.dsNhap.getDs()[i].toString3();
            s += "So luong nhap : " + this.dsChiTietPhieuNhap[i].getSoLuongChiTietNhap() + "\n";
        }
        return(s);
    }

    public String toString2(){  //to string cho file
        String s = "";
        s += this.IDphieuNhap + "#" + this.ngayNhap + "#" + this.IDnhanVien + "\n";
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

    public void nhapPhieuNhap(){
        System.out.println("Nhap ID phieu nhap: ");
        this.IDphieuNhap = sc.nextLine(); 
        System.out.println("Ngay nhap: " + ngayNhap);
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
                dsNhap.them1Ao(p.getAoByID(ID));    // đã tăng biến soLuong trong class DS_Ao
                System.out.println("Vui long nhap vao so luong muon nhap hang : ");
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

    public String getIDnhanVien() {
        return IDnhanVien;
    }

    public void setIDnhanVien(String IDnhanVien) {
        this.IDnhanVien = IDnhanVien;
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

    
    
}
