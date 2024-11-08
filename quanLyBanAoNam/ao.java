package quanLyBanAoNam;

import java.util.Scanner;

public class ao {
	protected String id;
	protected String ten;
	protected String size; // M L XL XXL
	protected String mau; // trắng, đen, xanh...
	protected float gia;
	protected String thuongHieu;
	protected String vai;
	protected String kieuTayAo; // tay dài, tay ngắn
	protected int soLuongTonKho;
	protected int soLuongBan;
	public Scanner sc = new Scanner(System.in);
	
	
	public ao() {};
	public ao(String id, String ten, String size, String mau, float gia, String thuongHieu,
			String vai, String kieuTayAo, int soLuongTonKho) {
		this.id = id;
		this.ten = ten;
		this.size = size;
		this.mau = mau;
		this.gia = gia;
		this.thuongHieu = thuongHieu;
		this.vai = vai;
		this.kieuTayAo = kieuTayAo;
		this.soLuongTonKho = soLuongTonKho;
		this.soLuongBan = soLuongBan;
	}
	
	public void nhap() {
		System.out.println("Vui long nhap id ao :");
		this.id = sc.nextLine();
		System.out.println("Vui long nhap ten ao : ");
		this.ten = sc.nextLine();
		System.out.println("Vui long nhap size ao : ");
		this.size = sc.nextLine();
		System.out.println("Vui long nhap mau ao : ");
		this.mau = sc.nextLine();
		System.out.println("Vui long nhap gia ao : ");
		this.gia = Float.parseFloat(sc.nextLine());
		System.out.println("Vui long nhap thuong hieu ao : ");
		this.thuongHieu = sc.nextLine();
		System.out.println("Vui long nhap vai ao : ");
		this.vai = sc.nextLine();
		System.out.println("Vui long nhap kieu tay ao : ");
		this.kieuTayAo = sc.nextLine();
		System.out.println("Vui long nhap so luong ton kho : ");
		this.soLuongTonKho = Integer.parseInt(sc.nextLine());
		
	}
	
	@Override
	
	public String toString() {
		return("id : " + this.id + "\n ten : " + this.ten + "\n size : " + this.size + "\n mau : " + this.mau
				+ "\n gia : " + this.gia + "\n thuong hieu : " + this.thuongHieu + "\n vai : " + this.vai + 
				"\n kieu tay ao : " + this.kieuTayAo + "\n so luong ton kho : " + this.soLuongTonKho + "\n");
		
		
		
	}
	
	public void xuat() {
		System.out.println(this.toString());
	}
	
}
