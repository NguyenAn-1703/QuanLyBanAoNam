package quanLyBanAoNam;

import java.util.Scanner;
import java.util.Arrays;

public class DS_Ao {
	private ao ds[];
	private int soLuong;
	private int idCuoi = 0;

	public DS_Ao(int kichThuoc){
		ds = new ao[kichThuoc];
		soLuong = 0;
	}

	public void nhap() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap so luonng ao muon them: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < n; i++){
			if (soLuong < ds.length){
				ao ao = new ao();
				ao.nhap();
				them1Ao(ao);
			} else {
				System.out.println("Danh sach da day, khong the them ao moi");
				break;
			}
		}
	}

	public void xuat(){
		for (int i = 0; i < soLuong; i++){
			ds[i].xuat();
		}
	}

	public void them1Ao(ao ao){
		if (soLuong < ds.length){
			ds[soLuong] = ao;
			soLuong++;
		} else {
			System.out.print("Danh sach da day, khong the them ao moi.");
		}
	}

	public void themKAo(int k){
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < k; i++){
			if (soLuong < ds.length){
				ao ao = new ao();
				ao.nhap();
				them1Ao(ao);
			} else {
				System.out.println("Danh sach da day, khong them them ao moi.");
				break;
			}
		}
	}

	public void timKiemTheoID(String id){
		boolean timThay = false;
		for (int i = 0; i < soLuong; i++){
			if (ds[i].getId().equals(id)){
				ds[i].xuat();
				timThay = true;
				break;
			}
		}
		if (!timThay){
			System.out.println("Khong tim thay ao voi ID: " + id);
		}
	}

	public void timKiemTheoTen(String ten){
		boolean timThay = false;
		for (int i = 0; i < soLuong; i++){
			if (ds[i].getTen().equalsIgnoreCase(ten)){
				ds[i].xuat();
				timThay = true;
			}
		}
		if (!timThay){
			System.out.println("Khong tim thay ao voi ten: " + ten);
		}
	}
	
	public void thongKe(){
		int tongSoLuongTonKho = 0;
		int tongSoLuongBan = 0;
		for (int i = 0; i < soLuong; i++){
			tongSoLuongTonKho += ds[i].getSoLuongTonKho();
			tongSoLuongBan += ds[i].getSoLuongBan();
		}
		System.out.println("Tong so luong ton kho : " + tongSoLuongTonKho);
		System.out.println("Tong so luong da ban: " + tongSoLuongBan);
	}

	public void sapXepTheoID(){
		Arrays.sort(ds, 0, soLuong, (ao1, ao2) -> ao1.getId().compareTo(ao2.getId()));
	}

	public void docDSAoTuFile(String path){

	}

	public void getDSAoTuFile(String path){

	}
}