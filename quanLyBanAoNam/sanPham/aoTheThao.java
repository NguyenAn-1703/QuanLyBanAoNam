package quanLyBanAoNam.sanPham;

public class aoTheThao extends ao {
	private String doiTuyen;
	private int inSoAo;
	private String monTheThao;
	
	
	public aoTheThao() {
		
	}
	
	public aoTheThao(String type, String id, String ten, String size, String mau, float gia, String thuongHieu,
			String vai, String kieuTayAo, int soLuongSP, String doiTuyen, int inSoAo, String monTheThao) {
		super(type,id, ten, size, mau, gia, thuongHieu, vai, kieuTayAo, soLuongSP);
		this.doiTuyen = doiTuyen;
		this.inSoAo = inSoAo;
		this.monTheThao = monTheThao;
	}
	
	
	@Override
	public void nhap() {
		super.nhap();
		System.out.println("Vui long nhap doi tuyen : ");
		this.doiTuyen = sc.nextLine();
		System.out.println("Vui long nhap so ao : ");
		this.inSoAo = Integer.parseInt(sc.nextLine());
		System.out.println("Vui long nhap mon the thao : ");
		this.monTheThao = sc.nextLine();
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
