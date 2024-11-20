package quanLyBanAoNam.main;

import quanLyBanAoNam.KhachHang.DS_KhachHang;
import quanLyBanAoNam.hoaDon.DS_HoaDon;
import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.nhanVien.DSNV;
import quanLyBanAoNam.phieuNhap.DS_PhieuNhap;
import quanLyBanAoNam.sanPham.DS_Ao;
import quanLyBanAoNam.taiKhoan.DS_TaiKhoan;
import quanLyBanAoNam.thongKe.thongKeDoanhThu;
import quanLyBanAoNam.thongKe.thongKeDonNhap;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DS_PhieuNhap p = new DS_PhieuNhap();
		DS_Ao a = new DS_Ao();
		DSNV nv = new DSNV();
		DS_HoaDon hd = new DS_HoaDon();
		DS_KhachHang kh = new DS_KhachHang();
		DS_TaiKhoan tk = new DS_TaiKhoan();
		thongKeDonNhap tkn = new thongKeDonNhap();
		thongKeDoanhThu tkb = new thongKeDoanhThu();

		while (true){
			System.out.println("---MENU CHUC NANG---");	// tk gồm admin, nhân viên quản lý
			System.out.println("1) Quan Ly San Pham.");	// nhân viên bán hàng, nhân viên nhập hàng
			System.out.println("2) Quan Ly Nhap Hang.");	// Tự động lấy thông tin nhân viên ???
			System.out.println("3) Quan Ly Nhan Vien.");
			System.out.println("4) Quan Ly Ban Hang. ");
			System.out.println("5) Quan Ly Khach Hang. ");
			System.out.println("6) Quan Ly Tai Khoan. ");
			System.out.println("7) Thong Ke Nhap Hang.");	
			System.out.println("8) Thong Ke Doanh Thu.");
			System.out.println("9) Thoat Chuong Trinh. ");
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
				nv.startUp();
			}
			else if(key.equals("4")){
				hd.banHang();
			}
			else if(key.equals("5")){
				kh.startUp();
			}
			else if(key.equals("6")){
				tk.startUp();
			}
			else if(key.equals("7")){
				tkn.startUp();
			}
			else if(key.equals("8")){
				tkb.startUp();
			}
			else if(key.equals("9")){
				System.out.println("Da thoat chuong trinh !");
				break;
			}
			else{
				System.out.println("Du lieu sai, vui long nhap lai");
			}
		}
	}
}


