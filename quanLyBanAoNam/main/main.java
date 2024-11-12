package quanLyBanAoNam.main;

import quanLyBanAoNam.sanPham.phieuNhap;

public class main {
	public static void main(String[] args) {
		phieuNhap pn = new phieuNhap();
		pn.nhapNPhanTuDau();
		pn.them1Ao();
		pn.thongKe();
		pn.xuat();
	}
}
//test
// DS_Ao a = new DS_Ao();

// a.startUp();
//test

// aoSoMi[] aoSoMiList = new aoSoMi[10];
// aoThun[] aoThunList = new aoThun[10];
// aoTheThao[] aoTheThaoList = new aoTheThao[10];
// int aoSoMiCount = 0;
// int aoThunCount = 0;
// int aoTheThaoCount = 0;

// Scanner scanner = new Scanner(System.in);
// while (true) {
// 	System.out.println("--------------------------------");
// 	System.out.println("QUAN LY BAN AO NAM");
// 	System.out.println("--------------------------------");
// 	System.out.println("Chon loai ao:");
// 	System.out.println("1. Ao so mi");
// 	System.out.println("2. Ao thun");
// 	System.out.println("3. Ao the thao");
// 	System.out.println("4. Xem danh sach ao");
// 	System.out.println("5. Thoat chuong trinh");
// 	System.out.println("--------------------------------");
// 	System.out.print("Lua chon cua ban: ");
// 	int choice = scanner.nextInt();
// 	ao selectedAo;
// 	switch (choice) {
// 		case 1:
// 			selectedAo = new aoSoMi();
// 			selectedAo.nhap();
// 			if (aoSoMiCount == aoSoMiList.length) {
// 				aoSoMiList = new aoSoMi[aoSoMiList.length * 2];
// 			}
// 			aoSoMiList[aoSoMiCount++] = (aoSoMi) selectedAo;
// 			break;
// 		case 2:
// 			selectedAo = new aoThun();
// 			selectedAo.nhap();
// 			if (aoThunCount == aoThunList.length) {
// 				aoThunList = new aoThun[aoThunList.length * 2];
// 			}
// 			aoThunList[aoThunCount++] = (aoThun) selectedAo;
// 			break;
// 		case 3:
// 			selectedAo = new aoTheThao();
// 			selectedAo.nhap();
// 			if (aoTheThaoCount == aoTheThaoList.length) {
// 				aoTheThaoList = new aoTheThao[aoTheThaoList.length * 2];
// 			}
// 			aoTheThaoList[aoTheThaoCount++] = (aoTheThao) selectedAo;
// 			break;
// 		case 4:
// 			System.out.println("--------------------------------");
// 			System.out.println("CHON LOAI AO DE XEM DANH SACH");
// 			System.out.println("1. Ao so mi");
// 			System.out.println("2. Ao thun");
// 			System.out.println("3. Ao the thao");
// 			System.out.println("4. Xem tat ca");
// 			System.out.println("5.Thoat");
// 			System.out.println("--------------------------------");
// 			System.out.print("Lua chon cua ban: ");
// 			int choice2 = scanner.nextInt();
// 			switch (choice2) {
// 				case 1:
// 					if (aoSoMiCount == 0) {
// 						System.out.println("Chua co ao so mi nao!");
// 					} else {
// 						System.out.println("Danh sach ao so mi:");
// 						for (int i = 0; i < aoSoMiCount; i++) {
// 							aoSoMiList[i].xuat();
// 						}
// 					}
// 					break;
// 				case 2:
// 					if (aoThunCount == 0) {
// 						System.out.println("Chua co ao thun nao!");
// 					} else {
// 						System.out.println("Danh sach ao thun:");
// 						for (int i = 0; i < aoThunCount; i++) {
// 							aoThunList[i].xuat();
// 						}
// 					}
// 					break;
// 				case 3:
// 					if (aoTheThaoCount == 0) {
// 						System.out.println("Chua co ao the thao nao!");
// 					} else {
// 						System.out.println("Danh sach ao the thao:");
// 						for (int i = 0; i < aoTheThaoCount; i++) {
// 							aoTheThaoList[i].xuat();
// 						}
// 					}
// 					break;
// 				case 4:
// 					System.out.println("Danh sach ao so mi:");
// 					for (int i = 0; i < aoSoMiCount; i++) {
// 						aoSoMiList[i].xuat();
// 					}
// 					System.out.println("Danh sach ao thun:");
// 					for (int i = 0; i < aoThunCount; i++) {
// 						aoThunList[i].xuat();
// 					}
// 					System.out.println("Danh sach ao the thao:");
// 					for (int i = 0; i < aoTheThaoCount; i++) {
// 						aoTheThaoList[i].xuat();
// 					}
// 					break;
// 				case 5:
// 					System.out.println("Thoat chuong trinh");
// 					scanner.close();
// 					return;
// 			}
// 			break;
// 		case 5:
// 			System.out.println("Thoat chuong trinh.");
// 			scanner.close();
// 			return;
// 		default:
// 			System.out.println("Lua chon khong hop le!");
// 			continue;
// 	}
// }

//test: