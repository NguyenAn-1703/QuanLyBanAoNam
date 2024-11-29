package quanLyBanAoNam.thongKe;

import quanLyBanAoNam.Validate.Validate;
import quanLyBanAoNam.hoaDon.DS_HoaDon;
import quanLyBanAoNam.hoaDon.hoaDon;
import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.phieuNhap.DS_PhieuNhap;
import quanLyBanAoNam.phieuNhap.phieuNhap;
import quanLyBanAoNam.sanPham.DS_Ao;

public class thongKeSanPham extends thongKe{
    private DS_Ao dsAo = new DS_Ao();
    private DS_PhieuNhap dsPhieuNhap = new DS_PhieuNhap();
    private DS_HoaDon dsHoaDon = new DS_HoaDon();

    public void Menu(){
        System.out.println("Vui long nhap lua chon :");
        System.out.println("1) Thong ke ao ban theo thang. ");
        System.out.println("2) Thong ke ao nhap theo thang. ");
        System.out.println("3) Thong ke ao ban theo quy. ");
        System.out.println("4) Thong ke ao nhap theo quy. ");
        System.out.println("5) Thong ke ao ban theo nam. ");
        System.out.println("6) Thong ke ao nhap theo nam. ");
        System.out.println("7) Thoat chuc nang. ");
    }

    public void startUp(){
        thongKeTong();
        while(true){
            this.Menu();
            String key = sc.nextLine();
            if(key.equals("1")){
                this.thongKeBanTheoThang();
                break;
            }
            if(key.equals("2")){
                this.thongKeNhapTheoThang();
                break;
            }
            else if(key.equals("3")){
                this.thongKeBanTheoQuy();
                break;
            }
            else if(key.equals("4")){
                this.thongKeNhapTheoQuy();
                break;
            }
            else if(key.equals("5")){
                this.thongKeBanTheoNam();
                break;
            }
            else if(key.equals("6")){
                this.thongKeNhapTheoNam();
                break;
            }
            else if(key.equals("7")){
                break;
            }
            else{
                System.out.println("Du lieu khong hop le, vui long nhap lai !!!");
            }
        }
    }

    @Override
    public void thongKeTong(){
        dsAo.docDSTuFile();
        System.out.println("Tong so luong ao : " + this.dsAo.getSoLuong());
    }

    public int tongSoLuongAoBan(hoaDon x){
        int tong = 0;
        for(int i = 0; i < x.getSoLuongChiTiet(); i++){    //duyệt từng chi tiết
            tong += x.getDsChiTietHoaDon()[i].getSoLuongChiTietBan();
        }
        return(tong);
    }

    public int tongSoLuongAoNhap(phieuNhap x){
        int tong = 0;
        for(int i = 0; i <= x.getSoLuongChiTiet(); i++){    //duyệt từng chi tiết
            tong += x.getDsChiTietPhieuNhap()[i].getSoLuongChiTietNhap();
        }
        return(tong);
    }

