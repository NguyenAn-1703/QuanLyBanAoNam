package quanLyBanAoNam.taiKhoan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import quanLyBanAoNam.nhanVien.DSNV;
import quanLyBanAoNam.nhanVien.nhanVien;

public class DS_TaiKhoan {
    taiKhoan[] ds = new taiKhoan[0];
    int soLuong = 0;
    Scanner sc = new Scanner(System.in);

    public DS_TaiKhoan(taiKhoan[] ds, int soLuong) {
        this.ds = ds;
        this.soLuong = soLuong;
    }

    public DS_TaiKhoan() {
        
    }

    public static void Menu(){
        System.out.println("Vui long nhap lua chon : ");
        System.out.println("1) Them 1 tai khoan. ");
        System.out.println("2) Xoa 1 tai khoan. ");
        System.out.println("3) Xuat danh sach tai khoan. ");
        System.out.println("4) Thoat chuc nang. ");
    }

    public void startUp(){
        while(true){
            Menu();
            String key = sc.nextLine();
            if(key.equals("1")){
                this.them1TaiKhoan();
            }
            else if(key.equals("2")){
                this.xoa1TaiKhoan();
            }
            else if(key.equals("3")){
                this.xuat();
            }
            else if(key.equals("4")){
                break;
            }
            else{
                System.out.println("Du lieu khong hop le, vui long nhap lai !!!");
            }
        }
    }

    public void them1TaiKhoan(taiKhoan x){
        taiKhoan[] dsNew = Arrays.copyOf(this.ds, soLuong + 1);
        dsNew[soLuong] = x;
        this.ds = dsNew;
        soLuong++;
    }

    public void them1TaiKhoan(){
        this.docDSTaiKhoanTuFile();
        taiKhoan x = new taiKhoan();
        x.nhap();   // kiểm tra danh sách nhân viên trong hàm nhập rồi 
        if(this.getTaiKhoanByIDNhanVien(x.getNhanVien().getId()) != null){  //nhân viên đã được tạo tài khoản
            System.out.println("Nhan vien da duoc tao tai khoan, vui long nhap lai !!!");
            return;
        }
        them1TaiKhoan(x);

        this.ghiDSTaiKhoanVaoFile();
    }

    public void xoa1TaiKhoan(){
        this.docDSTaiKhoanTuFile();
        System.out.print("Vui long nhap vao ID tai khoan cua nhan vien muon xoa : ");
        String ID = sc.nextLine();
        if(!ID.isEmpty() && this.getTaiKhoanByIDNhanVien(ID) != null){
            this.getTaiKhoanByIDNhanVien(ID).setTrangThai(false);
            this.ghiDSTaiKhoanVaoFile();
            System.out.println("Da xoa tai khoan cua nhan vien ID : " + ID);
        }
        else{
            System.out.println("Khong tim thay tai khoan muon xoa !!!");
        }
    }

    public taiKhoan getTaiKhoanByIDNhanVien(String ID){
        this.docDSTaiKhoanTuFile();
        if(!ID.isEmpty()){
            for(int i = 0; i < this.soLuong; i++){
                if(this.ds[i].getNhanVien().getId().equals(ID)){
                    return(this.ds[i]);
                }
            }
        }
        // System.out.println("Khong tim thay tai khoan trong danh sach");
        return(null);
    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < this.soLuong; i++){
            if(this.ds[i].getTrangThai() == true){
                s += this.ds[i].toString();
            }
        }
        return(s);
    }

    public void xuat(){
        this.docDSTaiKhoanTuFile();
        System.out.println(this.toString());
    }

    public taiKhoan getTaiKhoanByTenDangNhap(String tenDN){
        this.docDSTaiKhoanTuFile();
        for(int i = 0; i < soLuong; i++){
            if(this.ds[i].getTenDangNhap().equals(tenDN)){
                return(this.ds[i]);
            }
        }
        return(null);
    }

    public boolean checkPassWord(String tenDN, String matKhau){
        this.docDSTaiKhoanTuFile();
        if(getTaiKhoanByTenDangNhap(tenDN).getMatKhau().equals(matKhau)){
            return(true);
        }
        return(false);
    }

    public void docDSTaiKhoanTuFile(){
        this.ds = new taiKhoan[0];
        this.soLuong = 0;
        try {
            FileReader file = new FileReader("taiKhoan.txt");
            BufferedReader br = new BufferedReader(file);
            
            String line = "";
            DSNV p = new DSNV();
            while(true){
                line = br.readLine();
                if(line == null || line.equals("")){
                    break;
                }
                String txt[] = line.split("#");
                boolean tT = Boolean.parseBoolean(txt[0]);
                nhanVien nV = p.getNhanVienByID(txt[1]);
                taiKhoan x = new taiKhoan(tT, nV, txt[2], txt[3]);
                this.them1TaiKhoan(x);
            }
            br.close();
            file.close();

        } catch (Exception e) {
            System.out.println("Loi khi mo file doc");
        }   
    }

    public void ghiDSTaiKhoanVaoFile(){
        try {
            FileWriter file = new FileWriter("taiKhoan.txt", false);
            BufferedWriter bw = new BufferedWriter(file);
            
            for(int i = 0; i < this.soLuong; i++){
                bw.write(this.ds[i].toString2());
                bw.newLine();
            }

            bw.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Loi khi mo file ghi .");
        }
    }
}
