package quanLyBanAoNam.sanPham;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import quanLyBanAoNam.Validate.Validate;
import quanLyBanAoNam.keBien.keBien;

public class ao {
	protected String type;
	protected String id; //id lưu kiểu String
	protected String ten; // lên web coi
	protected String size; // M L XL XXL
	protected String mau; // trắng, đen, xanh...
	protected float giaNhapVao;	//gia nhap
	protected float giaBanRa; //gia ban
	protected String thuongHieu; // lên web coi
	protected String vai; // lên web coi
	protected String kieuTayAo; // tay dài, tay ngắn
	protected int soLuongSP = 0;
	protected boolean trangThai = true;
	public Scanner sc = new Scanner(System.in);
	@SuppressWarnings("deprecation")
    Locale locale = new Locale("en", "EN");
    NumberFormat nF = NumberFormat.getInstance(locale);
	
	public ao() {};
	public ao(String type, String id, String ten, String size, String mau, float giaNhapVao, float giaBanRa,
	String thuongHieu, String vai, String kieuTayAo, int soLuongSP, boolean trangThai) {
		this.type = type;
		this.id = id;
		this.ten = ten;
		this.size = size;
		this.mau = mau;
		this.giaNhapVao = giaNhapVao;
		this.giaBanRa = giaBanRa;
		this.thuongHieu = thuongHieu;
		this.vai = vai;
		this.kieuTayAo = kieuTayAo;
		this.soLuongSP = soLuongSP;
		this.trangThai = trangThai;
	}