    public void thongKeBanTheoThang(){
        while(true){
            System.out.println("Nhap vao nam muon thong ke : ");
            this.namThongKe = sc.nextLine();
            if(Validate.isYear(this.namThongKe)){
                break;
            }
            else{
                System.out.println("Du lieu nhap khong hop le !!!");
            }
        }

        int[] soLuongAoThang = new int[12];   

        dsHoaDon.docDSHoaDonTuFile();
        for(int i = 0; i < dsHoaDon.getSoLuong(); i++){    //duyệt từng hóa đơn
            String txt[] = dsHoaDon.getDs()[i].getNgayBan().split("-");
            if(txt[2].equals(this.namThongKe)){  //xét giống năm thì tăng mảng
                for(int j = 0; j < 12; j++){   //so sánh với từng tháng
                    if(txt[1].equals(Integer.toString(j + 1))){
                        soLuongAoThang[j] += tongSoLuongAoBan(dsHoaDon.getDs()[i]);
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < 12; i++){
            keBien.keBienNho();
            System.out.println("So luong ao ban thang " + (i + 1) + " : " + soLuongAoThang[i]);
        }
    }

    public void thongKeNhapTheoThang(){
        while(true){
            System.out.println("Nhap vao nam muon thong ke : ");
            this.namThongKe = sc.nextLine();
            if(Validate.isYear(this.namThongKe)){
                break;
            }
            else{
                System.out.println("Du lieu nhap khong hop le !!!");
            }
        }

        int[] soLuongAoThang = new int[12];   

        dsPhieuNhap.docDSPhieuNhapTuFile();
        for(int i = 0; i < dsPhieuNhap.getSoLuong(); i++){    //duyệt từng hóa đơn
            String txt[] = dsPhieuNhap.getDs()[i].getNgayNhap().split("-");
            if(txt[2].equals(this.namThongKe)){  //xét giống năm thì tăng mảng
                for(int j = 0; j < 12; j++){   //so sánh với từng tháng
                    if(txt[1].equals(Integer.toString(j + 1))){
                        soLuongAoThang[j] += tongSoLuongAoNhap(dsPhieuNhap.getDs()[i]);
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < 12; i++){
            keBien.keBienNho();
            System.out.println("So luong ao nhap thang " + (i + 1) + " : " + soLuongAoThang[i]);
        }
    }

    public void thongKeBanTheoQuy(){
        while(true){
            System.out.println("Nhap vao nam muon thong ke : ");
            this.namThongKe = sc.nextLine();
            if(Validate.isYear(this.namThongKe)){
                break;
            }
            else{
                System.out.println("Du lieu nhap khong hop le !!!");
            }
        }
        int[] soLuongAoQuy = new int[4];
        dsHoaDon.docDSHoaDonTuFile();
        for(int i = 0; i < dsHoaDon.getSoLuong(); i++){ //xét từng đơn nhập 
            String txt[] = dsHoaDon.getDs()[i].getNgayBan().split("-");
            if(txt[2].equals(this.namThongKe)){
                for(int j = 0; j < 4; j++){ //xét từng quý
                    for(int k = 0; k < 4; k++){ //xét từng tháng trong quý
                        if(txt[1].equals(Integer.toString((j * 3 + 1) + k))){
                            soLuongAoQuy[j] += tongSoLuongAoBan(dsHoaDon.getDs()[i]);
                            break;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++){
            keBien.keBienNho();
            System.out.println("So luong ao ban quy " + (i + 1) + " : " + soLuongAoQuy[i]);
        }
    }

    public void thongKeNhapTheoQuy(){
        while(true){
            System.out.println("Nhap vao nam muon thong ke : ");
            this.namThongKe = sc.nextLine();
            if(Validate.isYear(this.namThongKe)){
                break;
            }
            else{
                System.out.println("Du lieu nhap khong hop le !!!");
            }
        }
        int[] soLuongAoQuy = new int[4];
        dsPhieuNhap.docDSPhieuNhapTuFile();
        for(int i = 0; i < dsPhieuNhap.getSoLuong(); i++){ //xét từng đơn nhập 
            String txt[] = dsPhieuNhap.getDs()[i].getNgayNhap().split("-");
            if(txt[2].equals(this.namThongKe)){
                for(int j = 0; j < 4; j++){ //xét từng quý
                    for(int k = 0; k < 4; k++){ //xét từng tháng trong quý
                        if(txt[1].equals(Integer.toString((j * 3 + 1) + k))){
                            soLuongAoQuy[j] += tongSoLuongAoNhap(dsPhieuNhap.getDs()[i]);
                            break;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++){
            keBien.keBienNho();
            System.out.println("So luong ao nhap quy " + (i + 1) + " : " + soLuongAoQuy[i]);
        }
    }

    public void thongKeBanTheoNam(){
        System.out.println("Nhap vao nam muon thong ke : ");
        namThongKe = sc.nextLine();
        int soLuongAoNam = 0;
        dsHoaDon.docDSHoaDonTuFile();
        for(int i = 0; i < this.dsHoaDon.getSoLuong(); i++){
            String txt[] = this.dsHoaDon.getDs()[i].getNgayBan().split("-");
            if(txt[2].equals(namThongKe)){
                soLuongAoNam += tongSoLuongAoBan(this.dsHoaDon.getDs()[i]);
            }
        }
        System.out.println("So luong ao ban nam " + namThongKe + " : " + soLuongAoNam);
    }

    public void thongKeNhapTheoNam(){
        System.out.println("Nhap vao nam muon thong ke : ");
        namThongKe = sc.nextLine();
        int soLuongAoNam = 0;
        dsPhieuNhap.docDSPhieuNhapTuFile();
        for(int i = 0; i < this.dsPhieuNhap.getSoLuong(); i++){
            String txt[] = this.dsPhieuNhap.getDs()[i].getNgayNhap().split("-");
            if(txt[2].equals(namThongKe)){
                soLuongAoNam += tongSoLuongAoNhap(this.dsPhieuNhap.getDs()[i]);
            }
        }
        System.out.println("So luong ao nhap nam " + namThongKe + " : " + soLuongAoNam);
    }
}
