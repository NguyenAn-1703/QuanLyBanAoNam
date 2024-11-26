package quanLyBanAoNam.thongKe;

import java.text.NumberFormat;
import java.util.Locale;

import quanLyBanAoNam.Validate.Validate;
import quanLyBanAoNam.phieuNhap.DS_PhieuNhap;
import quanLyBanAoNam.phieuNhap.phieuNhap;

public class thongKeDonNhap extends thongKe implements thongKeTheoThoiGian{
    private DS_PhieuNhap dsNhap = new DS_PhieuNhap();
    @SuppressWarnings("deprecation")
    Locale locale = new Locale("en", "EN");
    NumberFormat nF = NumberFormat.getInstance(locale);

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
            namThongKe = sc.nextLine();
            if(Validate.isYear(namThongKe)){
                break;
            }
            else{
                System.out.println("Du lieu nhap khong hop le !!!");
            }
        }

        int[] soLuongThang = new int[12];   //số lượng phiếu nhập trong tháng
        double[] soTienNhapThang = new double[12];
        for(int i = 0; i < 12; i++){
            soLuongThang[i] = 0;
        }
        for(int i = 0; i < 12; i++){
            soTienNhapThang[i] = 0;
        }
        dsNhap.docDSPhieuNhapTuFile();
        for(int i = 0; i < dsNhap.getSoLuong(); i++){
            String txt[] = dsNhap.getDs()[i].getNgayNhap().split("-");
            if(txt[2].equals(namThongKe)){
                if(txt[1].equals("1")){     //dd/MM/yyyy
                    soLuongThang[0]++;
                    soTienNhapThang[0] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("2")){     //dd/MM/yyyy
                    soLuongThang[1]++;
                    soTienNhapThang[1] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("3")){     //dd/MM/yyyy
                    soLuongThang[2]++;
                    soTienNhapThang[2] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("4")){     //dd/MM/yyyy
                    soLuongThang[3]++;
                    soTienNhapThang[3] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("5")){     //dd/MM/yyyy
                    soLuongThang[4]++;
                    soTienNhapThang[4] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("6")){     //dd/MM/yyyy
                    soLuongThang[5]++;
                    soTienNhapThang[5] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("7")){     //dd/MM/yyyy
                    soLuongThang[6]++;
                    soTienNhapThang[6] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("8")){     //dd/MM/yyyy
                    soLuongThang[7]++;
                    soTienNhapThang[7] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("9")){     //dd/MM/yyyy
                    soLuongThang[8]++;
                    soTienNhapThang[8] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("10")){     //dd/MM/yyyy
                    soLuongThang[9]++;
                    soTienNhapThang[9] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("11")){     //dd/MM/yyyy
                    soLuongThang[10]++;
                    soTienNhapThang[10] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("12")){     //dd/MM/yyyy
                    soLuongThang[11]++;
                    soTienNhapThang[11] += dsNhap.getDs()[i].getTongGia();
                } 
            }
        }
        for(int i = 0; i < 12; i++){
            System.out.println("So luong don nhap thang " + (i + 1) + " : " + soLuongThang[i]);
            System.out.println("Tong gia nhap thang : " + (i + 1) + " : " + nF.format(soTienNhapThang[i]));
        }
    }
    @Override
    public void thongKeTheoQuy(){
        System.out.println("Nhap vao nam muon thong ke : ");
        namThongKe = sc.nextLine();
        int[] soLuongQuy = new int[4];   //số lượng phiếu nhập trong tháng
        double[] soTienNhapQuy = new double[4];
        dsNhap.docDSPhieuNhapTuFile();
        for(int i = 0; i < dsNhap.getSoLuong(); i++){
            String txt[] = dsNhap.getDs()[i].getNgayNhap().split("-");
            if(txt[2].equals(namThongKe)){
                if(txt[1].equals("1") || txt[1].equals("2") || txt[1].equals("3")){     //dd/MM/yyyy
                    soLuongQuy[0]++;
                    soTienNhapQuy[0] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("4") || txt[1].equals("5") || txt[1].equals("6")){     //dd/MM/yyyy
                    soLuongQuy[1]++;
                    soTienNhapQuy[1] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("7") || txt[1].equals("8") || txt[1].equals("9")){     //dd/MM/yyyy
                    soLuongQuy[2]++;
                    soTienNhapQuy[2] += dsNhap.getDs()[i].getTongGia();
                } 
                else if(txt[1].equals("10") || txt[1].equals("11") || txt[1].equals("12")){     //dd/MM/yyyy
                    soLuongQuy[3]++;
                    soTienNhapQuy[3] += dsNhap.getDs()[i].getTongGia();
                }  
            }
        }
        for(int i = 0; i < 4; i++){
            System.out.println("So luong don nhap quy " + (i + 1) + " : " + soLuongQuy[i]);
            System.out.println("Tong gia nhap quy : " + (i + 1) + " : " + nF.format(soTienNhapQuy[i]));
        }
    }
    @Override
    public void thongKeTheoNam(){
        System.out.println("Nhap vao nam muon thong ke : ");
        namThongKe = sc.nextLine();
        int soLuongNam = 0;
        double soTienNhapNam = 0;
        dsNhap.docDSPhieuNhapTuFile();
        for(phieuNhap i : this.dsNhap.getDs()){
            String txt[] = i.getNgayNhap().split("-");
            if(txt[2].equals(namThongKe)){
                soLuongNam++;
                soTienNhapNam += i.getTongGia();
            }
        }
        System.out.println("So luong don nhap nam " + namThongKe + " : " + soLuongNam);
        System.out.println("Tong gia nhap nam : " + namThongKe + " : " + nF.format(soTienNhapNam));
    }
}
