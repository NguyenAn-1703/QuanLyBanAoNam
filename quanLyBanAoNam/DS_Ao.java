package quanLyBanAoNam;

import java.util.Scanner;
import java.util.Arrays;

public class DS_Ao {
	private ao[] ds = new ao[0];
	private static int soLuong;
	public static Scanner sc = new Scanner(System.in);

	public void nhapNPhanTuDau() {	//làm theo file yêu cầu đề án
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
						ao x = new aoThun();
						x.nhap();
						them1Ao(x);
						break;
					}
					else if(key.equals("3")){
						ao x = new aoTheThao();
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

	public void them1Ao(ao x){
		ao[] dsnew = Arrays.copyOf(ds, soLuong + 1);
		dsnew[soLuong] = x;
		ds = dsnew;
		soLuong++;
	}

	public static void MenuAo(){
		System.out.println("Vui long chon loai ao :");
		System.out.println("1) Ao So Mi.");
		System.out.println("2) Ao The Thao.");
		System.out.println("3) Ao Thun.");
	}

	public void xuat(){
		System.out.println("----------------------------------");
		for (int i = 0; i < soLuong; i++){
			ds[i].xuat();
		}
	}

	// public void them1Ao(Ao ao){
	// 	if (soLuong < ds.length){
	// 		ds[soLuong] = ao;
	// 		soLuong++;
	// 	} else {
	// 		System.out.print("Danh sach da day, khong the them ao moi.");
	// 	}
	// }

	// public void themKAo(int k){
	// 	Scanner scanner = new Scanner(System.in);
	// 	for (int i = 0; i < k; i++){
	// 		if (soLuong < ds.length){
	// 			Ao ao = new Ao();
	// 			ao.nhap();
	// 			them1Ao(ao);
	// 		} else {
	// 			System.out.println("Danh sach da day, khong them them ao moi.");
	// 			break;
	// 		}
	// 	}
	// }

	// public void timKiemTheoID(String id){
	// 	boolean timThay = false;
	// 	for (int i = 0; i < soLuong; i++){
	// 		if (ds[i].getId().equals(id)){
	// 			ds[i].xuat();
	// 			timThay = true;
	// 			break;
	// 		}
	// 	}
	// 	if (!timThay){
	// 		System.out.println("Khong tim thay ao voi ID: " + id);
	// 	}
	// }

	// public void timKiemTheoTen(String ten){
	// 	boolen timThay = false;
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
}