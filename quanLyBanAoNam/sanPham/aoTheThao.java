package quanLyBanAoNam.sanPham;

import quanLyBanAoNam.Validate.Validate;

public class aoTheThao extends ao {
	private String doiTuyen;
	private int inSoAo;
	private String monTheThao;
	
	
	public aoTheThao() {
		
	}
	
	public aoTheThao(String type, String id, String ten, String size, String mau, float gia, String thuongHieu,
			String vai, String kieuTayAo, int soLuongSP, boolean trangThai, String doiTuyen, int inSoAo, String monTheThao) {
		super(type,id, ten, size, mau, gia, thuongHieu, vai, kieuTayAo, soLuongSP, trangThai);
		this.doiTuyen = doiTuyen;
		this.inSoAo = inSoAo;
		this.monTheThao = monTheThao;
	}
	
	
	public boolean Validation(String doiTuyen, String inSoAo, String monTheThao){
		if(doiTuyen.isEmpty()){
			System.out.println("Doi tuyen khong duoc de trong. ");
			return(false);
		}
		else if(inSoAo.isEmpty() || !Validate.isNumber(inSoAo)){
			System.out.println("So ao khong duoc de trong va phai la so. ");
			return(false);
		}
		else if(monTheThao.isEmpty()){
			System.out.println("Mon the thao khong duoc de trong. ");
			return(false);
		}
		return(true);
	}

	@Override
	public void nhap() {
		while(true){
			super.nhap();
			System.out.print("Vui long nhap doi tuyen : ");
			String doiTuyen = sc.nextLine();
			System.out.print("Vui long nhap so ao : ");
			String inSoAo = sc.nextLine();
			System.out.print("Vui long nhap mon the thao : ");
			String monTheThao = sc.nextLine();
			
			if(this.Validation(doiTuyen, inSoAo, monTheThao)){
				this.doiTuyen = doiTuyen;
				this.inSoAo = Integer.parseInt(inSoAo);
				this.monTheThao = monTheThao;
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		return(super.toString() + " doi tuyen : " + this.doiTuyen + 
				"\n so ao : " + this.inSoAo + "\n mon the thao : " + this.monTheThao + "\n");
	}

	@Override
	public String toString2(){
		return(super.toString2() + this.doiTuyen + "#" + this.inSoAo + "#" + this.monTheThao);
	}

	@Override
	public String toString3(){
		return(super.toString3() + " doi tuyen : " + this.doiTuyen + 
		"\n so ao : " + this.inSoAo + "\n mon the thao : " + this.monTheThao + "\n");
	}
	
	public void xuat() {
		System.out.println(this.toString());
	}

	public String getDoiTuyen() {
		return doiTuyen;
	}

	public void setDoiTuyen(String doiTuyen) {
		this.doiTuyen = doiTuyen;
	}

	public int getInSoAo() {
		return inSoAo;
	}

	public void setInSoAo(int inSoAo) {
		this.inSoAo = inSoAo;
	}

	public String getMonTheThao() {
		return monTheThao;
	}

	public void setMonTheThao(String monTheThao) {
		this.monTheThao = monTheThao;
	}

	
}