	public boolean Validation(String ten, String size, String mau,
	 String giaNhapVao, String giaBanRa, String thuongHieu, String vai, String kieuTayAo){
		if(ten.isEmpty()){
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
		else if(giaNhapVao.isEmpty() || !Validate.isNumber(giaNhapVao)){
			System.out.println("Gia nhap khong duoc de trong va phai la so. ");
			return(false);
		}
		else if(giaBanRa.isEmpty() || !Validate.isNumber(giaBanRa)){
			System.out.println("Gia ban khong duoc de trong va phai la so. ");
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
			System.out.print("Vui long nhap ten ao : ");
			String ten = sc.nextLine();
			System.out.print("Vui long nhap size ao : ");
			String size = sc.nextLine();
			System.out.print("Vui long nhap mau ao : ");
			String mau = sc.nextLine();
			System.out.print("Vui long nhap gia nhap hang cua ao : ");
			String giaNhapVao = sc.nextLine();
			System.out.print("Vui long nhap gia ban cua ao : ");
			String giaBanRa = sc.nextLine();
			System.out.print("Vui long nhap thuong hieu ao : ");
			String thuongHieu = sc.nextLine();
			System.out.print("Vui long nhap vai ao : ");
			String vai = sc.nextLine();
			System.out.print("Vui long nhap kieu tay ao : ");
			String kieuTayAo = sc.nextLine();
			if(Validation(ten, size, mau, giaNhapVao, giaBanRa, thuongHieu, vai, kieuTayAo)){
				this.ten = ten;
				this.size = size;
				this.mau = mau;
				this.giaNhapVao = Float.parseFloat(giaNhapVao);
				this.giaBanRa = Float.parseFloat(giaBanRa);
				this.thuongHieu = thuongHieu;
				this.vai = vai;
				this.kieuTayAo = kieuTayAo;
				break;
			}
		}
		
	}
	
	@Override
	public String toString() {
		return(keBien.ke2Nho() + "id : " + this.id + "\n ten : " + this.ten + "\n size : " + this.size + 
		"\n mau : " + this.mau + "\n gia nhap : " + nF.format(this.giaNhapVao) + 
		"\n gia ban : " + nF.format(this.giaBanRa) + "\n thuong hieu : " + this.thuongHieu + "\n vai : " + this.vai + 
		"\n kieu tay ao : " + this.kieuTayAo + "\n so luong ton kho : " + this.soLuongSP + "\n");
	}

	public String toString2(){		//toString để đọc và ghi file
		return(this.type + "#" + this.id + "#" + this.ten + "#" + this.size + "#" + this.mau + "#" + 
		this.giaNhapVao + "#" + this.giaBanRa + "#" + this.thuongHieu + "#" + this.vai + "#" + 
		this.kieuTayAo + "#" + this.soLuongSP + "#" + this.trangThai + "#");
	}
	
	public String toString3(){	//toString cho phiếu nhập
		return(keBien.ke2Nho() + "id : " + this.id + "\n ten : " + this.ten + "\n size : " + this.size + "\n mau : " + this.mau
				+ "\n gia nhap : " + this.giaNhapVao + "\n thuong hieu : " + this.thuongHieu + "\n vai : " + this.vai + 
				"\n kieu tay ao : " + this.kieuTayAo + "\n");
	}

	public String toString4(){	//toString cho phiếu hóa đơn
		return(keBien.ke2Nho() + "id : " + this.id + "\n ten : " + this.ten + "\n size : " + this.size + "\n mau : " + this.mau
				+ "\n gia ban : " + this.giaBanRa + "\n thuong hieu : " + this.thuongHieu + "\n vai : " + this.vai + 
				"\n kieu tay ao : " + this.kieuTayAo + "\n");
	}

	public void MenuSua(){
		System.out.println("1) Sua ten. ");
		System.out.println("2) Sua size. ");
		System.out.println("3) Sua mau. ");
		System.out.println("4) Sua thuong hieu. ");
		System.out.println("5) Sua vai. ");
		System.out.println("6) Sua kieu tay ao. ");
	}

	public boolean sua(String key){		//làm trong ds không dùng được setter
		if(key.equals("1")){
			System.out.println("Vui long nhap ten moi : ");
			String ten = sc.nextLine();
			if(ten.isEmpty()){
				System.out.println("Ten khong duoc de trong . ");
				return(false);
			}
			else{
				this.ten = ten;
				return(true);
			}
		}
		else if(key.equals("2")){
			System.out.println("Vui long nhap size moi : ");
			String size = sc.nextLine();
			if(size.isEmpty() || !Validate.isSize(size)){
				System.out.println("Size khong duoc de trong va phai dung dinh dang. ");
				return(false);
			}
			else{
				this.size = size;
				return(true);
			}
		}
		else if(key.equals("3")){
			System.out.println("Vui long nhap mau moi : ");
			String mau = sc.nextLine();
			if(mau.isEmpty()){
				System.out.println("Mau khong duoc de trong . ");
				return(false);
			}
			else{
				this.mau = mau;
				return(true);
			}
		}
		else if(key.equals("4")){
			System.out.println("Vui long nhap thuong hieu moi : ");
			String thuongHieu = sc.nextLine();
			if(thuongHieu.isEmpty()){
				System.out.println("Thuong hieu khong duoc de trong . ");
				return(false);
			}
			else{
				this.thuongHieu = thuongHieu;
				return(true);
			}
		}
		else if(key.equals("5")){
			System.out.println("Vui long nhap vai moi : ");
			String vai = sc.nextLine();
			if(vai.isEmpty()){
				System.out.println("Vai khong duoc de trong . ");
				return(false);
			}
			else{
				this.vai = vai;
				return(true);
			}
		}
		else if(key.equals("6")){
			System.out.println("Vui long nhap kieu tay ao moi : ");
			String kieuTayAo = sc.nextLine();
			if(kieuTayAo.isEmpty()){
				System.out.println("Kieu tay ao khong duoc de trong . ");
				return(false);
			}
			else{
				this.kieuTayAo = kieuTayAo;
				return(true);
			}
		}
		return(false);
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
	public float getGiaNhapVao() {
		return giaNhapVao;
	}
	public void setGiaNhapVao(float giaNhapVao) {
		this.giaNhapVao = giaNhapVao;
	}
	public float getGiaBanRa() {
		return giaBanRa;
	}
	public void setGiaBanRa(float giaBanRa) {
		this.giaBanRa = giaBanRa;
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
