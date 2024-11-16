// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         CustomerManager manager = new CustomerManager();

//         while (true) {
//             System.out.println("\n1. Thêm khách hàng mới");
//             System.out.println("2. Cập nhật tiền tích lũy cho khách hàng");
//             System.out.println("3. Thanh toán hóa đơn cho khách hàng");
//             System.out.println("4. Thoát");
//             System.out.print("Chọn một tùy chọn: ");
//             int choice = scanner.nextInt();
//             scanner.nextLine(); // Đọc bỏ dòng mới

//             if (choice == 1) {
//                 System.out.print("Nhập số điện thoại: ");
//                 String phone = scanner.nextLine();
//                 System.out.print("Nhập họ tên: ");
//                 String name = scanner.nextLine();
//                 System.out.print("Nhập tiền tích lũy ban đầu: ");
//                 double accumulatedAmount = scanner.nextDouble();
//                 scanner.nextLine(); // Đọc bỏ dòng mới

//                 Customer customer = new Customer(phone, name, accumulatedAmount);
//                 manager.addCustomer(customer);
                
//             } else if (choice == 2) {
//                 System.out.print("Nhập số điện thoại khách hàng cần cập nhật: ");
//                 String phone = scanner.nextLine();
//                 System.out.print("Nhập số tiền tích lũy mới: ");
//                 double newAmount = scanner.nextDouble();
//                 scanner.nextLine(); // Đọc bỏ dòng mới
                
//                 manager.updateAccumulatedAmount(phone, newAmount);

//             } else if (choice == 3) {
//                 System.out.print("Nhập số điện thoại khách hàng cần thanh toán: ");
//                 String phone = scanner.nextLine();
//                 Customer customer = manager.findCustomerByPhone(phone); // Tìm khách hàng theo số điện thoại

//                 if (customer != null) {
//                     String name = customer.getName();
//                     System.out.print("Khách hàng: " + name + "\nSĐT " + phone);
//                     System.out.print("\nNhập số tiền của hóa đơn: ");
//                     double billAmount = scanner.nextDouble();
//                     scanner.nextLine(); // Đọc bỏ dòng mới

//                         // Hiển thị lựa chọn thanh toán
//                         System.out.println("Chọn phương thức thanh toán:");
//                         System.out.println("1. Thanh toán bằng điểm tích lũy");
//                         System.out.println("2. Thanh toán bình thường (không dùng điểm tích lũy)");
//                         System.out.print("Nhập lựa chọn của bạn: ");
//                         int paymentChoice = scanner.nextInt();
//                         scanner.nextLine(); // Đọc bỏ dòng mới
                
//                         double finalAmount = billAmount; // Số tiền cuối cùng cần thanh toán
                
//                         if (paymentChoice == 1) {
//                             // Thanh toán bằng điểm tích lũy
//                             finalAmount = Promotion.applyPromotion(customer, billAmount);
//                             System.out.println("Số tiền cần thanh toán sau khi dùng điểm tích lũy: " + finalAmount);
//                         } else if (paymentChoice == 2) {
//                             // Không sử dụng điểm tích lũy
//                             double accumulatedIncrease = billAmount * 0.01; // Tích lũy thêm 1%
//                             customer.setAccumulatedAmount(customer.getAccumulatedAmount() + accumulatedIncrease);
//                             System.out.println("Thanh toán không sử dụng điểm tích lũy. Số tiền cần thanh toán: " + finalAmount);
//                             System.out.println("Tiền tích lũy mới: " + customer.getAccumulatedAmount());
//                         } else {
//                             System.out.println("Lựa chọn không hợp lệ.");
//                         }
                
//                         // Lưu dữ liệu khách hàng cập nhật vào file
//                         manager.saveCustomersToFile();
//                     } else {
//                         System.out.println("Không tìm thấy khách hàng với số điện thoại này.");
//                     }
//             } else if (choice == 4) {
//                 System.out.println("Thoát chương trình.");
//                 break;
//             } else {
//                 System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
//             }
//         }
        
//         scanner.close();
//     }
// }
