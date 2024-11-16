package quanLyBanAoNam.sanPham;

public class aoSoMi extends ao{
	private String kieuCoAo; // cổ bẻ, cổ trụ //test
	private String kieuNutAo;
	
	public aoSoMi() {
		
	}
	
	public aoSoMi(String type, String id, String ten, String size, String mau, float gia, String thuongHieu,
			String vai, String kieuTayAo, int soLuongSP, boolean trangThai, String kieuCoAo, String kieuNutAo) {
		super(type, id, ten, size, mau, gia, thuongHieu, vai, kieuTayAo, soLuongSP, trangThai);
		this.kieuCoAo = kieuCoAo;
		this.kieuNutAo = kieuNutAo;
	}

	public boolean Validation(String kieuCoAo, String kieuNutAo){
		if(kieuCoAo.isEmpty()){
			System.out.println("Kieu co ao khong duoc de trong. ");
			return(false);
		}
		else if(kieuNutAo.isEmpty()){
			System.out.println("Kieu nut ao khong duoc de trong. ");
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
			System.out.print("Vui long nhap kieu nut ao : ");
			String kieuNutAo = sc.nextLine();
			if(this.Validation(kieuCoAo, kieuNutAo)){
				this.kieuCoAo = kieuCoAo;
				this.kieuNutAo = kieuNutAo;
				break;
			}
		}

	}

	@Override
	public void MenuSua(){
		super.MenuSua();
		System.out.println("7) Sua kieu co ao. ");
		System.out.println("8) Sua kieu nut ao. ");
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
		else if(key.equals("8")){
			System.out.println("Vui long nhap kieu nut ao moi : ");
			String kieuNutAo = sc.nextLine();
			if(kieuNutAo.isEmpty()){
				System.out.println("Kieu nut ao khong duoc de trong. ");
				return(false);
			}
			else{
				this.kieuNutAo = kieuNutAo;
				return(true);
			}
		}
		return(false);
	}
	
	@Override
	public String toString() {
		return(super.toString() + " kieu co ao : " + this.kieuCoAo + "\n kieu nut ao : " + this.kieuNutAo + "\n");
	}

	@Override
	public String toString2(){
		return(super.toString2() + this.kieuCoAo + "#" + this.kieuNutAo);
	}

	@Override
	public String toString3(){
		return(super.toString3() + " kieu co ao : " + this.kieuCoAo + "\n kieu nut ao : " + this.kieuNutAo + "\n");
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
