package quanLyBanAoNam.sanPham;

import java.util.Scanner;
import java.util.Arrays;

public class DS_Ao {
	private ao[] ds = new ao[0];
	private static int soLuong;
	public static Scanner sc = new Scanner(System.in);
	//làm theo file yêu cầu đồ án

	public void nhapNPhanTuDau() {		// p.thức nhập n phần tử đầu cho danh sách - yêu cầu 2a)
		if(soLuong == 0){
			System.out.println("Nhap vao so luong ao muon nhap : ");
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
		for (int i = 0; i < soLuong; i++){
			System.out.println("----------------------------------");
			ds[i].xuat();
		}
	}

	public void them1Ao(ao x){	//Yêu cầu 2c)
		ao[] dsnew = Arrays.copyOf(ds, soLuong + 1);
		dsnew[soLuong] = x;
		ds = dsnew;
		soLuong++;
	}

	public void them1Ao(){	//Overloading - Yêu cầu 2c)
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

	public void themKAo(){	//Yêu cầu 2c)
		System.out.println("Vui long nhap so luong ao muon them : ");
		int k = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < k; i++){
			them1Ao();
		}
	}

	public static void MenuAo(){
		System.out.println("Vui long chon loai ao :");
		System.out.println("1) Ao So Mi.");
		System.out.println("2) Ao The Thao.");
		System.out.println("3) Ao Thun.");
	}

	
	public void timKiemTheoID(){	//Yêu cầu 2f) - còn thiếu khóa tìm kiếm **
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
	
	// public void thongKe(){
	// 	int tongSoLuongTonKho = 0;
	// 	int tongSoLuongBan = 0;
	// 	for (int i = 0; i < soLuong; i++){
	// 		tongSoLuongTonKho += ds[i].getSoLuongTonKho();
	// 		tongSoLuongBan += ds[i].getSoLuongBan();
	// 	}
	// 	System.out.println("Tong so luong ton kho : " + tongSoLuongTonKho);
	// 	System.out.println("Tong so luong da ban: " + tongSoLuongBan);
	// }

	// public void sapXepTheoID(){
	// 	Arrays.sort(ds, 0, soLuong, (ao1, ao2) -> ao1.getId().compareTo(ao2.getId()));
	// }

	// public void docDSAoTuFile(String path){

	// }

	// public void getDSAoTuFile(String path){

	// }

	public void thongKe(){		//yêu cầu 2g)
		int soLuongAoSoMi, soLuongAoTheThao, soLuongAoThun;
			soLuongAoSoMi = soLuongAoTheThao = soLuongAoThun = 0;
		for(int i = 0; i < soLuong; i++){
			if(ds[i] instanceof aoSoMi){
				soLuongAoSoMi++;
			}
			if(ds[i] instanceof aoTheThao){
				soLuongAoTheThao++;
			}
			if(ds[i] instanceof aoThun){
				soLuongAoThun++;
			}
		}
		System.out.println("Thong ke so luong ao ton kho trong danh sach : ");
		System.out.println("+ So luong ao ton kho : " + soLuong);
		System.out.println("So luong ao so mi : " + soLuongAoSoMi);
		System.out.println("So luong ao the thao : " + soLuongAoTheThao);
		System.out.println("So luong ao thun : " + soLuongAoThun);

	}
}
