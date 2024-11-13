package quanLyBanAoNam.sanPham;

public class aoThun extends ao {
	private String kieuCoAo; // cổ bẻ, không có cổ
	
	
	public aoThun() {
		
	}
	
	public aoThun(String id, String ten, String size, String mau, float gia, String thuongHieu,
			String vai, String kieuTayAo, int soLuongSP, String kieuCoAo) {
		super(id, ten, size, mau, gia, thuongHieu, vai, kieuTayAo, soLuongSP);
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
	@Override
	public String toString2(){
		return(super.toString2() + this.kieuCoAo);
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
	
	
}
