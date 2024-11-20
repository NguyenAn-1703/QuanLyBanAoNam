package quanLyBanAoNam.sanPham;

import quanLyBanAoNam.Validate.Validate;
import quanLyBanAoNam.keBien.keBien;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class DS_Ao {
	private ao[] ds = new ao[0];
	private int soLuong = 0;
	public static Scanner sc = new Scanner(System.in);
	//làm theo file yêu cầu đồ án

	public static void MenuChinh(){
		keBien.keBienAo();
		System.out.println("Vui long nhap lua chon.");
		System.out.println("1) Doc danh sach dau tien tu file.");	// phần này đổi thành đọc từ file
		System.out.println("2) Xuat danh sach.");
		System.out.println("3) Them 1 ao.");
		System.out.println("4) Them nhieu ao.");
		System.out.println("5) Xoa 1 ao. ");
		System.out.println("6) Sua thong tin ao. ");
		System.out.println("7) Tim kiem theo ID ao.");
		System.out.println("8) Thong ke ao ton kho.");
		System.out.println("9) Thoat chuc nang.");
		keBien.ke();
	}

	public void startUp(){				
		String key;
		while(true){
			MenuChinh();
			key = sc.nextLine();
			if(key.equals("1")){		//Doc ds dau tien
				docDSTuFile();
			}
			else if(key.equals("2")){	//Xuat danh sach
				this.xuat();
			}
			else if(key.equals("3")){	//Them 1 ao
				this.them1Ao();
			}
			else if(key.equals("4")){	//Them k ao
				this.themKAo();
			}
			else if(key.equals("5")){
				this.xoa1Ao();
			}
			else if(key.equals("6")){	//Tim kiem theo ID
				this.suaAo();
			}
			else if(key.equals("7")){	//Tim kiem theo ID
				this.timKiemTheoID();
			}
			else if(key.equals("8")){	//Thong ke so luong
				this.thongKeAo();
			}
			else if(key.equals("9")){
				keBien.ke();
				System.out.println("Da thoat chuc nang.");
				break;
			}
			else{
				System.out.println("Du lieu khong hop le vui long nhap lai !!!");
			}		
		}
	}

	public void xuat(){				//yêu cầu 2b)
		docDSTuFile();
		System.out.println(this.toString());
	}

	public void them1Ao(ao x){	//Yêu cầu 2c)
		ao[] dsnew = Arrays.copyOf(ds, soLuong + 1);
		dsnew[soLuong] = x;
		ds = dsnew;
		soLuong++;
		x.setId(Integer.toString(soLuong));
	}

	public void them1Ao(){	//Overloading - Yêu cầu 2c
		docDSTuFile();
		while(true){
			String key;
			MenuAo();
			key = sc.nextLine();
			if(key.equals("1")){
				ao x = new aoSoMi();
				x.nhap();
				x.type = "SM";
				them1Ao(x);
				break;
			}
			else if(key.equals("2")){
				ao x = new aoTheThao();
				x.nhap();
				x.type = "TT";
				them1Ao(x);
				break;
			}
			else if(key.equals("3")){
				ao x = new aoThun();
				x.nhap();
				x.type = "T";
				them1Ao(x);
				break;
			}
			System.out.println("Du lieu khong hop le, vui long nhap lai !!! ");
		}
		ghiDSVaoFile();
	}

	public void themKAo(){	//Yêu cầu 2c)
		docDSTuFile();
		String K;
		while(true){
			System.out.println("Vui long nhap so loai ao muon them : ");
			K = sc.nextLine();
			if(Validate.isNumber(K)){
				break;
			}
			else{
				System.out.println("Du lieu khong hop le vui long nhap lai !!!");
			}
		}
		int k = Integer.parseInt(K);
		for(int i = 0; i < k; i++){
			them1Ao();
		}
		ghiDSVaoFile();
	}

	public static void MenuAo(){
		System.out.println("Vui long chon kieu ao :");
		System.out.println("1) Ao So Mi.");
		System.out.println("2) Ao The Thao.");
		System.out.println("3) Ao Thun.");
	}

	public void xoa1Ao(){
		System.out.println("Vui long nhap vao id ao muon xoa : ");
		String ID = sc.nextLine();
		ao x = getAoByID(ID);
		if(x != null){
			if(!x.getTrangThai()){
				System.out.println("Ao da duoc xoa");
				return;
			}
			x.setTrangThai(false);
			ghiDSVaoFile();
			System.out.println("Da xoa ao ID : " + x.getId() + "\n");
		}
		else{
			return;
		}
	}

	public void suaAo(){			
		System.out.println("Vui long nhap vao id ao muon sua : ");
		String ID = sc.nextLine();
		ao x = getAoByID(ID);
		if(x != null){
			while(true){	
				System.out.println("Nhap vao x de ket thuc. ");
				x.MenuSua();		
				String key = sc.nextLine();
				if(x.sua(key)){
					System.out.println("Sua thong tin thanh cong ! ");
					break;
				}
				else if(key.equals("x")){
					break;
				}
				else{
					System.out.println("Du lieu sai, vui long nhap lai !!!");
				}
			}
			ghiDSVaoFile();
		}
		else{
			return;
		}
	}
	
	public void timKiemTheoID(){	//Yêu cầu 2f) - còn thiếu khóa tìm kiếm **
		docDSTuFile();
		System.out.println("Vui long nhap vao id ao can tim : ");
		String ID = sc.nextLine();
		ao x = getAoByID(ID);
		if(x.getTrangThai() == false){
			System.out.println("San pham da bi xoa !!!");
			return;
		}
		else if(x != null){
			System.out.println("Thong tin cua ao id so " + ID + " : ");
			x.xuat();
		}
	}

	public ao getAoByID(String ID){	//Xài thêm cho chức năng chọn áo trong class hóa đơn
		docDSTuFile();
		if(!ID.equals("") && ID != null){
			for(int i = 0; i < soLuong; i++){
				if(ds[i].getId().equals(ID)){
					return(ds[i]);
				}
			}
		}
		System.out.println("Khong tim thay ao trong danh sach !!!");
		return(null);
	}

	// public void timKiemTheoTen(String ten){	// từ từ sửa
	// 	boolean timThay = false;
	// 	for (int i = 0; i < soLuong; i++){
	// 		if (ds[i].getTen().equalsIgnoreCase(ten)){
	// 			ds[i].xuat();
	// 			timThay = true;
	// 		}
	// 	}
	// 	if (!timThay){
	// 		System.out.println("Khong tim thay ao voi ten: " + ten);
	// 	}
	// }

	// public void sapXepTheoID(){
	// 	Arrays.sort(ds, 0, soLuong, (ao1, ao2) -> ao1.getId().compareTo(ao2.getId()));
	// }


	public void thongKeAo(){		//yêu cầu 2g)
		docDSTuFile();
		int soLuongAoSoMi, soLuongAoTheThao, soLuongAoThun, tongSoAo;
			soLuongAoSoMi = soLuongAoTheThao = soLuongAoThun = tongSoAo = 0;
		for(int i = 0; i < soLuong; i++){
			if(ds[i].getTrangThai()){
				if(ds[i] instanceof aoSoMi){
					soLuongAoSoMi += ds[i].getSoLuongSP();
				}
				if(ds[i] instanceof aoTheThao){
					soLuongAoTheThao += ds[i].getSoLuongSP();
				}
				if(ds[i] instanceof aoThun){
					soLuongAoThun += ds[i].getSoLuongSP();
				}
			}
		}
		tongSoAo = soLuongAoSoMi + soLuongAoTheThao + soLuongAoThun;
		System.out.println("Thong ke so luong ao ton kho : ");
		System.out.println("+ So luong ao ton kho : " + tongSoAo);
		System.out.println("So luong ao so mi : " + soLuongAoSoMi);
		System.out.println("So luong ao the thao : " + soLuongAoTheThao);
		System.out.println("So luong ao thun : " + soLuongAoThun);
	}

	@Override
	public String toString(){
        String s = "";
        for(int i = 0; i < this.soLuong; i++){
            if(this.ds[i].getTrangThai() == true)
                s += this.ds[i].toString();
        }
        return(s);
	}

	public void ghiDSVaoFile(){	//ghi chung 1 file
		try {
			FileWriter file = new FileWriter("sanPham.txt", false);
			BufferedWriter bw = new BufferedWriter(file);

			for(int i = 0; i < soLuong; i++){
				bw.write(ds[i].toString2());
				bw.newLine();
			}
			bw.close();
			file.close();
		} catch (Exception e) {
			System.out.println("Loi khi mo file ghi");
		}
	}

	public void docDSTuFile(){
		ds = new ao[0]; // Mỗi lần đọc sẽ xóa hết các phần tử trong mảng
		soLuong = 0;
		try {
			FileReader file = new FileReader("sanPham.txt");
			BufferedReader br = new BufferedReader(file);

			String line = "";
			while (true){		
				line = br.readLine();
				if(line == null || line.equals("")){
					break;
				}
				String txt[] = line.split("#"); //tách chuỗi bằng dấu #
				float m = Float.parseFloat(txt[5]);	//chuyển giá
				int n = Integer.parseInt(txt[9]);	//chuyển số lượng
				boolean p = Boolean.parseBoolean(txt[10]);	//chuyển trạng thái
				if(txt[0].equals("SM")){
					ao x = new aoSoMi(txt[0], txt[1], txt[2], txt[3], txt[4], m, 
					txt[6], txt[7], txt[8], n, p, txt[11], txt[12]);
					this.them1Ao(x);
				}
				else if(txt[0].equals("TT")){
					int y = Integer.parseInt(txt[12]);	//chuyển số áo
					ao x = new aoTheThao(txt[0], txt[1], txt[2], txt[3], txt[4], m, 
					txt[6], txt[7], txt[8], n, p, txt[11], y, txt[13]);
					this.them1Ao(x);
				}
				else if(txt[0].equals("T")){
					ao x = new aoThun(txt[0], txt[1], txt[2], txt[3], txt[4], m, 
					txt[6], txt[7], txt[8], n, p, txt[11]);
					this.them1Ao(x);
				}
			}

			br.close();
			file.close();

		} catch (Exception e) {
			System.out.println("Loi khi mo file doc ");
			System.out.println(e);
		}
	}

	public ao[] getDs() {
		return ds;
	}

	public void setDs(ao[] ds) {
		this.ds = ds;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	
}
