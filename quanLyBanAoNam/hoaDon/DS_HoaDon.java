package quanLyBanAoNam.hoaDon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import quanLyBanAoNam.KhachHang.DS_KhachHang;
import quanLyBanAoNam.KhachHang.khachHang;
import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.nhanVien.DSNV;
import quanLyBanAoNam.nhanVien.nhanVien;
import quanLyBanAoNam.sanPham.DS_Ao;
import quanLyBanAoNam.taiKhoan.taiKhoan;

public class DS_HoaDon {
    private hoaDon[] ds = new hoaDon[0];
    private int soLuong = 0;
    public static Scanner sc = new Scanner(System.in);

    public DS_HoaDon(){}

    public void them1HoaDon(hoaDon x){       //Nhập hàng 
        hoaDon[] dsnew = Arrays.copyOf(ds, soLuong + 1);
        dsnew[soLuong] = x;
        ds = dsnew;
        soLuong++;
        x.setIDHoaDon(Integer.toString(soLuong));
    }

    public void them1HoaDon(taiKhoan TaiKhoan){
        this.docDSHoaDonTuFile();
        hoaDon x = new hoaDon();
        x.nhapHoaDon(TaiKhoan);
        them1HoaDon(x);
        this.ghiDSHoaDonVaoFile();
    }

    public static void menuBan(){
        keBien.ke();
        System.out.println("Vui long nhap lua chon : ");
        System.out.println("1) Xuat danh sach san pham. "); // làm thêm phần xuất danh sách nhân viên
        System.out.println("2) Tao hoa don moi. ");
        System.out.println("3) Xuat danh sach hoa don.");
        System.out.println("4) Thoat chuc nang ban hang.");
    }

    public void banHang(taiKhoan TaiKhoan){
        DS_Ao p = new DS_Ao();
        while(true){
            String key;
            menuBan();
            key = sc.nextLine();
            if(key.equals("1")){
                p.xuat();
            }
            else if(key.equals("2")){
                this.them1HoaDon(TaiKhoan);
            }
            else if(key.equals("3")){
                this.xuat();
            }
            else if(key.equals("4")){
                break;
            }
            else{
                System.out.println("Du lieu nhap khong hop le !!!");
            }
        }
    }                                   

    // public void xoa(){   //bỏ chức năng này
    //     while(true){
    //         System.out.println("Vui long nhap vao id hoa don muon xoa : ");
    //         String ID = sc.nextLine();
    //         if(this.getHoaDonByID(ID) != null){
    //             if(!this.getHoaDonByID(ID).getTrangThai()){
    //                 System.out.println("Hoa don da duoc xoa");
    //                 return; 
    //             }
    //             System.out.println("Ban co chac chan muon huy hoa don ? (y/n) ");
    //             String key = sc.nextLine();
    //             if(key.equals("y")){
    //                 getHoaDonByID(ID).setTrangThai(false);
    //                 ghiDSHoaDonVaoFile();
    //                 System.out.println("Da xoa hoa don ID : " + ID);
    //                 break;
    //             }
    //             break;
    //         }
    //         else{
    //             return;
    //         }
    //     } 
    // }

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
        this.docDSHoaDonTuFile();
        System.out.println(this.toString());
    }

    public void docDSHoaDonTuFile(){
        this.ds = new hoaDon[0];     //Mỗi lần doc sẽ xóa hết phần tử
        this.soLuong = 0;
        try {
            FileReader file = new FileReader("hoaDon.txt");
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
                DS_KhachHang r = new DS_KhachHang();
                r.docDSKHTuFile();
                khachHang kH = r.getKhachHangBySDT(txt1[4]);
                boolean tT = Boolean.parseBoolean(txt1[5]);
                hoaDon x = new hoaDon(txt1[0], txt1[1], nV, tG, kH, tT); 
                line = br.readLine();
                String txt2[] = line.split("#");
                int k = 0;
                while(!txt2[2 * k].equals("end")){  // vì có thuộc tính id và số lượng nên = 2 * k phần tử
                    int y = Integer.parseInt(txt2[2 * k + 1]);  //chuyển số lượng
                    chiTietHoaDon ct = new chiTietHoaDon(txt2[2 * k], y);
                    x.them1ChiTietBan(ct);
                    k++;
                }   // hết vòng lặp thì k là số phần tử trong dsBan
                DS_Ao p = new DS_Ao();
                p.docDSTuFile();
                for(int i = 0; i < k; i++){     //đọc danh sách áo từ file sanPham.txt cho hóa đơn
                    String ID = x.getDsChiTietHoaDon()[i].getIdChiTietBan();
                    x.getDsBan().them1Ao(p.getAoByID(ID));
                }
                them1HoaDon(x);
            }
            br.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Loi khi mo file doc !!!");
            System.out.println(e);
        }
    }

    public void ghiDSHoaDonVaoFile(){
        try {
            FileWriter file = new FileWriter("hoaDon.txt", false);
            BufferedWriter bw = new BufferedWriter(file);
            for(int i = 0; i < this.soLuong; i++){
                bw.write(this.ds[i].toString2());
                bw.newLine();
            }
            bw.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Loi khi mo file ghi \n");
        }

    }

    public hoaDon getHoaDonByID(String ID){
        this.docDSHoaDonTuFile();
        if(!ID.equals("")){
            for(hoaDon i : this.ds){
                if(i.getIDHoaDon().equals(ID)){
                    return(i);
                }
            }
        }
        System.out.println("Khong tim thay hoa don trong danh sach !!!");
        return(null);
    }

    public hoaDon[] getDs() {
        return ds;
    }

    public void setDs(hoaDon[] ds) {
        this.ds = ds;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
}
