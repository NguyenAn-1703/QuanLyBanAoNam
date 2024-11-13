package quanLyBanAoNam.main;

import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.phieuNhap.DS_PhieuNhap;
import quanLyBanAoNam.phieuNhap.phieuNhap;
import quanLyBanAoNam.sanPham.DS_Ao;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// //test
		// DS_Ao a = new DS_Ao();
		// a.startUp();
		// //test
		
		// phieuNhap pn = new phieuNhap();
		// pn.nhapPhieuNhap();
		// pn.thongKe();
		// pn.xuat();

		DS_PhieuNhap p = new DS_PhieuNhap();
		DS_Ao a = new DS_Ao();

		while (true){
			System.out.println("MENU");
			System.out.println("1) Quan Ly San Pham.");
			System.out.println("2) Quan Ly Nhap Hang.");
			System.out.println("3) Thoat .");
			keBien.ke();
			String key;
			key = sc.nextLine();			
			if(key.equals("1")){
				a.startUp();
			}
			else if(key.equals("2")){
				p.nhapHang();
			}
			else if(key.equals("3")){
				break;
			}
			else{
				System.out.println("Nhap sai !");
			}
		}
		


	}
}


