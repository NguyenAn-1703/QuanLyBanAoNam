package quanLyBanAoNam.thongKe;

import java.util.Scanner;

public abstract class thongKe {
    protected String namThongKe;
    protected String ngayThongKe;
    protected String thangThongKe;
    Scanner sc = new Scanner(System.in);

    public thongKe(){}

    public thongKe(String namThongKe, String ngayThongKe, String thangThongKe) {
        this.namThongKe = namThongKe;
        this.ngayThongKe = ngayThongKe;
        this.thangThongKe = thangThongKe;
    }
    public abstract void thongKeTong();

}
