// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;

// public class CustomerManager {
//     private static final String FILE_NAME = "customers.txt";
//     private List<Customer> customers;

//     public CustomerManager() {
//         customers = new ArrayList<>();
//         loadCustomersFromFile();
//     }

//     public void addCustomer(Customer customer) {    
//         customers.add(customer);
//         saveCustomersToFile();
//     }

//     public void updateAccumulatedAmount(String phone, double newAmount) {
//         for (Customer customer : customers) {
//             if (customer.getPhone().equals(phone)) {
//                 customer.setAccumulatedAmount(newAmount);
//                 saveCustomersToFile();
//                 System.out.println("Cập nhật thành công tiền tích lũy cho khách hàng: " + phone);
//                 return;
//             }
//         }
//         System.out.println("Không tìm thấy khách hàng với số điện thoại: " + phone);
//     }

//     public Customer findCustomerByPhone(String phone) {
//         for (Customer customer : customers) {
//             if (customer.getPhone().equals(phone)) {
//                 return customer;
//             }
//         }
//         return null;
//     }

//     public void saveCustomersToFile() {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
//             for (Customer customer : customers) {
//                 writer.write(customer.toString());
//                 writer.newLine();
//             }
//             System.out.println("Lưu dữ liệu khách hàng vào file thành công.");
//         } catch (IOException e) {
//             System.out.println("Đã xảy ra lỗi khi ghi dữ liệu vào file.");
//             e.printStackTrace();
//         }
//     }

//     private void loadCustomersFromFile() {
//         try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] data = line.split(",");
//                 if (data.length == 3) {
//                     String phone = data[0];
//                     String name = data[1];
//                     double accumulatedAmount = Double.parseDouble(data[2]);
//                     customers.add(new Customer(phone, name, accumulatedAmount));
//                 }
//             }
//             System.out.println("Đọc dữ liệu khách hàng từ file thành công.");
//         } catch (IOException e) {
//             System.out.println("Đã xảy ra lỗi khi đọc dữ liệu từ file.");
//             e.printStackTrace();
//         }
//     }
// }
