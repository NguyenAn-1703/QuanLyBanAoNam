package quanLyBanAoNam.dangNhap;

import java.util.Scanner;

import quanLyBanAoNam.taiKhoan.DS_TaiKhoan;
import quanLyBanAoNam.taiKhoan.taiKhoan;

public class dangNhap {
    DS_TaiKhoan ds = new DS_TaiKhoan();
    public static Scanner sc = new Scanner(System.in);

    public taiKhoan dangNhap(){	// trả về tài khoản của nhân viên đăng nhập, người dùng nhấn x trả về null
		this.ds.docDSTaiKhoanTuFile();
		while(true){		//  nhấn x để thoát chương trình
			String tenDN;
			System.out.println("Nhan phim ENTER vao dang nhap, nhan 'x' de thoat. ");
			String key = sc.nextLine();
			if(key.equals("x")){
				return(null);
			}

			while (true){
				System.out.println("1) Vui long nhap ten dang nhap : ");
				tenDN = sc.nextLine();
				if(tenDN.equals("x")){
					break;
				}
				else if(ds.getTaiKhoanByTenDangNhap(tenDN) != null){
					break;
				}
				else{
					System.out.println("Khong tim thay tai khoan trong danh sach !!!");
					System.out.println("Nhan x de thoat. ");
				}
			}

			while(true){
				System.out.println("2) Vui long nhap mat khau : ");
				String matKhau = sc.nextLine();
				if(matKhau.equals("x")){
					break;
				}
				else if(ds.checkPassWord(tenDN, matKhau)){
                    System.out.println("Dang nhap thanh cong !");
                    return(ds.getTaiKhoanByTenDangNhap(tenDN));
				}
				else{
					System.out.println("Mat khau khong chinh xac !!!");
					System.out.println("Nhan x de thoat. ");
				}
			}
		}
	}

    public static void MenuADMIN(){
        System.out.println("---MENU CHUC NANG---");
        System.out.println("1) Quan Ly San Pham.");	
        System.out.println("2) Quan Ly Nhap Hang.");	
        System.out.println("3) Quan Ly Nhan Vien.");
        System.out.println("4) Quan Ly Ban Hang. ");
        System.out.println("5) Quan Ly Khach Hang. ");
        System.out.println("6) Quan Ly Tai Khoan. ");
        System.out.println("7) Thong Ke Nhap Hang.");	
        System.out.println("8) Thong Ke Doanh Thu.");
        System.out.println("9) Thoat Chuong Trinh. ");
    }

    public static void MenuQuanLy(){
        System.out.println("---MENU CHUC NANG---");
        System.out.println("1) Quan Ly San Pham. ");	
        System.out.println("2) Quan Ly Nhan Vien. ");
        System.out.println("3) Quan Ly Khach Hang. ");
        System.out.println("4) Thong Ke Nhap Hang. ");	
        System.out.println("5) Thong Ke Doanh Thu. ");
        System.out.println("6) Thoat Chuong Trinh. ");
    }

    public static void MenuBanHang(){
        System.out.println("---MENU CHUC NANG---");
        System.out.println("1) Quan Ly San Pham.");     // chỉ được xem, thống kê, tìm kiếm	
        System.out.println("2) Quan Ly Ban Hang. ");
        System.out.println("3) Quan Ly Khach Hang. ");  // được thêm, sửa
        System.out.println("4) Thong Ke Nhap Hang.");	
        System.out.println("5) Thong Ke Doanh Thu.");
        System.out.println("6) Thoat Chuong Trinh. ");
    }

    public static void MenuNhapHang(){
        System.out.println("---MENU CHUC NANG---");
        System.out.println("1) Quan Ly San Pham.");	// chỉ được xem, thống kê, tìm kiếm, thêm 
        System.out.println("2) Quan Ly Nhap Hang.");	
        System.out.println("3) Thong Ke Nhap Hang.");	
        System.out.println("4) Thong Ke Doanh Thu.");
        System.out.println("5) Thoat Chuong Trinh. ");
    }

    // public static void startUpADMIN(){
    //     while(true){
    //         MenuADMIN();
    //         String key = sc.nextLine();
    //         if()
    //     }
    // }

}
