package quanLyBanAoNam.sanPham;

import java.util.Scanner;

public class ao {
	protected String id; //id lưu kiểu String
	protected String ten; // lên web coi
	protected String size; // M L XL XXL
	protected String mau; // trắng, đen, xanh...
	protected float gia;
	protected String thuongHieu; // lên web coi
	protected String vai; // lên web coi
	protected String kieuTayAo; // tay dài, tay ngắn
	protected int soLuongTonKho; 
	protected boolean trangThai;
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
		System.out.println("Vui long nhap so luong : ");
		this.soLuongTonKho = Integer.parseInt(sc.nextLine());
		
	}
	
	@Override
	public String toString() {
		return("id : " + this.id + "\n ten : " + this.ten + "\n size : " + this.size + "\n mau : " + this.mau
				+ "\n gia : " + this.gia + "\n thuong hieu : " + this.thuongHieu + "\n vai : " + this.vai + 
				"\n kieu tay ao : " + this.kieuTayAo + "\n so luong ton kho : " + this.soLuongTonKho + "\n");
	}

	public String toString2(){
		return(this.id + "\t" + this.ten + "\t" + this.size + "\t" + this.mau + "\t" + this.gia 
		+ "\t" + this.thuongHieu + "\t" + this.vai + "\t" + this.kieuTayAo + "\t" + this.soLuongTonKho);
	}
	
	public void xuat() {
		System.out.println(this.toString());
	}
	public String getId() {
		return id;
	}
	public String getTen() {
		return ten;
	}
	public String getSize() {
		return size;
	}
	public String getMau() {
		return mau;
	}
	public float getGia() {
		return gia;
	}
	public String getThuongHieu() {
		return thuongHieu;
	}
	public String getVai() {
		return vai;
	}
	public String getKieuTayAo() {
		return kieuTayAo;
	}
	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setMau(String mau) {
		this.mau = mau;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public void setVai(String vai) {
		this.vai = vai;
	}
	public void setKieuTayAo(String kieuTayAo) {
		this.kieuTayAo = kieuTayAo;
	}
	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}
	
	
}
