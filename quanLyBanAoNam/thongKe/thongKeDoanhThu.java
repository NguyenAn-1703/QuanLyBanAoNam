package quanLyBanAoNam.thongKe;

import java.text.NumberFormat;
import java.util.Locale;

import quanLyBanAoNam.Validate.Validate;
import quanLyBanAoNam.hoaDon.DS_HoaDon;
import quanLyBanAoNam.phieuNhap.DS_PhieuNhap;
import quanLyBanAoNam.phieuNhap.phieuNhap;

public class thongKeDoanhThu extends thongKe implements thongKeTheoThoiGian{
    private DS_HoaDon dsBan = new DS_HoaDon();
    @SuppressWarnings("deprecation")
    Locale locale = new Locale("en", "EN");
    NumberFormat nF = NumberFormat.getInstance(locale);


    @Override
    public void thongKeTong(){
        dsBan.docDSHoaDonTuFile();
        System.out.println("Tong so luong hoa don : " + this.dsBan.getSoLuong());
    }
    @Override
    public void Menu(){
        System.out.println("Vui long nhap lua chon :");
        System.out.println("1) Thong ke thang. ");
        System.out.println("2) Thong ke theo quy. ");
        System.out.println("3) Thong ke theo nam. ");
    }

    public void startUp(){
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
            else if(key.equals(3)){
                this.thongKeTheoNam();
                break;
            }
            else{
                System.out.println("Du lieu khong hop le, vui long nhap lai !!!");
            }
        }
    }

    @Override
    public void thongKeTheoThang(){
        String namBan;
        while(true){
            System.out.println("Nhap vao nam muon thong ke : ");
            namBan = sc.nextLine();
            if(Validate.isNam(namBan)){
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
        dsBan.docDSHoaDonTuFile();
        for(int i = 0; i < dsBan.getSoLuong(); i++){
            String txt[] = dsBan.getDs()[i].getNgayBan().split("-");
            if(txt[2].equals(namBan)){
                if(txt[1].equals("1")){     //dd/MM/yyyy
                    soLuongThang[0]++;
                    soTienNhapThang[0] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("2")){     //dd/MM/yyyy
                    soLuongThang[1]++;
                    soTienNhapThang[1] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("3")){     //dd/MM/yyyy
                    soLuongThang[2]++;
                    soTienNhapThang[2] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("4")){     //dd/MM/yyyy
                    soLuongThang[3]++;
                    soTienNhapThang[3] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("5")){     //dd/MM/yyyy
                    soLuongThang[4]++;
                    soTienNhapThang[4] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("6")){     //dd/MM/yyyy
                    soLuongThang[5]++;
                    soTienNhapThang[5] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("7")){     //dd/MM/yyyy
                    soLuongThang[6]++;
                    soTienNhapThang[6] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("8")){     //dd/MM/yyyy
                    soLuongThang[7]++;
                    soTienNhapThang[7] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("9")){     //dd/MM/yyyy
                    soLuongThang[8]++;
                    soTienNhapThang[8] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("10")){     //dd/MM/yyyy
                    soLuongThang[9]++;
                    soTienNhapThang[9] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("11")){     //dd/MM/yyyy
                    soLuongThang[10]++;
                    soTienNhapThang[10] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("12")){     //dd/MM/yyyy
                    soLuongThang[11]++;
                    soTienNhapThang[11] += dsBan.getDs()[i].getTongGia();
                } 
            }
        }
        for(int i = 0; i < 12; i++){
            System.out.println("So luong hoa don thang " + (i + 1) + " : " + soLuongThang[i]);
            System.out.println("Tong doanh thu thang : " + (i + 1) + " : " + nF.format(soTienNhapThang[i]));
        }
    }
    @Override
    public void thongKeTheoQuy(){
        String namBan;
        while(true){
            System.out.println("Nhap vao nam muon thong ke : ");
            namBan = sc.nextLine();
            if(Validate.isNam(namBan)){
                break;
            }
            else{
                System.out.println("Du lieu nhap khong hop le !!!");
            }
        }
        int[] soLuongQuy = new int[4];   //số lượng hóa đơn trong quý
        double[] soTienNhapQuy = new double[4];
        dsBan.docDSHoaDonTuFile();
        for(int i = 0; i < dsBan.getSoLuong(); i++){
            String txt[] = dsBan.getDs()[i].getNgayBan().split("-");
            if(txt[2].equals(dsBan)){
                if(txt[1].equals("1") || txt[1].equals("2") || txt[1].equals("3")){     //dd/MM/yyyy
                    soLuongQuy[0]++;
                    soTienNhapQuy[0] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("4") || txt[1].equals("5") || txt[1].equals("6")){     //dd/MM/yyyy
                    soLuongQuy[1]++;
                    soTienNhapQuy[1] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("7") || txt[1].equals("8") || txt[1].equals("9")){     //dd/MM/yyyy
                    soLuongQuy[2]++;
                    soTienNhapQuy[2] += dsBan.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("10") || txt[1].equals("11") || txt[1].equals("12")){     //dd/MM/yyyy
                    soLuongQuy[3]++;
                    soTienNhapQuy[3] += dsBan.getDs()[i].getTongGia();
                }  
            }
        }
        for(int i = 0; i < 4; i++){
            System.out.println("So luong hoa don quy " + (i + 1) + " : " + soLuongQuy[i]);
            System.out.println("Tong doanh thu quy " + (i + 1) + " : " + nF.format(soTienNhapQuy[i]));
        }
    }
    @Override
    public void thongKeTheoNam(){
        String namBan;
        while(true){
            System.out.println("Nhap vao nam muon thong ke : ");
            namBan = sc.nextLine();
            if(Validate.isNam(namBan)){
                break;
            }
            else{
                System.out.println("Du lieu nhap khong hop le !!!");
            }
        }
        int soLuongNam = 0;
        double soTienNhapNam = 0;
        dsBan.docDSHoaDonTuFile();
        for(int i = 0; i <  this.dsBan.getSoLuong(); i++){
            String txt[] = this.dsBan.getDs()[i].getNgayBan().split("-");
            if(txt[2].equals(namBan)){
                soLuongNam++;
                soTienNhapNam += this.dsBan.getDs()[i].getTongGia();
            }
        }
        System.out.println("So luong hoa don nam " + namBan + " : " + soLuongNam);
        System.out.println("Tong doanh thu nam : " + namBan + " : " + nF.format(soTienNhapNam));
    }
}
