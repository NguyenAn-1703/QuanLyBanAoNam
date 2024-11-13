package quanLyBanAoNam.nhanVien;

import java.util.Scanner;
import java.io.*;

public class DSNV {
    private nhanVien[] ds;
    private int soLuong;
    public static Scanner sc = new Scanner(System.in);

    public DSNV(int kichThuoc) {
        ds = new nhanVien[kichThuoc];
        soLuong = 0;
    }

    public void nhap() {
        System.out.print("Nhap so luong nhan vien muon them: ");
        int n = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng trống

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin cho nhan vien thu " + (soLuong + 1) + ":");
            nhanVien nv = new nhanVien();
            nv.nhap(sc);
            ds[soLuong] = nv;
            soLuong++;
        }
    }

    public void xuat(){
        if (soLuong == 0){
            System.out.println("Danh sach nhan vien rong");
            return;
        }
        for (int i = 0; i < soLuong; i++){
            ds[i].xuat();
            System.out.println("----------------------");
        }
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

    public void timKiemTheoTen(){
        System.out.println("Vui long nhap ten nhan vien can tim: ");
        String Ten = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < soLuong; i++){
            if(ds[i].getTen().equalsIgnoreCase(Ten)){
                System.out.println("Thong tin cua nhan vien ten: " + Ten + ": ");
                ds[i].xuat();
                found = true;
            } 
            if(!found){
                System.out.println("Khong tim thay ten nhan vien can tim");
            }
        }
    }

    public nhanVien getNhanVienByID(String id){	
		for(int i = 0; i < soLuong; i++){
			if(ds[i].getId().equals(id)){
				return ds[i];
			}
		}
		System.out.println("Khong tim thay nhan vien trong danh sach !!!");
		return(null);
	}

    public void docDSNVTuFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null && soLuong < ds.length) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    nhanVien nv = new nhanVien(data[0], data[1], data[2], data[3]);
                    ds[soLuong] = nv;
                    soLuong++;
                }
            }
            System.out.println("Doc danh sach nhan vien tu file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi mo file doc: ");
        }
    }

    public void ghiDSNVVaoFile(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < soLuong; i++) {
                bw.write(ds[i].toString());
                bw.newLine();
            }
            System.out.println("Ghi danh sach nhan vien tu file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: ");
        }
    }
}
