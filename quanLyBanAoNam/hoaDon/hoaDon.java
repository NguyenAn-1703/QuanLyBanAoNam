package quanLyBanAoNam.hoaDon;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import quanLyBanAoNam.KhachHang.DS_KhachHang;
import quanLyBanAoNam.KhachHang.khachHang;
import quanLyBanAoNam.KhachHang.khuyenMai;
import quanLyBanAoNam.Validate.Validate;
import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.nhanVien.DSNV;
import quanLyBanAoNam.nhanVien.nhanVien;
import quanLyBanAoNam.sanPham.DS_Ao;

public class hoaDon {
    private String IDhoaDon;
    SimpleDateFormat dF = new SimpleDateFormat("dd-MM-yyyy");
    private String ngayBan = dF.format(new Date());
    private nhanVien NhanVien;
    private chiTietHoaDon[] dsChiTietHoaDon = new chiTietHoaDon[0];
    private int soLuongChiTiet = 0; //quản lý mảng chi tiết hóa đơn
    private double tongGia = 0;
    private khachHang KhachHang;
    private boolean trangThai = true;
    private DS_Ao dsBan = new DS_Ao();
    Scanner sc = new Scanner(System.in);
    @SuppressWarnings("deprecation")
    Locale locale = new Locale("en", "EN");
    NumberFormat nF = NumberFormat.getInstance(locale);
    
    public hoaDon(){};

    public hoaDon(String iDhoaDon, String ngayBan, nhanVien nhanVien, chiTietHoaDon[] dsChiTietHoaDon,
            int soLuongChiTiet, double tongGia, khachHang khachHang, boolean trangThai, DS_Ao dsBan) {
        this.IDhoaDon = iDhoaDon;
        this.ngayBan = ngayBan;
        this.NhanVien = nhanVien;
        this.dsChiTietHoaDon = dsChiTietHoaDon;
        this.soLuongChiTiet = soLuongChiTiet;
        this.tongGia = tongGia;
        this.KhachHang = khachHang;
        this.trangThai = trangThai;
        this.dsBan = dsBan;
    }

    public hoaDon(String iDhoaDon, String ngayBan, nhanVien nhanVien, double tongGia, khachHang KhachHang, 
    boolean trangThai) {
        this.IDhoaDon = iDhoaDon;
        this.ngayBan = ngayBan;
        this.NhanVien = nhanVien;
        this.tongGia = tongGia;
        this.KhachHang = KhachHang;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return keBien.ke2() + "Hoa don: " + "\n" + 
        "ID hoa don : '" + this.IDhoaDon + '\'' + 
        "\n" + this.toStringNhap() + keBien.ke2Nho() +
        "Tong tien : " + nF.format(this.tongGia) +
        "\n Ngay ban : " + this.ngayBan +
        "\n Nhan Vien Ban : '" + this.NhanVien.getTen() + '\'' +
        "\n Khach hang : " + this.KhachHang.getTen() +
        "   so dien thoai : " + this.KhachHang.getSdt() + '\n';
    }

    public String toStringNhap(){   //to string lấy các chi tiết hóa đơn
        String s = "";
        for(int i = 0; i < this.dsBan.getSoLuong(); i++){
            s += this.dsBan.getDs()[i].toString4();
            s += "So luong ban : " + this.dsChiTietHoaDon[i].getSoLuongChiTietBan() + "\n";
        }
        return(s);
    }

    public String toString2(){  //to string cho file
        String s = "";
        s += this.IDhoaDon + "#" + this.ngayBan + "#" + this.NhanVien.getId() + "#"
        + this.tongGia + "#" + this.KhachHang.getSdt() + "#" + this.trangThai + "\n";
        for(int i = 0; i < dsBan.getSoLuong(); i++){
            s += this.dsChiTietHoaDon[i].getIdChiTietBan() + "#"
            + this.dsChiTietHoaDon[i].getSoLuongChiTietBan() + "#";
        }
        s += "end";
        return(s);
    }

    public void them1ChiTietBan(chiTietHoaDon x){
        chiTietHoaDon[] dsChiTietHoaDonNew = 
        Arrays.copyOf(this.dsChiTietHoaDon, soLuongChiTiet + 1);
        dsChiTietHoaDonNew[soLuongChiTiet] = x;
        this.dsChiTietHoaDon = dsChiTietHoaDonNew;
        soLuongChiTiet++;
    }

