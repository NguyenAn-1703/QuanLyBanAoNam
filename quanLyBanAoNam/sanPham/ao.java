package quanLyBanAoNam.sanPham;

import java.util.Scanner;

import quanLyBanAoNam.keBien.keBien;

public class ao {
	protected String type;
	protected String id; //id lưu kiểu String
	protected String ten; // lên web coi
	protected String size; // M L XL XXL
	protected String mau; // trắng, đen, xanh...
	protected float gia;
	protected String thuongHieu; // lên web coi
	protected String vai; // lên web coi
	protected String kieuTayAo; // tay dài, tay ngắn
	protected int soLuongSP = 0;
	protected int soLuongNhap = 0;
	protected int soLuongBan = 0; 
	protected boolean trangThai = true;
	public Scanner sc = new Scanner(System.in);
	
	
	public ao() {};
	public ao(String type, String id, String ten, String size, String mau, float gia, String thuongHieu,
			String vai, String kieuTayAo, int soLuongSP) {
		this.type = type;
		this.id = id;
		this.ten = ten;
		this.size = size;
		this.mau = mau;
		this.gia = gia;
		this.thuongHieu = thuongHieu;
		this.vai = vai;
		this.kieuTayAo = kieuTayAo;
		this.soLuongSP = soLuongSP;
	}
	public void nhap() {
		System.out.print("Vui long nhap id ao :");
		this.id = sc.nextLine();
		System.out.print("Vui long nhap ten ao : ");
		this.ten = sc.nextLine();
		System.out.print("Vui long nhap size ao : ");
		this.size = sc.nextLine();
		System.out.print("Vui long nhap mau ao : ");
		this.mau = sc.nextLine();
		System.out.print("Vui long nhap gia ao : ");
		this.gia = Float.parseFloat(sc.nextLine());
		System.out.print("Vui long nhap thuong hieu ao : ");
		this.thuongHieu = sc.nextLine();
		System.out.print("Vui long nhap vai ao : ");
		this.vai = sc.nextLine();
		System.out.print("Vui long nhap kieu tay ao : ");
		this.kieuTayAo = sc.nextLine();
		
	}
	
	@Override
	public String toString() {
		return(keBien.ke2Nho() + "id : " + this.id + "\n ten : " + this.ten + "\n size : " + this.size + "\n mau : " + this.mau
				+ "\n gia : " + this.gia + "\n thuong hieu : " + this.thuongHieu + "\n vai : " + this.vai + 
				"\n kieu tay ao : " + this.kieuTayAo + "\n so luong ton kho : " + this.soLuongSP + "\n");
	}

	public String toString2(){		//toString để đọc và ghi file
		return(this.type + "#" + this.id + "#" + this.ten + "#" + this.size + "#" + this.mau + "#" + this.gia 
		+ "#" + this.thuongHieu + "#" + this.vai + "#" + this.kieuTayAo + "#" + this.soLuongSP + "#");
	}
	
	public String toString3(){	//toString cho phiếu nhập và hóa đơn
		return(keBien.ke2() + "id : " + this.id + "\n ten : " + this.ten + "\n size : " + this.size + "\n mau : " + this.mau
				+ "\n gia : " + this.gia + "\n thuong hieu : " + this.thuongHieu + "\n vai : " + this.vai + 
				"\n kieu tay ao : " + this.kieuTayAo + "\n");
	}

	public void xuat() {
		System.out.println(this.toString());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getMau() {
		return mau;
	}
	public void setMau(String mau) {
		this.mau = mau;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public String getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public String getVai() {
		return vai;
	}
	public void setVai(String vai) {
		this.vai = vai;
	}
	public String getKieuTayAo() {
		return kieuTayAo;
	}
	public void setKieuTayAo(String kieuTayAo) {
		this.kieuTayAo = kieuTayAo;
	}
	public int getSoLuongSP() {
		return soLuongSP;
	}
	public void setSoLuongSP(int soLuongSP) {
		this.soLuongSP = soLuongSP;
	}
	
	public int getSoLuongNhap() {
		return soLuongNhap;
	}
	public void setSoLuongNhap(int soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}
	public int getSoLuongBan() {
		return soLuongBan;
	}
	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
}
