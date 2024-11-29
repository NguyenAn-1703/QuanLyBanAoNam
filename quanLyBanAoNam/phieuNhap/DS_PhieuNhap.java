package quanLyBanAoNam.phieuNhap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.nhanVien.DSNV;
import quanLyBanAoNam.nhanVien.nhanVien;
import quanLyBanAoNam.sanPham.DS_Ao;
import quanLyBanAoNam.taiKhoan.taiKhoan;

public class DS_PhieuNhap {
    private phieuNhap[] ds = new phieuNhap[0];
    private int soLuong = 0;
    public static Scanner sc = new Scanner(System.in);

    public DS_PhieuNhap(){
        
    }

    public void them1PhieuNhap(phieuNhap x){       //Nhập hàng 
        phieuNhap[] dsnew = Arrays.copyOf(ds, soLuong + 1);
        dsnew[soLuong] = x;
        ds = dsnew;
        soLuong++;
        x.setIDphieuNhap(Integer.toString(soLuong));
    }

    public void them1PhieuNhap(taiKhoan TaiKhoan){
        this.docDSPhieuNhapTuFile();
        phieuNhap x = new phieuNhap();
        x.nhapPhieuNhap(TaiKhoan);
        them1PhieuNhap(x);
        this.ghiDSPhieuNhapVaoFile();
    }

    public static void menuNhap(){
        keBien.ke();
        System.out.println("Vui long nhap lua chon : ");
        System.out.println("1) Xuat danh sach san pham. "); // làm thêm phần xuất danh sách nhân viên
        System.out.println("2) Tao phieu nhap moi. ");
        System.out.println("3) Xuat danh sach phieu nhap.");
        System.out.println("4) Xoa phieu nhap. ");
        System.out.println("5) Thoat chuc nang nhap hang.");
    }

    public void nhapHang(taiKhoan TaiKhoan){
        DS_Ao p = new DS_Ao();
        while(true){
            String key;
            menuNhap();
            key = sc.nextLine();
            if(key.equals("1")){
                p.xuat();
            }
            else if(key.equals("2")){
                this.them1PhieuNhap(TaiKhoan);
            }
            else if(key.equals("3")){
                this.xuat();
            }
            else if(key.equals("4")){
                this.xoa();
            }
            else if(key.equals("5")){
                break;
            }
            else{
                System.out.println("Du lieu nhap khong hop le !!!");
            }
        }
    }                                   //Nhập hàng

    public void xoa(){
        while(true){
            System.out.println("Vui long nhap vao id phieu nhap muon xoa : ");
            String ID = sc.nextLine();
            if(this.getPhieuNhapByID(ID) != null){
                if(!this.getPhieuNhapByID(ID).getTrangThai()){
                    System.out.println("Phieu da duoc xoa");
                    return; 
                }
                System.out.println("Ban co chac chan muon huy phieu ? (y/n) ");
                String key = sc.nextLine();
                if(key.equals("y")){
                    getPhieuNhapByID(ID).setTrangThai(false);
                    ghiDSPhieuNhapVaoFile();
                    System.out.println("Da xoa phieu nhap ID : " + ID);
                    break;
                }
                break;
            }
            else{
                return;
            }
        }
        
    }

    @Override
    public String toString(){
        String s = "";
            for(int i = 0; i < soLuong; i++){
                if(ds[i].getTrangThai()){
                    s += ds[i].toString();
                }
            }
            return(s);
    }

    public void xuat(){
        this.docDSPhieuNhapTuFile();
        System.out.println(this.toString());
    }

    public void docDSPhieuNhapTuFile(){
        this.ds = new phieuNhap[0];     //Mỗi lần doc sẽ xóa hết phần tử
        this.soLuong = 0;
        try {
            FileReader file = new FileReader("phieuNhap.txt");
            BufferedReader br = new BufferedReader(file);
            String line = "";
            while(true){
                line = br.readLine();
                if(line == null || line.equals("")){
                    break;
                }
                String txt1[] = line.split("#");
                DSNV q = new DSNV();
                q.docDSNVTuFile();
                nhanVien nV = q.getNhanVienByID(txt1[2]);
                double tG = Double.parseDouble(txt1[3]);
                boolean tT = Boolean.parseBoolean(txt1[4]);
                phieuNhap x = new phieuNhap(txt1[0], txt1[1], nV, tG, tT); 
                line = br.readLine();
                String txt2[] = line.split("#");
                int k = 0;
                while(!txt2[2 * k].equals("end")){  // vì có thuộc tính id và số lượng nên = 2 * k phần tử
                    int y = Integer.parseInt(txt2[2 * k + 1]);  //chuyển số lượng
                    chiTietPhieuNhap ct = new chiTietPhieuNhap(txt2[2 * k], y);
                    x.them1ChiTietNhap(ct);
                    k++;
                }   // hết vòng lặp thì k là số phần tử trong dsNhap
                DS_Ao p = new DS_Ao();
                p.docDSTuFile();
                for(int i = 0; i < k; i++){     //đọc danh sách áo từ file sanPham.txt cho phiếu nhập
                    String ID = x.getDsChiTietPhieuNhap()[i].getIdChiTietNhap();
                    x.getDsNhap().them1Ao(p.getAoByID(ID));
                }
                them1PhieuNhap(x);
            }
            br.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Loi khi mo file doc !!!");
            System.out.println(e);
        }
    }

    public void ghiDSPhieuNhapVaoFile(){
        try {
            FileWriter file = new FileWriter("phieuNhap.txt", false);
            BufferedWriter bw = new BufferedWriter(file);
            for(int i = 0; i < this.soLuong; i++){
                bw.write(this.ds[i].toString2());
                bw.newLine();
            }
            bw.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Loi khi mo file ghi \n");
            System.out.println(e);
        }

    }

    public phieuNhap getPhieuNhapByID(String ID){
        this.docDSPhieuNhapTuFile();
        if(!ID.equals("")){
            for(phieuNhap i : this.ds){
                if(i.getIDphieuNhap().equals(ID)){
                    return(i);
                }
            }
        }
        System.out.println("Khong tim thay phieu nhap trong danh sach !!!");
        return(null);
    }

    public phieuNhap[] getDs() {
        return ds;
    }

    public void setDs(phieuNhap[] ds) {
        this.ds = ds;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
