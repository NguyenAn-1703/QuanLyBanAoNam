package quanLyBanAoNam.sanPham;

public class aoThun extends ao {
	private String kieuCoAo; // cổ bẻ, không có cổ
	
	
	public aoThun() {
		
	}
	
	public aoThun(String type, String id, String ten, String size, String mau, float giaNhapVao, float giaBanRa,
			String thuongHieu, String vai, String kieuTayAo, int soLuongSP, boolean trangThai, String kieuCoAo) {
		super(type, id, ten, size, mau, giaNhapVao, giaBanRa, thuongHieu, vai, kieuTayAo, soLuongSP, trangThai);
		this.kieuCoAo = kieuCoAo;
	}

	public boolean Validation(String kieuCoAo){
		if(kieuCoAo.isEmpty()){
			System.out.println("Kieu co ao khong duoc de trong. ");
			return(false);
		}
		return(true);
	}

	@Override
	public void nhap() {
		while(true){
			super.nhap();
			System.out.print("Vui long nhap kieu co ao : ");
			String kieuCoAo = sc.nextLine();
			if(this.Validation(kieuCoAo)){
				this.kieuCoAo = kieuCoAo;
				break;
			}
		}

	}

	@Override
	public void MenuSua(){
		super.MenuSua();
		System.out.println("7) Sua kieu co ao. ");
	}

	public boolean sua(String key){
		if(super.sua(key)){
			return(true);
		}
		else if(key.equals("7")){
			System.out.println("Vui long nhap kieu co ao moi : ");
			String kieuCoAo = sc.nextLine();
			if(kieuCoAo.isEmpty()){
				System.out.println("Kieu co ao khong duoc de trong. ");
				return(false);
			}
			else{
				this.kieuCoAo = kieuCoAo;
				return(true);
			}
		}
		return(false);
	}
	
	@Override
	public String toString() {
		return(super.toString() + " kieu co ao : " + this.kieuCoAo + "\n");
	}
	@Override
	public String toString2(){
		return(super.toString2() + this.kieuCoAo);
	}

	@Override
	public String toString3(){
		return(super.toString3() + " kieu co ao : " + this.kieuCoAo + "\n");
	}

	@Override
	public String toString4(){
		return(super.toString4() + " kieu co ao : " + this.kieuCoAo + "\n");
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
