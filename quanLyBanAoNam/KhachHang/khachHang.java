package quanLyBanAoNam.KhachHang;

import java.util.Scanner;

import quanLyBanAoNam.Validate.Validate;

public class khachHang {
    private boolean trangThai = true;
    private String id;                       // Mã số khách hàng
    private String sdt;
    private String ten;
    private double tienTichLuy = 0;
    Scanner sc = new Scanner(System.in);

    // Constructor
    public khachHang(){

    }

    public khachHang(boolean trangThai, String id, String sdt, String ten, double tienTichLuy) {
        this.trangThai = trangThai;
        this.id = id;
        this.sdt = sdt;
        this.ten = ten;
        this.tienTichLuy = tienTichLuy;
    }
    
    public boolean Validation(){
        if(!Validate.isNumber(id) || id.isEmpty()){
            System.out.println("Id khong duoc de trong va phai la so !!!");
            return(false);
        }
        else if(!Validate.isPhoneNumber(sdt) |sdt.isEmpty()){
            System.out.println("So dien thoai khong duoc de trong va phai la 10 ky tu so !!!");
            return(false);
        }
        else if(ten.isEmpty()){
            System.out.println("Ten khong duoc de trong !!!");
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
            if(this.Validation()){
                break;
            }
            else{
                System.out.println("Vui long nha lai !!!");
            }
        }
        
    }

    @Override
    public String toString() {
        return "khachHang [id = " + id + ", so dien thoai = " + sdt + ", ten = " + ten + ", tien tich luy = " + tienTichLuy + "]";
    }

    public String toString2(){  //to String cho file
        return(this.trangThai + "#" + this.id + "#" + this.sdt + "#" + this.ten + "#" + this.tienTichLuy);
    }

    public void xuat(){
        System.out.println(this.toString());
    }

    // Các getter và setter
    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public double getTienTichLuy() {
        return tienTichLuy;
    }

    public void setTienTichLuy(double tienTichLuy) {
        this.tienTichLuy = tienTichLuy;
    }
}
