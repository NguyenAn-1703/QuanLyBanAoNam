package quanLyBanAoNam.thongKe;

import java.util.Scanner;

public abstract class thongKe {
    protected String namThongKe;

    Scanner sc = new Scanner(System.in);

    public thongKe(){}

    public thongKe(String namThongKe) {
        this.namThongKe = namThongKe;

    }
    public abstract void Menu();
    public abstract void thongKeTong();

}
