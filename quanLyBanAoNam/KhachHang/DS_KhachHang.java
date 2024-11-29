package quanLyBanAoNam.KhachHang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import quanLyBanAoNam.Validate.Validate;
import quanLyBanAoNam.keBien.keBien;

public class DS_KhachHang {
    
    private khachHang[] ds = new khachHang[0];
    private int soLuong = 0;
    public static Scanner sc = new Scanner(System.in);

    public DS_KhachHang(){
        
    }

    public DS_KhachHang(khachHang[] ds, int soLuong) {
        this.ds = ds;
        this.soLuong = soLuong;
    }


    public void Menu(){
        keBien.keBienNhanVien();
        System.out.println("Vui long nhap lua chon.");
        System.out.println("1) Them 1 khach hang.");
        System.out.println("2) Xuat danh sach khach hang.");
        System.out.println("3) Xoa khach hang.");
        System.out.println("4) Sua khach hang. ");
        System.out.println("5) Thoat chuc nang.");
    }

    public void startUp(){
        String key;
        while(true){
            this.Menu();
            key = sc.nextLine();
            if(key.equals("1")){
                this.them1KhachHang();
            }
            else if(key.equals("2")){
                this.xuat();
            }
            else if(key.equals("3")){
                this.xoaKhachHang();
            }
            else if(key.equals("4")){
                this.suaKhachHang();
            }
            else if(key.equals("5")){
                break;
            }
            else{
                System.out.println("Du lieu sai, vui long nhap lai !!!");
            }
        }
    }

    public void them1KhachHang(khachHang x){
        khachHang[] dsNew = Arrays.copyOf(this.ds, soLuong + 1); 
        dsNew[soLuong] = x;
        this.ds = dsNew;
        soLuong++;
        x.setID(Integer.toString(soLuong));
    }

    public void them1KhachHang(){
        this.docDSKHTuFile();
        khachHang x = new khachHang();
        x.nhap();
        them1KhachHang(x);
        this.ghiDSKHVaoFile();
    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < soLuong; i++){
            if(this.ds[i].getTrangThai() == true)
                s += this.ds[i].toString() + "\n";
        }
        return(s);
    }

    public String toString3(){  // toString cho nhập hàng và hóa đơn
        String s = "";
        for(int i = 0; i < soLuong; i++){
            s += this.ds[i].toString();
        }
        return(s);
    }

    public void xuat(){
        this.docDSKHTuFile();
        System.out.println(this.toString());
    }

    public khachHang getKhachHangByID(String id){	
        docDSKHTuFile();
        if(!id.equals("")){
            for(int i = 0; i < soLuong; i++){
                if(ds[i].getID().equals(id)){
                    return ds[i];
                }
            }
        }

		System.out.println("Khong tim thay khach hang trong danh sach !!!");
		return(null);
	}

    public khachHang getKhachHangBySDT(String sdt){	
        docDSKHTuFile();
        if(!sdt.equals("") && Validate.isPhoneNumber(sdt)){
            for(int i = 0; i < soLuong; i++){
                if(ds[i].getSdt().equals(sdt)){
                    return ds[i];
                }
            }
        }

		System.out.println("Khong tim thay khach hang trong danh sach !!!");
		return(null);
	}

    public void timKiemTheoID(){
        System.out.println("Vui long nhap ID khach can tim: ");
        String ID = sc.nextLine();
        khachHang x = getKhachHangByID(ID);
        if (x!= null){
            System.out.println("Thong tin cua khachHang id so: " + ID + ": ");
            x.xuat();
        }
        else{
            return;
        }
    }

    public void xoaKhachHang(){
        System.out.println("Vui long nhap ID khach hang can xoa: ");
        String ID = sc.nextLine();
        khachHang x = getKhachHangByID(ID);
        if (x!= null){
            x.setTrangThai(false);
            System.out.println("Da xoa khach hang ID " + ID + "\n");
            this.ghiDSKHVaoFile();
        }
        else{
            return;
        }
    }

    public static void MenuSua(){
        System.out.println("1) Sua ten.");
        System.out.println("2) Sua so dien thoai.");
        System.out.println("3) Thoat. ");
    }

    public void suaKhachHang(){
        System.out.println("Vui long nhap ID khach hang muon sua: ");
        String ID = sc.nextLine();
        khachHang x = getKhachHangByID(ID);
        if (x!= null){
            while(true){
                System.out.println("Vui long chon thong tin muon sua : ");
                MenuSua();
                String key = sc.nextLine();
                if(key.equals("1")){
                    System.out.println("Nhap ten moi cho khach hang : ");
                    String newName = sc.nextLine();
                    if(newName.isEmpty()){
                        System.out.println("Ten khong duoc de trong. ");
                    }
                    else{
                        x.setTen(newName);
                        System.out.println("Sua thanh cong !");
                    }
                }
                else if(key.equals("2")){
                    System.out.println("Nhap so dien thoai moi cho nhan vien : ");
                    String newSDT = sc.nextLine();
                    if(newSDT.isEmpty() || !Validate.isPhoneNumber(newSDT)){
                        System.out.println("So dien thoai khong duoc de trong va phai la 10 ky tu so. ");
                    }
                    else{
                        x.setSdt(newSDT);
                        System.out.println("Sua thanh cong !");
                    }
                }
                else if(key.equals("3")){
                    ghiDSKHVaoFile();
                    break;
                }
                else{
                    System.out.println("Du lieu khong hop le vui long nhap lai !!!");
                }
            }
        }
        else{
            return;
        }
    }

    public void docDSKHTuFile() {
        ds = new khachHang[0];
        soLuong = 0;
        try {
            FileReader file = new FileReader("khachHang.txt");
            BufferedReader br = new BufferedReader(file);
            String line;
            while ((line = br.readLine()) != null && !line.equals("")) {
                String[] data = line.split("#");
                boolean tT = Boolean.parseBoolean(data[0]);
                double tL = Double.parseDouble(data[4]);
                khachHang kH = new khachHang(tT, data[1], data[2], data[3], tL);
                this.them1KhachHang(kH);
            }
            br.close();
            file.close();
        } catch (IOException e) {
            System.out.println("Loi khi mo file doc: ");
        }
    }

    public void ghiDSKHVaoFile() {
        try {
            FileWriter file = new FileWriter("khachHang.txt", false);
            BufferedWriter bw = new BufferedWriter(file);
            for (int i = 0; i < this.soLuong; i++) {
                bw.write(ds[i].toString2());
                bw.newLine();
            }
            bw.close();
            file.close();

        } catch (IOException e) {
            System.out.println("Loi khi ghi file: ");
        }
    }
}
