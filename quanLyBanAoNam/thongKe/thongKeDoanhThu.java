package quanLyBanAoNam.thongKe;

import java.text.NumberFormat;
import java.util.Locale;

import quanLyBanAoNam.Validate.Validate;
import quanLyBanAoNam.hoaDon.DS_HoaDon;
import quanLyBanAoNam.keBien.keBien;

public class thongKeDoanhThu extends thongKe implements thongKeTheoThoiGian{
    private DS_HoaDon dsHoaDon = new DS_HoaDon();
    @SuppressWarnings("deprecation")
    Locale locale = new Locale("en", "EN");
    NumberFormat nF = NumberFormat.getInstance(locale);


    @Override
    public void thongKeTong(){
        dsHoaDon.docDSHoaDonTuFile();
        System.out.println("Tong so luong hoa don : " + this.dsHoaDon.getSoLuong());
    }
    @Override
    public void Menu(){
        System.out.println("Vui long nhap lua chon :");
        System.out.println("1) Thong ke thang. ");
        System.out.println("2) Thong ke theo quy. ");
        System.out.println("3) Thong ke theo nam. ");
        System.out.println("4) Thoat chuc nang. ");
    }

    public void startUp(){
        while(true){
            this.Menu();
            String key = sc.nextLine();
            if(key.equals("1")){
                this.thongKeTheoThang();
            }
            else if(key.equals("2")){
                this.thongKeTheoQuy();
            }
            else if(key.equals("3")){
                this.thongKeTheoNam();
            }
            else if(key.equals("4")){
                break;
            }
            else{
                System.out.println("Du lieu khong hop le, vui long nhap lai !!!");
            }
        }
    }

    @Override
    public void thongKeTheoThang(){
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

        int[] soLuongThang = new int[12];   //số lượng hóa đơn trong tháng
        double[] soTienBanThang = new double[12];
        double[] doanhThuThang = new double[12];
        for(int i = 0; i < 12; i++){
            soLuongThang[i] = 0;
        }
        for(int i = 0; i < 12; i++){
            soTienBanThang[i] = 0;
        }
        dsHoaDon.docDSHoaDonTuFile();
        for(int i = 0; i < dsHoaDon.getSoLuong(); i++){    //duyệt từng hóa đơn
            String txt[] = dsHoaDon.getDs()[i].getNgayBan().split("-");
            if(txt[2].equals(this.namThongKe)){  //xét giống năm thì tăng mảng
                for(int j = 0; j < 12; j++){   //so sánh với từng tháng
                    if(txt[1].equals(Integer.toString(j + 1))){
                        soLuongThang[j]++;
                        soTienBanThang[j] += dsHoaDon.getDs()[i].getTongGia(); 
                        doanhThuThang[j] += dsHoaDon.getDs()[i].tinhLoiNhuan();
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < 12; i++){
            keBien.keBienNho();
            System.out.println("So luong hoa don thang " + (i + 1) + " : " + soLuongThang[i]);
            System.out.println("Tong tien ban thang " + (i + 1) + " : " + nF.format(soTienBanThang[i]));
            System.out.println("Tong doanh thu thang " + (i + 1) + " : " + nF.format(doanhThuThang[i]));
        }
    }
    @Override
    public void thongKeTheoQuy(){
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
        int[] soLuongQuy = new int[4];   //số lượng hóa đơn trong quý
        double[] soTienNhapQuy = new double[4];
        double[] doanhThuQuy = new double[4];
        dsHoaDon.docDSHoaDonTuFile();
        for(int i = 0; i < dsHoaDon.getSoLuong(); i++){ //xét từng hóa đơn 
            String txt[] = dsHoaDon.getDs()[i].getNgayBan().split("-");
            if(txt[2].equals(this.namThongKe)){
                for(int j = 0; j < 4; j++){ //xét từng quý
                    for(int k = 0; k < 4; k++){ //xét từng tháng trong quý
                        if(txt[1].equals(Integer.toString((j * 3 + 1) + k))){
                            soLuongQuy[j]++;
                            soTienNhapQuy[j] += dsHoaDon.getDs()[i].getTongGia();
                            doanhThuQuy[j] += dsHoaDon.getDs()[i].tinhLoiNhuan();
                            break;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++){
            keBien.keBienNho();
            System.out.println("So luong hoa don quy " + (i + 1) + " : " + soLuongQuy[i]);
            System.out.println("Tong tien ban quy " + (i + 1) + " : " + nF.format(soTienNhapQuy[i]));
            System.out.println("Tong doanh thu quy " + (i + 1) + " : " + nF.format(doanhThuQuy[i]));
        }
    }
    @Override
    public void thongKeTheoNam(){
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
        int soLuongNam = 0;
        double soTienNhapNam = 0;
        double doanhThuNam = 0;
        dsHoaDon.docDSHoaDonTuFile();
        for(int i = 0; i <  this.dsHoaDon.getSoLuong(); i++){   //xét từng hóa đơn
            String txt[] = this.dsHoaDon.getDs()[i].getNgayBan().split("-");
            if(txt[2].equals(namThongKe)){
                soLuongNam++;
                soTienNhapNam += this.dsHoaDon.getDs()[i].getTongGia();
                doanhThuNam += this.dsHoaDon.getDs()[i].tinhLoiNhuan();
            }
        }
        keBien.keBienNho();
        System.out.println("So luong hoa don nam " + namThongKe + " : " + soLuongNam);
        System.out.println("Tong tien ban nam " + namThongKe + " : " + nF.format(soTienNhapNam));
        System.out.println("Tong doanh thu nam " + namThongKe + " : " + nF.format(doanhThuNam));
    }
}
