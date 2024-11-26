package quanLyBanAoNam.dangNhap;

import java.util.Scanner;

import quanLyBanAoNam.KhachHang.DS_KhachHang;
import quanLyBanAoNam.hoaDon.DS_HoaDon;
import quanLyBanAoNam.nhanVien.DSNV;
import quanLyBanAoNam.phieuNhap.DS_PhieuNhap;
import quanLyBanAoNam.sanPham.DS_Ao;
import quanLyBanAoNam.taiKhoan.DS_TaiKhoan;
import quanLyBanAoNam.taiKhoan.taiKhoan;
import quanLyBanAoNam.thongKe.thongKeDoanhThu;
import quanLyBanAoNam.thongKe.thongKeDonNhap;

public class dangNhap {
    private static taiKhoan TaiKhoan;
	public static DS_PhieuNhap pn = new DS_PhieuNhap();
	public static DS_Ao a = new DS_Ao();
	public static DSNV nv = new DSNV();
	public static DS_HoaDon hd = new DS_HoaDon();
	public static DS_KhachHang kh = new DS_KhachHang();
	public static DS_TaiKhoan tk = new DS_TaiKhoan();
	public static thongKeDonNhap tkn = new thongKeDonNhap();
	public static thongKeDoanhThu tkb = new thongKeDoanhThu();
    public static Scanner sc = new Scanner(System.in);

    public dangNhap(){

    }

    public static taiKhoan dangNhapTaiKhoan(){	//trả về true nếu dùng chọn khác lựa chọn thoát chương trình, ngược lại trả về false
        DS_TaiKhoan p = new DS_TaiKhoan();
		p.docDSTaiKhoanTuFile();
		while(true){		//  nhấn x để thoát chương trình
			String tenDN;
			System.out.println("Nhan phim ENTER vao dang nhap, nhan 'x' de thoat. ");
			String key = sc.nextLine();
			if(key.equals("x")){
				return(null);
			}

			while (true){
				System.out.println("1. Vui long nhap ten dang nhap : ");
				tenDN = sc.nextLine();
				if(tenDN.equals("x")){
					break;
				}
				else if(p.getTaiKhoanByTenDangNhap(tenDN) != null){
					break;
				}
				else{
					System.out.println("Khong tim thay tai khoan trong danh sach !!!");
					System.out.println("Nhan x de thoat. ");
				}
			}

			while(true){
				System.out.println("2. Vui long nhap mat khau : ");
				String matKhau = sc.nextLine();
				if(matKhau.equals("x")){
					break;
				}
				else if(p.checkPassWord(tenDN, matKhau)){
                    System.out.println("Dang nhap thanh cong !");
                    return(p.getTaiKhoanByTenDangNhap(tenDN));  //thoát vòng lặp
				}
				else{
					System.out.println("Mat khau khong chinh xac !!!");
					System.out.println("Nhan x de thoat. ");
				}
			}
		}
	}

    public static void startUp(){
        while(true){
            System.out.println("DANG NHAP");
            TaiKhoan = dangNhapTaiKhoan();
            if(TaiKhoan == null){
                return;
            }
            else{
                if(TaiKhoan.getNhanVien().getQuyen().equals("ADMIN")){
                    while(true){
                        if(chucNangADMIN() == false){
                            System.out.println("Da thoat chuong trinh");
                            break;
                        }
                    }
                }
    
                else if(TaiKhoan.getNhanVien().getQuyen().equals("QL")){
                    while(true){
                        if(chucNangQuanLy() == false){
                            System.out.println("Da thoat chuong trinh");
                            break;
                        }
                    }
                }
    
                else if(TaiKhoan.getNhanVien().getQuyen().equals("NVNH")){
                    while(true){
                        if(chucNangNhapHang(TaiKhoan) == false){
                            System.out.println("Da thoat chuong trinh");
                            break;
                        }
                    }
                }
    
                else if(TaiKhoan.getNhanVien().getQuyen().equals("NVBH")){
                    while(true){
                        if(chucNangBanHang() == false){
                            System.out.println("Da thoat chuong trinh");
                            break;
                        }
                    }
                }

                break;
            }
        }
    }

