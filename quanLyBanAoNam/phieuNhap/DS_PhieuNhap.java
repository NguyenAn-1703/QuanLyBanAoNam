package quanLyBanAoNam.phieuNhap;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.sanPham.DS_Ao;

public class DS_PhieuNhap {
    private phieuNhap[] ds = new phieuNhap[0];
    private static int soLuong = 0;
    Scanner sc = new Scanner(System.in);

    public DS_PhieuNhap(){
        
    }

    public void them1PhieuNhap(phieuNhap x){       //Nhập hàng 
        
        phieuNhap[] dsnew = Arrays.copyOf(ds, soLuong + 1);
        dsnew[soLuong] = x;
        ds = dsnew;
        soLuong++;
    }

    public static void menuNhap(){
        keBien.ke();
        System.out.println("Vui long nhap lua chon : ");
        System.out.println("1) Xuat danh sach san pham. "); // làm thêm phần xuất danh sách nhân viên
        System.out.println("2) Tao phieu nhap moi. ");
        System.out.println("3) Xuat danh sach phieu nhap.");
        System.out.println("4) Thoat chuc nang nhap hang.");
    }

    public void nhapHang(){
        DS_Ao p = new DS_Ao();
        while(true){
            String key;
            menuNhap();
            key = sc.nextLine();
            if(key.equals("1")){
                p.xuat();
            }
            else if(key.equals("2")){
                phieuNhap x = new phieuNhap();
                x.nhapPhieuNhap();
                them1PhieuNhap(x);
            }
            else if(key.equals("3")){
                this.xuat();
            }
            else if(key.equals("4")){
                break;
            }
            else{
                System.out.println("Du lieu nhap khong hop le !!!");
            }
        }
    }                                   //Nhập hàng

    @Override
    public String toString(){
        String s = "";
            for(int i = 0; i < soLuong; i++){
                s += ds[i].toString();
            }
            return(s);
    }

    public void xuat(){
        System.out.println(this.toString());
    }

    public void docDSPhieuNhapTuFile(){
        
    }

    public void ghiDSPhieuNhapVaoFile(){

    }

    public phieuNhap[] getDs() {
        return ds;
    }

    public void setDs(phieuNhap[] ds) {
        this.ds = ds;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    

}