    public void nhapHoaDon(){
        System.out.println("Ngay ban : " + this.ngayBan);

        DSNV q = new DSNV();
        q.docDSNVTuFile();
        while(true){    //kiểm tra nhân viên
            String key;
            System.out.print("Nhap ID nhan vien: ");
            key = sc.nextLine();
            String ID = key;
            if(q.getNhanVienByID(ID) != null){
                this.NhanVien = q.getNhanVienByID(ID);
                break;
            }
            else{
                System.out.println("Khong co nhan vien ID : " + ID + ", vui long nhap lai");
            }
        }

        DS_KhachHang r = new DS_KhachHang();
        r.docDSKHTuFile();
        while(true){    //Kiểm tra khách hàng
            String key;
            System.out.print("Nhap so dien thoai khach hang : ");
            key = sc.nextLine();
            String sdt = key;
            if(r.getKhachHangBySDT(sdt) != null){
                this.KhachHang = r.getKhachHangBySDT(sdt);
                break;
            }
            else{
                System.out.println("Khong co khach hang co so dien thoai : " + sdt + ", vui long nhap lai");
            }
        }

        DS_Ao p = new DS_Ao();
        p.docDSTuFile();
        while(true){    // bán 1 danh sách các áo có sẵn, nhấn y để kết thúc
            String key;
            System.out.println("Nhap vao id de them san pham ban, nhan y de hoan tat ban hang");
            key = sc.nextLine();
            if(key.equals("y")){
                break;
            }
            String ID = key;
            int n;  //lưu số lượng bán
            if(p.getAoByID(ID) != null){
                dsBan.them1Ao(p.getAoByID(ID));    // đã tăng biến soLuong trong class DS_Ao
                while(true){
                    System.out.print("Vui long nhap vao so luong muon ban : ");
                    String m = sc.nextLine();    // kiểm tra số lương bán
                    if(!m.isEmpty() && Validate.isNumber(m) &&
                     Integer.parseInt(m) <= p.getAoByID(ID).getSoLuongSP()){
                        n = Integer.parseInt(m);    //số lượng bán
                        break;
                    }
                    else{
                        System.out.println("So luong nhap khong duoc de trong, phai nho hon so luong ton kho !!!");
                    }
                }

                //thêm chi tiết hóa đơn cho dsChiTietHoaDon
                chiTietHoaDon x = new chiTietHoaDon(ID, n);
                them1ChiTietBan(x);
                //thêm chi tiết hóa đơn cho dsChiTietHoaDon
                int soLuongNew;
                while(true){    //kiểm tra số lượng tồn kho đủ bán
                    if(p.getAoByID(ID).getSoLuongSP() - n >= 0){
                        soLuongNew = p.getAoByID(ID).getSoLuongSP() - n;    // trừ số lượng trong danh sách tồn kho
                        break;
                    }
                    else{
                        System.out.println("San pham ton kho khong du !!!");
                    }
                }

                p.getAoByID(ID).setSoLuongSP(soLuongNew);
                p.ghiDSVaoFile();
            }
            else{
                System.out.println("Khong co ao id : " + ID + " ,Vui long nhap lai !");
            }
        }
        this.tongGia = this.tinhTongGia();
        this.apDungKhuyenMai();
        r.ghiDSKHVaoFile();
    }

    public double tinhTongGia(){    //tính tổng giá của một hóa đơn
        double tong = 0;
        for(int i = 0; i < this.dsBan.getSoLuong(); i++){
            tong += this.dsBan.getDs()[i].getGiaBanRa() * this.dsChiTietHoaDon[i].getSoLuongChiTietBan();
        }
        return(tong);
    }

    public double tinhLoiNhuan(){
        double tong = 0;
        for(int i = 0; i < this.dsBan.getSoLuong(); i++){
            tong += (this.dsBan.getDs()[i].getGiaBanRa() - this.dsBan.getDs()[i].getGiaNhapVao()) * 
            this.dsChiTietHoaDon[i].getSoLuongChiTietBan();
        }
        return(tong);
    }

    public void apDungKhuyenMai(){
        while(true){
            System.out.println("Khach hang co ap dung khuyen mai hay khong ? (y/n)");
            String key = sc.nextLine();
            if(key.equals("y")){
                double giaMoi = khuyenMai.apDungKhuyenMai(this.KhachHang.getTienTichLuy(),this.tongGia);
                double tienTichLuyMoi = this.KhachHang.getTienTichLuy() - (this.tongGia - giaMoi);
                this.KhachHang.setTienTichLuy(khuyenMai.tinhTienTichLuyMoi(tienTichLuyMoi,this.tongGia));
                setTongGia(giaMoi);
                break;
            }
            else if(key.equals("n")){
                this.KhachHang.setTienTichLuy(khuyenMai.tinhTienTichLuyMoi(this.KhachHang.getTienTichLuy(),this.tongGia));
                break;
            }
            else{
                System.out.println("Du lieu sai vui long nhap lai !!!");
            }
        }
        
    }

    public void xuat(){
        System.out.println(toString());
    }

    public String getIDHoaDon() {
        return IDhoaDon;
    }

    public void setIDHoaDon(String iDhoaDon) {
        IDhoaDon = iDhoaDon;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public nhanVien getNhanVien() {
        return NhanVien;
    }

    public void setNhanVien(nhanVien nhanVien) {
        NhanVien = nhanVien;
    }

    public chiTietHoaDon[] getDsChiTietHoaDon() {
        return dsChiTietHoaDon;
    }

    public void setDsChiTietHoaDon(chiTietHoaDon[] dsChiTietHoaDon) {
        this.dsChiTietHoaDon = dsChiTietHoaDon;
    }

    public int getSoLuongChiTiet() {
        return soLuongChiTiet;
    }

    public void setSoLuongChiTiet(int soLuongChiTiet) {
        this.soLuongChiTiet = soLuongChiTiet;
    }

    public double getTongGia() {
        return tongGia;
    }

    public void setTongGia(double tongGia) {
        this.tongGia = tongGia;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public DS_Ao getDsBan() {
        return dsBan;
    }

    public void setDsBan(DS_Ao dsBan) {
        this.dsBan = dsBan;
    }

    
}
