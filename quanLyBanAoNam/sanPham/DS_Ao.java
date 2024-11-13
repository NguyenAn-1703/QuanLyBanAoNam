package quanLyBanAoNam.sanPham;

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
		System.out.println("4) Them k ao.");
		System.out.println("5) Tim kiem theo ID ao.");
		System.out.println("6) Thong ke ao ton kho.");
		System.out.println("7) Thoat chuc nang.");
		keBien.ke();
	}

	public void startUp(){				// sửa sau
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
			else if(key.equals("5")){	//Tim kiem theo ID
				this.timKiemTheoID();
			}
			else if(key.equals("6")){	//Thong ke so luong
				this.thongKe();
			}
			else if(key.equals("7")){
				keBien.ke();
				System.out.println("Da thoat chuc nang.");
				break;
			}
			else{
				System.out.println("Du lieu khong hop le vui long nhap lai !!!");
			}		
		}
	}

	public void nhapNPTPhieuNhap() {		// p.thức nhập n phần tử đầu cho danh sách - yêu cầu 2a)
		if(soLuong == 0){				// đổi thành đọc dữ liệu từ file
			System.out.println("Nhap vao so loai ao muon nhap hang : ");	//xài cho chức năng nhập hàng
			int n = Integer.parseInt(sc.nextLine());
			for(int i = 0; i < n; i++){
				while(true){
					String key;
					this.MenuAo();
					key = sc.nextLine();
					if(key.equals("1")){
						ao x = new aoSoMi();
						x.nhap();
						them1Ao(x);
						break;
					}
					else if(key.equals("2")){
						ao x = new aoTheThao();
						x.nhap();
						them1Ao(x);
						break;
					}
					else if(key.equals("3")){
						ao x = new aoThun();
						x.nhap();
						them1Ao(x);
						break;
					}
					System.out.println("Du lieu khong hop le, vui long nhap lai !!! ");
				}
			}
		}
		else{
			System.out.println("Da co san danh sach !!!");
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
				them1Ao(x);
				break;
			}
			else if(key.equals("2")){
				ao x = new aoTheThao();
				x.nhap();
				them1Ao(x);
				break;
			}
			else if(key.equals("3")){
				ao x = new aoThun();
				x.nhap();
				them1Ao(x);
				break;
			}
			System.out.println("Du lieu khong hop le, vui long nhap lai !!! ");
		}
		ghiDSVaoFile();
	}

	public void themKAo(){	//Yêu cầu 2c)
		docDSTuFile();
		System.out.println("Vui long nhap so loai ao muon them : ");
		int k = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < k; i++){
			them1Ao();
		}
		ghiDSVaoFile();
	}

	public void themKAo(ao[] a, int n){	// sử dụng cho chức năng nhập hàng
		docDSTuFile();
		for(int i = 0; i < n; i++){
			them1Ao(a[i]);
		}
		ghiDSVaoFile();
	}

	public static void MenuAo(){
		System.out.println("Vui long chon kieu ao :");
		System.out.println("1) Ao So Mi.");
		System.out.println("2) Ao The Thao.");
		System.out.println("3) Ao Thun.");
	}

	
	public void timKiemTheoID(){	//Yêu cầu 2f) - còn thiếu khóa tìm kiếm **
		docDSTuFile();
		System.out.println("Vui long nhap vao id ao can tim : ");
		String ID = sc.nextLine();
		ao x = getAoByID(ID);
		if(x != null){
			System.out.println("Thong tin cua ao id so " + ID + " : ");
			x.xuat();
		}
		else{
			return;
		}
	}

	public ao getAoByID(String ID){	//Xài thêm cho chức năng chọn áo trong class hóa đơn
		for(int i = 0; i < soLuong; i++){
			if(ds[i].getId().equals(ID)){
				return(ds[i]);
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


	public void thongKe(){		//yêu cầu 2g)
		docDSTuFile();
		int soLuongAoSoMi, soLuongAoTheThao, soLuongAoThun, tongSoAo;
			soLuongAoSoMi = soLuongAoTheThao = soLuongAoThun = tongSoAo = 0;
		for(int i = 0; i < soLuong; i++){
			if(ds[i] instanceof aoSoMi){
				soLuongAoSoMi += ds[i].getSoLuongTonKho();
			}
			if(ds[i] instanceof aoTheThao){
				soLuongAoTheThao += ds[i].getSoLuongTonKho();
			}
			if(ds[i] instanceof aoThun){
				soLuongAoThun += ds[i].getSoLuongTonKho();
			}
		}
		tongSoAo = soLuongAoSoMi + soLuongAoTheThao + soLuongAoThun;
		System.out.println("Thong ke so luong ao ton kho trong danh sach : ");
		System.out.println("+ So luong ao ton kho : " + tongSoAo);
		System.out.println("So luong ao so mi : " + soLuongAoSoMi);
		System.out.println("So luong ao the thao : " + soLuongAoTheThao);
		System.out.println("So luong ao thun : " + soLuongAoThun);
	}

	@Override
	public String toString(){
		String s = "";
		for(int i = 0; i < soLuong; i++){
			s += ds[i].toString();
		}
		return(s);
	}

	public void ghiDSVaoFile(){	//mỗi loại áo sẽ ghi một file khác nhau
		try {
			FileWriter file1 = new FileWriter("aoSoMi.txt", false);
			BufferedWriter bw1 = new BufferedWriter(file1);

			FileWriter file2 = new FileWriter("aoTheThao.txt", false);
			BufferedWriter bw2 = new BufferedWriter(file2);

			FileWriter file3 = new FileWriter("aoThun.txt", false);
			BufferedWriter bw3 = new BufferedWriter(file3);

			for(int i = 0; i < soLuong; i++){
				if(ds[i] instanceof aoSoMi){
					bw1.write(ds[i].toString2());
					bw1.newLine();
				}

				if(ds[i] instanceof aoTheThao){
					bw2.write(ds[i].toString2());
					bw2.newLine();
				}

				if(ds[i] instanceof aoThun){
					bw3.write(ds[i].toString2());
					bw3.newLine();
				}
			}
			bw1.close();
			file1.close();
			bw2.close();
			file2.close();
			bw3.close();
			file3.close();
		} catch (Exception e) {
			System.out.println("Loi khi mo file ghi");
		}
	}

	public void docDSTuFile(){
		ds = new ao[0]; // Mỗi lần đọc sẽ xóa hết các phần tử trong mảng
		soLuong = 0;
		try {
			FileReader fr1 = new FileReader("aoSoMi.txt");
			BufferedReader br1 = new BufferedReader(fr1);
			FileReader fr2 = new FileReader("aoTheThao.txt");
			BufferedReader br2 = new BufferedReader(fr2);
			FileReader fr3 = new FileReader("aoThun.txt");
			BufferedReader br3 = new BufferedReader(fr3);

			String line = "";
			while (true){		//đọc file áo sơ mi.
				line = br1.readLine();
				if(line == null || line.equals("")){
					break;
				}
				String txt[] = line.split("#"); //tách chuỗi bằng dấu #
				float n = Float.parseFloat(txt[4]);
				int m = Integer.parseInt(txt[8]);
				ao x = new aoSoMi(txt[0], txt[1], txt[2], txt[3], n, 
				txt[5], txt[6], txt[7], m, txt[9], txt[10]);
				this.them1Ao(x);
			}

			fr1.close();
			br1.close();

			while(true){		//đọc file áo thể thao
				line = br2.readLine();
				if(line == null || line.equals("")){
					break;
				}
				String txt[] = line.split("#"); //tach chuoi mien co khoang cach
				float n = Float.parseFloat(txt[4]);
				int m = Integer.parseInt(txt[8]);
				int p = Integer.parseInt(txt[10]);
				ao x = new aoTheThao(txt[0], txt[1], txt[2], txt[3], n, 
				txt[5], txt[6], txt[7], m, txt[9], p, txt[11]);
				this.them1Ao(x);
			}
			
			fr2.close();
			br2.close();

			while(true){		//đọc file áo thun
				line = br3.readLine();
				if(line == null || line.equals("")){
					break;
				}
				String txt[] = line.split("#"); //tach chuoi mien co khoang cach
				float n = Float.parseFloat(txt[4]);
				int m = Integer.parseInt(txt[8]);
				ao x = new aoThun(txt[0], txt[1], txt[2], txt[3], n, 
				txt[5], txt[6], txt[7], m, txt[9]);
				this.them1Ao(x);
			}
			
			fr3.close();
			br3.close();

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
