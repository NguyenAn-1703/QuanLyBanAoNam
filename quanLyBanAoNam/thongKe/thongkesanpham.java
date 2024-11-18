package quanLyBanAoNam.thongKe;

import quanLyBanAoNam.sanPham.DS_Ao;
import quanLyBanAoNam.sanPham.ao;

public class thongKeSanPham extends thongKe{
    private DS_Ao dsAo;

    public static void Menu(){
        System.out.println("1) Thong ke theo thang. ");
        System.out.println("2) Thong ke theo quy. ");
        System.out.println("3) Thong ke theo ngay");
    }

    @Override
    public void thongKeTong(){
        this.dsAo.thongKeAo();
    }

}
