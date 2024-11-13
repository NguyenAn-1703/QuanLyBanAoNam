package quanLyBanAoNam.nhanVien;

import java.util.Scanner;

public class nhanVien {
    protected String id;
    protected String ten;
    protected String diaChi;
    protected String email;

    public nhanVien(){
    }

    public nhanVien(String id, String ten, String diaChi, String email){
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.email = email;
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

    public void nhap(Scanner scanner){
        System.out.print("Nhap ID: ");
        this.id = scanner.nextLine();
        System.out.print("Nhap ten: ");
        this.ten = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        this.diaChi = scanner.nextLine();
        System.out.print("Nhap email: ");
        this.email = scanner.nextLine();
    }

    public void xuat(){
        System.out.println("ID: " + id);
        System.out.println("Ten: " + ten);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("Email: " + email);
    }

    @Override
    public String toString(){
        return "ID: " + id + ", Ten: " + ten + ", Dia chi: " + diaChi + ", Email: " + email;
    }
}
