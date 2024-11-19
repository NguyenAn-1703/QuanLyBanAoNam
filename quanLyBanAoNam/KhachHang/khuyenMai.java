package quanLyBanAoNam.KhachHang;


public class khuyenMai {
    private static final double soTienToiThieuKM = 1000.0;
    private static final double tiLeTang = 0.01; // 1% của hóa đơn

    public static double apDungKhuyenMai(double tienTichLuy, double tongGia) {  //trả về giá hóa đơn mới
        double giaMoi = tongGia;
        double tienTichLuyDu;
        if (tienTichLuy >= soTienToiThieuKM) {
            giaMoi -= tienTichLuy; // Trừ tiền tích lũy vào hóa đơn
            if (giaMoi < 0) {   //tienTichLuyDu > 0 , tiền tích lũy lớn hơn tiền đơn
                giaMoi = 0; // Đảm bảo hóa đơn không âm
                tienTichLuyDu = tienTichLuy - tongGia;  //thêm
            }
            else{   //tienDu - 0, tiền tích lũy nhỏ hơn tiền đơn, giaMoi > 0, giaMoi giữ nguyên
                tienTichLuyDu = 0;
            }
            System.out.println("Da ap dung giam " + (tienTichLuy - tienTichLuyDu) + "d tu tien tich luy.");
            return(giaMoi);
        } else {
            System.out.println("Tien tich luy khong du de su dung khuyen mai.");
            return(tongGia);
        }
    }

    public static double tinhTienTichLuyMoi(double tienTichLuy, double tongGia){
        return(tienTichLuy + tongGia * tiLeTang);   //đem qua hóa đơn
    }
}
