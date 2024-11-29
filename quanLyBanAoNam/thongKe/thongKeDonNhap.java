package quanLyBanAoNam.thongKe;

import java.text.NumberFormat;
import java.util.Locale;

import quanLyBanAoNam.Validate.Validate;
import quanLyBanAoNam.keBien.keBien;
import quanLyBanAoNam.phieuNhap.DS_PhieuNhap;

public class thongKeDonNhap extends thongKe implements thongKeTheoThoiGian{
    private DS_PhieuNhap dsNhap = new DS_PhieuNhap();
    @SuppressWarnings("deprecation")
    public static Locale locale = new Locale("en", "EN");
    public static NumberFormat nF = NumberFormat.getInstance(locale);

    @Override
    public void thongKeTong(){
        dsNhap.docDSPhieuNhapTuFile();
        System.out.println("Tong so luong phieu nhap : " + this.dsNhap.getSoLuong());
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
        thongKeTong();
        while(true){
            this.Menu();
            String key = sc.nextLine();
            if(key.equals("1")){
                this.thongKeTheoThang();
                break;
            }
            else if(key.equals("2")){
                this.thongKeTheoQuy();
                break;
            }
            else if(key.equals("3")){
                this.thongKeTheoNam();
                break;
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
        double[] soTienNhapThang = new double[12];
        for(int i = 0; i < 12; i++){
            soLuongThang[i] = 0;
        }
        for(int i = 0; i < 12; i++){
            soTienNhapThang[i] = 0;
        }
        dsNhap.docDSPhieuNhapTuFile();
        for(int i = 0; i < dsNhap.getSoLuong(); i++){    //duyệt từng hóa đơn
            String txt[] = dsNhap.getDs()[i].getNgayNhap().split("-");
            if(txt[2].equals(this.namThongKe)){  //xét giống năm thì tăng mảng
                for(int j = 0; j < 12; j++){   //so sánh với từng tháng
                    if(txt[1].equals(Integer.toString(j + 1))){
                        soLuongThang[j]++;
                        soTienNhapThang[j] += dsNhap.getDs()[i].getTongGia(); 
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < 12; i++){
            keBien.keBienNho();
            System.out.println("So luong hoa don thang " + (i + 1) + " : " + soLuongThang[i]);
            System.out.println("Tong tien ban thang " + (i + 1) + " : " + nF.format(soTienNhapThang[i]));
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
        int[] soLuongQuy = new int[4];   //số lượng đơn nhập trong quý
        double[] soTienNhapQuy = new double[4];
        dsNhap.docDSPhieuNhapTuFile();
        for(int i = 0; i < dsNhap.getSoLuong(); i++){ //xét từng đơn nhập 
            String txt[] = dsNhap.getDs()[i].getNgayNhap().split("-");
            if(txt[2].equals(this.namThongKe)){
                for(int j = 0; j < 4; j++){ //xét từng quý
                    for(int k = 0; k < 4; k++){ //xét từng tháng trong quý
                        if(txt[1].equals(Integer.toString((j * 3 + 1) + k))){
                            soLuongQuy[j]++;
                            soTienNhapQuy[j] += dsNhap.getDs()[i].getTongGia();
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
        }
    }
    @Override
    public void thongKeTheoNam(){
        System.out.println("Nhap vao nam muon thong ke : ");
        namThongKe = sc.nextLine();
        int soLuongNam = 0;
        double soTienNhapNam = 0;
        dsNhap.docDSPhieuNhapTuFile();
        for(int i = 0; i < this.dsNhap.getSoLuong(); i++){
            String txt[] = this.dsNhap.getDs()[i].getNgayNhap().split("-");
            if(txt[2].equals(namThongKe)){
                soLuongNam++;
                soTienNhapNam += this.dsNhap.getDs()[i].getTongGia();
            }
        }
        System.out.println("So luong don nhap nam " + namThongKe + " : " + soLuongNam);
        System.out.println("Tong gia nhap nam : " + namThongKe + " : " + nF.format(soTienNhapNam));
    }
}
