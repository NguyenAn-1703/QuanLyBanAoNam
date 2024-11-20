package quanLyBanAoNam.taiKhoan;

import java.util.Scanner;

import quanLyBanAoNam.nhanVien.DSNV;
import quanLyBanAoNam.nhanVien.nhanVien;

public class taiKhoan {
    private boolean trangThai = true;
    private nhanVien NhanVien;
    private String tenDangNhap;
    private String matKhau;     
    Scanner sc = new Scanner(System.in);

    public taiKhoan(){

    }

    public taiKhoan(boolean trangThai, nhanVien nhanVien, String tenDangNhap, String matKhau) {
        this.trangThai = trangThai;
        this.NhanVien = nhanVien;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public boolean validation(){
        if(this.tenDangNhap.isEmpty()){
            System.out.println("Ten dang nhap khong duoc de trong !!!");
            return(false);
        }
        else if(this.matKhau.isEmpty()){
            System.out.println("Mat khau khong duoc de trong !!!");
        }
        return(true);
    }

    public void nhap(){     //làm thêm nhân viên đã có tài khoản thì không tạo nữa
        DSNV p = new DSNV();
        p.docDSNVTuFile();
        while(true){
            System.out.print("Vui long chon nhap ID nhan vien muon them tai khoan : ");
            String ID = sc.nextLine();
            if(p.getNhanVienByID(ID) != null){
                this.NhanVien = p.getNhanVienByID(ID);
                break;
            }
            else{
                System.out.println("Vui long nhap lai !!!");
            }
        }

        while (true){
            System.out.print("Vui long nhap ten tai khoan : ");
            this.tenDangNhap = sc.nextLine();
            System.out.print("Vui long nhap mat khau : ");
            this.matKhau = sc.nextLine();
            if(this.validation()){
                break;
            }
            else{
                System.out.println("Vui long nhap lai !!!");
            }
        }

    }

    @Override
    public String toString() {
        return "Tai Khoan : [NhanVien : " + this.NhanVien.getTen() + "\tid : " +
        this.NhanVien.getId() + "\tTen dang nhap : " + this.tenDangNhap + "\tMat khau : " + this.matKhau + "] \n";
    }

    public String toString2(){  //toString cho file
        return(this.trangThai + "#" + this.NhanVien.getId() + "#" + this.tenDangNhap + "#" + this.matKhau);
    }

    public void xuat(){
        System.out.println(this.toString());
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public nhanVien getNhanVien() {
        return NhanVien;
    }

    public void setNhanVien(nhanVien nhanVien) {
        NhanVien = nhanVien;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
}
