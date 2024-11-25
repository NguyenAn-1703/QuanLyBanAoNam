package quanLyBanAoNam.thongKe;

import quanLyBanAoNam.sanPham.DS_Ao;

public class thongKeSanPham extends thongKe{
    private DS_Ao dsAo;

    @Override
    public void thongKeTong(){
        this.dsAo.thongKeAo();
    }

}
