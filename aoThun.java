package quanLyBanAoNam;

public class aoThun extends ao {
	private String kieuCoAo; // cổ bẻ, không có cổ
	
	
	public aoThun() {
		
	}
	
	public aoThun(String id, String ten, String size, String mau, float gia, String thuongHieu,
			String vai, String kieuTayAo, int soLuongTonKho, String kieuCoAo) {
		super(id, ten, size, mau, gia, thuongHieu, vai, kieuTayAo, soLuongTonKho);
		this.kieuCoAo = kieuCoAo;
	}

	public String getKieuCoAo() {
		return this.kieuCoAo;
	}

	public void setKieuCoAo(String kieuCoAo) {
		this.kieuCoAo = kieuCoAo;
	}
	
	@Override
	public void nhap() {
		super.nhap();
		System.out.println("Vui long nhap kieu co ao : ");
		this.kieuCoAo = sc.nextLine();
	}
	
	@Override
	public String toString() {
		return(super.toString() + " kieu co ao : " + this.kieuCoAo + "\n");
	}
	
	public void xuat() {
		System.out.println(this.toString());
	}
	
}
