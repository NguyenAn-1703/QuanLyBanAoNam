package quanLyBanAoNam.sanPham;

public class aoSoMi extends ao{
	private String kieuCoAo; // cổ bẻ, cổ trụ //test
	private String kieuNutAo;
	
	public aoSoMi() {
		
	}
	
	public aoSoMi(String id, String ten, String size, String mau, float gia, String thuongHieu,
			String vai, String kieuTayAo, int soLuongTonKho, String kieuCoAo, String kieuNutAo) {
		super(id, ten, size, mau, gia, thuongHieu, vai, kieuTayAo, soLuongTonKho);
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
		return(super.toString2() + "\t" + this.kieuCoAo + "\t" + this.kieuNutAo);
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
