package quanLyBanAoNam.nhanVien;

import java.util.Arrays;
import java.util.Scanner;

import quanLyBanAoNam.keBien.keBien;

import java.io.*;

public class DSNV {
    private nhanVien[] ds = new nhanVien[0];
    private int soLuong = 0;
    Scanner sc = new Scanner(System.in);

    public DSNV(){
        
    }

    public DSNV(nhanVien[] ds, int soLuong) {
        this.ds = ds;
        this.soLuong = soLuong;
    }

    public void Menu(){
        keBien.keBienNhanVien();
        System.out.println("Vui long nhap lua chon.");
        System.out.println("1) Them 1 nhan vien.");
        System.out.println("2) Xuat danh sach nhan vien.");
        System.out.println("3) Xoa nhan vien.");
        System.out.println("4) Sua nhan vien. ");
        System.out.println("5) Doc danh sach nhan vien tu file.");
        System.out.println("6) Ghi danh sach nhan vien vao file.");
        System.out.println("7) Thoat chuong trinh.");
    }

    public void startUp(){
        String key;
        while(true){
            this.Menu();
            key = sc.nextLine();
            if(key.equals("1")){
                this.them1NhanVien();
            }
            else if(key.equals("2")){
                this.xuat();
            }
            else if(key.equals("3")){
                this.xoaNhanVien();
            }
            else if(key.equals("4")){
                this.suaNhanVien();
            }
            else if(key.equals("5")){
                this.docDSNVTuFile();
            }
            else if(key.equals("6")){
                this.ghiDSNVVaoFile();
            }
            else if(key.equals("7")){
                break;
            }
            else{
                System.out.println("Du lieu sai, vui long nhap lai !!!");
            }
        }
    }

    public boolean existID(String ID){  //kiểm tra tồn tại id trong danh sách
        //docDSNVTuFile();
        for(nhanVien i : this.ds){
            if(i.getId().equals(ID)){
                return(true);
            }
        }
        return(false);
    }

    public void them1NhanVien(nhanVien x){
        nhanVien[] dsNew = Arrays.copyOf(this.ds, soLuong + 1); 
        dsNew[soLuong] = x;
        this.ds = dsNew;
        soLuong++;
    }

    public void them1NhanVien(){
        this.docDSNVTuFile();
        while(true){
            nhanVien x = new nhanVien();
            x.nhap();
            if(!this.existID(x.getId())){
                them1NhanVien(x);
                break;
            }
            else{
                System.out.println("ID bi trung, vui long nhap lai !!!");
            }
        }
        this.ghiDSNVVaoFile();
    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < soLuong; i++){
            if(this.ds[i].getTrangThai() == true)
                s += this.ds[i].toString();
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
        this.docDSNVTuFile();
        System.out.println(this.toString());
    }

    public nhanVien getNhanVienByID(String id){	
        docDSNVTuFile();
		for(int i = 0; i < soLuong; i++){
			if(ds[i].getId().equals(id)){
				return ds[i];
			}
		}
		System.out.println("Khong tim thay nhan vien trong danh sach !!!");
		return(null);
	}

    public void timKiemTheoID(){
        System.out.println("Vui long nhap ID nhan vien can tim: ");
        String ID = sc.nextLine();
        nhanVien x = getNhanVienByID(ID);
        if (x!= null){
            System.out.println("Thong tin cua nhan vien id so: " + ID + ": ");
            x.xuat();
        }
        else{
            return;
        }
    }

    // public void timKiemTheoTen(){
    //     System.out.println("Vui long nhap ten nhan vien can tim: ");
    //     String Ten = sc.nextLine();
    //     boolean found = false;

    //     for (int i = 0; i < soLuong; i++){
    //         if(ds[i].getTen().equalsIgnoreCase(Ten)){
    //             System.out.println("Thong tin cua nhan vien ten: " + Ten + ": ");
    //             ds[i].xuat();
    //             found = true;
    //         } 
    //         if(!found){
    //             System.out.println("Khong tim thay ten nhan vien can tim");
    //         }
    //     }
    // }

    public void xoaNhanVien(){
        System.out.println("Vui long nhap ID nhan vien can xoa: ");
        String ID = sc.nextLine();
        nhanVien x = getNhanVienByID(ID);
        if (x!= null){
            x.setTrangThai(false);
            System.out.println("Da xoa nhan vien ID " + ID + "\n");
            this.ghiDSNVVaoFile();
        }
        else{
            return;
        }
    }

    public static void MenuSua(){
        System.out.println("1) Sua ten.");
        System.out.println("2) Sua so dien thoai.");
        System.out.println("3) Sua dia chi.");
        System.out.println("4) Sua email.");
        System.out.println("5) Thoat. ");
    }

    public void suaNhanVien(){
        System.out.println("Vui long nhap ID nhan vien muon sua: ");
        String ID = sc.nextLine();
        nhanVien x = getNhanVienByID(ID);
        if (x!= null){
            while(true){
                System.out.println("Vui long chon thong tin muon sua : ");
                MenuSua();
                String key = sc.nextLine();
                if(key.equals("1")){
                    System.out.println("Nhap ten moi cho nhan vien : ");
                    String newName = sc.nextLine();
                    x.setTen(newName);
                    System.out.println("Sua thanh cong !");
                }
                else if(key.equals("2")){
                    System.out.println("Nhap so dien thoai moi cho nhan vien : ");
                    String newSDT = sc.nextLine();
                    x.setSdt(newSDT);
                    System.out.println("Sua thanh cong !");
                }
                else if(key.equals("3")){
                    System.out.println("Nhap dia chi moi cho nhan vien : ");
                    String newDiaChi = sc.nextLine();
                    x.setDiaChi(newDiaChi);
                    System.out.println("Sua thanh cong !");
                }
                else if(key.equals("4")){
                    System.out.println("Nhap email moi cho nhan vien : ");
                    String newEmail = sc.nextLine();
                    x.setEmail(newEmail);
                    System.out.println("Sua thanh cong !");
                }
                else if(key.equals("5")){
                    ghiDSNVVaoFile();
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


    public void docDSNVTuFile() {
        ds = new nhanVien[0];
        soLuong = 0;
        try {
            FileReader file = new FileReader("nhanVien.txt");
            BufferedReader br = new BufferedReader(file);
            String line;
            while ((line = br.readLine()) != null && !line.equals("")) {
                String[] data = line.split("#");
                boolean tT = Boolean.parseBoolean(data[0]);
                nhanVien nv = new nhanVien(tT, data[1], data[2], data[3], data[4], data[5]);
                this.them1NhanVien(nv);
            }
            br.close();
            file.close();
        } catch (IOException e) {
            System.out.println("Loi khi mo file doc: ");
        }
    }

    public void ghiDSNVVaoFile() {
        try {
            FileWriter file = new FileWriter("nhanVien.txt", false);
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
