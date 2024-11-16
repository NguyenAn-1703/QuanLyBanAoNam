package quanLyBanAoNam.sanPham;

import java.lang.foreign.ValueLayout;
import java.util.Scanner;

import quanLyBanAoNam.Validate.Validate;
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
	protected boolean trangThai = true;
	public Scanner sc = new Scanner(System.in);
	
	
	public ao() {};
	public ao(String type, String id, String ten, String size, String mau, float gia, String thuongHieu,
			String vai, String kieuTayAo, int soLuongSP, boolean trangThai) {
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
		this.trangThai = trangThai;
	}

	public boolean Validation(String id, String ten, String size, String mau,
	 String gia, String thuongHieu, String vai, String kieuTayAo){
		if(!Validate.isNumber(id) || id.isEmpty()){
			System.out.println("id khong duoc de trong va phai la so. ");
			return(false);
		}
		else if(ten.isEmpty()){
			System.out.println("Ten khong duoc de trong. ");
			return(false);
		}
		else if(size.isEmpty() || !Validate.isSize(size)){
			System.out.println("Size khong duoc de trong va phai dung dinh dang. ");
			return(false);
		}
		else if(mau.isEmpty()){
			System.out.println("Mau khong duoc de trong. ");
			return(false);
		}
		else if(gia.isEmpty() || !Validate.isNumber(gia)){
			System.out.println("Gia khong duoc de trong va phai la so. ");
			return(false);
		}
		else if(thuongHieu.isEmpty()){
			System.out.println("Thuong hieu khong duoc de trong. ");
			return(false);
		}
		else if(vai.isEmpty()){
			System.out.println("Vai khong duoc de trong. ");
			return(false);
		}
		else if(kieuTayAo.isEmpty()){
			System.out.println("Kieu tay ao khong duoc de trong. ");
			return(false);
		}
		return(true);
	}
	public void nhap() {
		while(true){
			System.out.print("Vui long nhap id ao : ");
			String id = sc.nextLine();
			System.out.print("Vui long nhap ten ao : ");
			String ten = sc.nextLine();
			System.out.print("Vui long nhap size ao : ");
			String size = sc.nextLine();
			System.out.print("Vui long nhap mau ao : ");
			String mau = sc.nextLine();
			System.out.print("Vui long nhap gia ao : ");
			String gia = sc.nextLine();
			System.out.print("Vui long nhap thuong hieu ao : ");
			String thuongHieu = sc.nextLine();
			System.out.print("Vui long nhap vai ao : ");
			String vai = sc.nextLine();
			System.out.print("Vui long nhap kieu tay ao : ");
			String kieuTayAo = sc.nextLine();
			if(Validation(id, ten, size, mau, gia, thuongHieu, vai, kieuTayAo)){
				this.id = id;
				this.ten = ten;
				this.size = size;
				this.mau = mau;
				this.gia = Float.parseFloat(gia);
				this.thuongHieu = thuongHieu;
				this.vai = vai;
				this.kieuTayAo = kieuTayAo;
				break;
			}
		}
		
	}
	
	@Override
	public String toString() {
		return(keBien.ke2Nho() + "id : " + this.id + "\n ten : " + this.ten + "\n size : " + this.size + "\n mau : " + this.mau
				+ "\n gia : " + this.gia + "\n thuong hieu : " + this.thuongHieu + "\n vai : " + this.vai + 
				"\n kieu tay ao : " + this.kieuTayAo + "\n so luong ton kho : " + this.soLuongSP + "\n");
	}

	public String toString2(){		//toString để đọc và ghi file
		return(this.type + "#" + this.id + "#" + this.ten + "#" + this.size + "#" + this.mau + "#" + this.gia 
		+ "#" + this.thuongHieu + "#" + this.vai + "#" + this.kieuTayAo + "#" + this.soLuongSP + "#" + this.trangThai + "#");
	}
	
	public String toString3(){	//toString cho phiếu nhập và hóa đơn
		return(keBien.ke2() + "id : " + this.id + "\n ten : " + this.ten + "\n size : " + this.size + "\n mau : " + this.mau
				+ "\n gia : " + this.gia + "\n thuong hieu : " + this.thuongHieu + "\n vai : " + this.vai + 
				"\n kieu tay ao : " + this.kieuTayAo + "\n");
	}

	public void xuat() {
		System.out.println(this.toString());
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public boolean getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	
	
}
