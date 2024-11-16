package quanLyBanAoNam.nhanVien;

import java.util.Scanner;

public class nhanVien {
    private boolean trangThai = true;
    private String id;
    private String ten;
    private String sdt;
    private String diaChi;
    private String email;
    Scanner sc = new Scanner(System.in);
    public nhanVien(){
    }
    public nhanVien(boolean trangThai, String id, String ten, String sdt, String diaChi, String email) {
        this.trangThai = trangThai;
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.email = email;
    }

    public void nhap(){
        System.out.print("Vui long nhap ID: ");
        this.id = sc.nextLine();
        System.out.print("Vui long nhap ten: ");
        this.ten = sc.nextLine();
        System.out.print("Vui long nhap so dien thoai: ");
        this.sdt = sc.nextLine();
        System.out.print("Vui long nhap dia chi: ");
        this.diaChi = sc.nextLine();
        System.out.print("Vui long nhap email: ");
        this.email = sc.nextLine();
    }

    @Override
    public String toString(){
        return("ID : " + this.id + "\n Ten: " + this.ten + "\n Dia chi : "
         + this.diaChi + "\n Email : " + this.email + "\n");
    }

    public String toString2(){  //toString cho nhập file
        return(this.trangThai + "#" + this.id + "#" + this.ten + "#" + this.sdt + "#" + this.diaChi + "#" + this.email);
    }

    public void xuat(){
        System.out.println("ID: " + id);
        System.out.println("Ten: " + ten);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("Email: " + email);
    }
    
    public boolean getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getSdt() {
        return sdt;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
