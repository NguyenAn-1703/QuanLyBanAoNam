package quanLyBanAoNam.sanPham;

public class aoSoMi extends ao{
	private String kieuCoAo; // cổ bẻ, cổ trụ //test
	private String kieuNutAo;
	
	public aoSoMi() {
		
	}
	
	public aoSoMi(String type, String id, String ten, String size, String mau, float gia, String thuongHieu,
			String vai, String kieuTayAo, int soLuongSP, int soLuongNhap, int soLuongBan, String kieuCoAo, String kieuNutAo) {
		super(type, id, ten, size, mau, gia, thuongHieu, vai, kieuTayAo, soLuongSP, soLuongNhap, soLuongBan);
		this.kieuCoAo = kieuCoAo;
		this.kieuNutAo = kieuNutAo;
	}

	@Override
	public void nhap() {
		super.nhap();
		System.out.println("Vui long nhap kieu co ao : ");
		this.kieuCoAo = sc.nextLine();
		System.out.println("Vui long nhap kieu nut ao : ");
		this.kieuNutAo = sc.nextLine();
	}
	
	@Override
	public String toString() {
		return(super.toString() + " kieu co ao : " + this.kieuCoAo + "\n kieu nut ao : " + this.kieuNutAo + "\n");
	}

	@Override
	public String toString2(){
		return(super.toString2() + this.kieuCoAo + "#" + this.kieuNutAo);
	}
	
	public void xuat() {
		System.out.println(this.toString());
	}

	public String getKieuCoAo() {
		return kieuCoAo;
	}

	public void setKieuCoAo(String kieuCoAo) {
		this.kieuCoAo = kieuCoAo;
	}

	public String getKieuNutAo() {
		return kieuNutAo;
	}

	public void setKieuNutAo(String kieuNutAo) {
		this.kieuNutAo = kieuNutAo;
	}
	
}
