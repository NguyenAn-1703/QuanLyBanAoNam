// package quanLyBanAoNam.thongKe;

// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// import quanLyBanAoNam.Validate.Validate;
// import quanLyBanAoNam.phieuNhap.DS_PhieuNhap;
// import quanLyBanAoNam.phieuNhap.phieuNhap;

// public class thongKeDonNhap extends thongKe implements thongKeTheoThoiGian{
//     private DS_PhieuNhap dsNhap;

//     @Override
//     public void thongKeTong(){
//         dsNhap.docDSPhieuNhapTuFile();
//         System.out.println("Tong so luong phieu nhap : " + this.dsNhap.getSoLuong());
//     }
//     @Override
//     public void Menu(){
//         System.out.println("Vui long nhap lua chon :");
//         System.out.println("1) Thong ke thang. ");
//         System.out.println("2) Thong ke theo quy. ");
//         System.out.println("3) Thong ke theo nam. ");
//     }
//     @Override
//     public void thongKeTheoThang() throws ParseException{
//         while(true){
//             System.out.println("Chon nam thong ke : ");
//             String namNhap = sc.nextLine();
//             if(Validate.isNam(namNhap)){
//                 this.namThongKe = namNhap;
//                 break;
//             }
//             else{
//                 System.out.println("Du lieu khong hop le vui long nhap lai");
//             }
//         }

//         String namDau = "1/1/" + this.namThongKe;
//         Date dateNamDau = new SimpleDateFormat("dd/MM/yyyy").parse(namDau);
//         String namCuoi = "31/12/" + this.namThongKe;
//         Date dateNamCuoi = new SimpleDateFormat("dd/MM/yyyy").parse(namCuoi);

//         for(phieuNhap i : dsNhap.getDs()){
//             String sDate = i.getNgayNhap();
//             Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
//             if(date.after(dateNamDau) && date.before(dateNamCuoi)){
//                 for(int i = 1; i < 12; i++){
//                     if(i.getNgayNhap.equals)(""))
//                 }
//             }
//         }
//     }
//     @Override
//     public void thongKeTheoQuy(){
        
//     }
//     @Override
//     public void thongKeTheoNam(){
        
//     }
// }