    public static boolean chucNangADMIN(){  //trả về true nếu dùng chọn khác lựa chọn thoát chương trình, ngược lại trả về false
        while(true){
            MenuADMIN();
            String key = sc.nextLine();
            if(key.equals("1")){
                a.startUp();
                return(true);
            }
            else if(key.equals("2")){
                pn.nhapHang(TaiKhoan);
                return(true);
            }
            else if(key.equals("3")){
                nv.startUp();
                return(true);
            }
            else if(key.equals("4")){
                hd.banHang(TaiKhoan);
                return(true);
            }
            else if(key.equals("5")){
                kh.startUp();
                return(true);
            }
            else if(key.equals("6")){
                tk.startUp();
                return(true);
            }
            else if(key.equals("7")){
                tkn.startUp();
                return(true);
            }
            else if(key.equals("8")){
                tkb.startUp();
                return(true);
            }
            else if(key.equals("9")){
                return(false);
            }
            else{
                System.out.println("Du lieu khong hop le, vui long nhap lai !!!");
            }
        }
    }

    public static boolean chucNangQuanLy(){  //trả về true nếu dùng chọn khác lựa chọn thoát chương trình, ngược lại trả về false
        while(true){
            MenuQuanLy();
            String key = sc.nextLine();
            if(key.equals("1")){
                a.startUp();
                return(true);
            }
            else if(key.equals("2")){
                nv.startUp();
                return(true);
            }
            else if(key.equals("3")){
                kh.startUp();
                return(true);
            }
            else if(key.equals("4")){
                tkn.startUp();
                return(true);
            }
            else if(key.equals("5")){
                tkb.startUp();
                return(true);
            }
            else if(key.equals("6")){
                return(false);
            }
            else{
                System.out.println("Du lieu khong hop le, vui long nhap lai !!!");
            }
        }
    }

    public static boolean chucNangBanHang(){  //trả về true nếu dùng chọn khác lựa chọn thoát chương trình, ngược lại trả về false
        while(true){
            MenuBanHang();
            String key = sc.nextLine();
            if(key.equals("1")){
                hd.banHang(TaiKhoan);
                return(true);
            }
            else if(key.equals("2")){
                kh.startUp();
                return(true);
            }
            else if(key.equals("3")){
                tkn.startUp();
                return(true);
            }
            else if(key.equals("4")){
                tkb.startUp();
                return(true);
            }
            else if(key.equals("5")){
                return(false);
            }
            else{
                System.out.println("Du lieu khong hop le, vui long nhap lai !!!");
            }
        }
    }

    public static boolean chucNangNhapHang(taiKhoan TaiKhoan){  //trả về true nếu dùng chọn khác lựa chọn thoát chương trình, ngược lại trả về false
        while(true){
            MenuNhapHang();
            String key = sc.nextLine();
            if(key.equals("1")){
                pn.nhapHang(TaiKhoan);
                return(true);
            }
            else if(key.equals("2")){
                tkn.startUp();
                return(true);
            }
            else if(key.equals("3")){
                tkb.startUp();
                return(true);
            }
            else if(key.equals("4")){
                return(false);
            }
            else{
                System.out.println("Du lieu khong hop le, vui long nhap lai !!!");
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
        System.out.println("1) Quan Ly Ban Hang. ");
        System.out.println("2) Quan Ly Khach Hang. ");  
        System.out.println("3) Thong Ke Nhap Hang.");	
        System.out.println("4) Thong Ke Doanh Thu.");
        System.out.println("5) Thoat Chuong Trinh. ");
    }

    public static void MenuNhapHang(){
        System.out.println("---MENU CHUC NANG---");	
        System.out.println("1) Quan Ly Nhap Hang.");	
        System.out.println("2) Thong Ke Nhap Hang.");	
        System.out.println("3) Thong Ke Doanh Thu.");
        System.out.println("4) Thoat Chuong Trinh. ");
    }

}
