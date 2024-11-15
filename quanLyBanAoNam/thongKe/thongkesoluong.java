// package quanLyBanAoNam.thongKe;

// import java.io.BufferedReader;
// import java.io.FileReader;

// public class thongkesoluong extends thongke {
//     private int sokhachhang ;
//     private double tongtien ;
//     public int[] timthongketheothang() {
//         int[] sosanphamthang = new int[12];

//         String filePath = "ds hóa đơn ";

//         try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//             String line;
//             br.readLine(); // Bỏ qua dòng tiêu đề

//             while ((line = br.readLine()) != null) {
//                 String[] values = line.split(",");

//                 int month = Integer.parseInt(values[0]) - 1; // Lấy tháng và điều chỉnh cho phù hợp với mảng

//                 // Tăng số lượng hóa đơn cho tháng tương ứng
//                 sosanphamthang[month]++;
//             }
//         } catch (IOException e) {
//             System.out.println("Đã xảy ra lỗi khi đọc file " );
//         }
//         return sosanphamthang;
//     }
//     public void thongketheothang(){
//         // In tổng số sản phẩm đã bán theo từng tháng
//         int[] a=timthongketheothang();
//         System.out.println("Tổng số hóa đơn đã bán ra theo từng tháng:");
//         for (int i = 0; i < 12; i++) {
//             System.out.println("Tháng " + (i + 1) + ": " + a[i] + " hóa đơn");
//         }
//     }

//     @Override
//     public int[] timthongketheoquy() {
//         int[] soluongtungthang = timthongketheothang();// số lượng từng tháng

//         int[] quy = new int[4];
//         quy[0] = soluongtungthang[0] + soluongtungthang[1] + soluongtungthang[2];
//         quy[1] = soluongtungthang[3] + soluongtungthang[4] + soluongtungthang[5];
//         quy[2] = soluongtungthang[6] + soluongtungthang[7] + soluongtungthang[8];
//         quy[3] = soluongtungthang[9] + soluongtungthang[10] + soluongtungthang[11];

//         return quy;


//     }
//     public void thongkehteoquy(){
//         int[] quy=timthongketheoquy();
//         // In ra kết quả số lượng bán theo quý
//         System.out.println("Số lượng hóa đơn bán ra theo quý:");
//         for (int i = 0; i < 4; i++) {
//             System.out.println("Quý " + (i + 1) + ": " + quy[i] + " hóa đơn");
//         }
//     }

//     @Override
//     public void thongketheonam() {
//         int[] soluongtungquy = timthongketheoquy();
//         int nam ;
//         nam = soluongtungquy[0] + soluongtungquy[1] + soluongtungquy[2];
//         System.out.println("Số lượng hóa đơn bán ra theo năm:" +nam);

//     }