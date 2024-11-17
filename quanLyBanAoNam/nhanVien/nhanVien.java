package quanLyBanAoNam.nhanVien;

import java.util.Scanner;
import quanLyBanAoNam.Validate.Validate;

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

    public boolean Validation(){
        if(!Validate.isNumber(id) || id.isEmpty()){
            System.out.println("Id khong duoc de trong va phai la so !!!");
            return(false);
        }
        else if(ten.isEmpty()){
            System.out.println("Ten khong duoc de trong !!!");
            return(false);
        }
        else if(!Validate.isPhoneNumber(sdt) |sdt.isEmpty()){
            System.out.println("So dien thoai khong duoc de trong va phai la 10 ky tu so !!!");
            return(false);
        }
        else if(diaChi.isEmpty()){
            System.out.println("Dia chi khong duoc de trong !!!");
            return(false);
        }
        else if(!Validate.isEmail(email) || email.isEmpty()){
            System.out.println("Email khong duoc de trong va phai dung dinh dang !!!");
            return(false);
        }
        return(true);
    }

    public void nhap(){
        while(true){
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
            if(this.Validation()){
                break;
            }
            else{
                System.out.println("Vui long nhap lai !!!");
            }
        }
        
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
