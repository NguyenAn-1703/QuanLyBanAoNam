// public class Customer {
//     private static int customerCount = 0; // Bộ đếm số thứ tự
//     private int id;                       // Mã số khách hàng
//     private String phone;
//     private String name;
//     private double accumulatedAmount;

//     // Constructor
//     public Customer(String phone, String name, double accumulatedAmount) {
//         this.id = ++customerCount; // Tự động tăng bộ đếm và gán cho `id`
//         this.phone = phone;
//         this.name = name;
//         this.accumulatedAmount = accumulatedAmount;
//     }

//     // Các getter và setter
//     public int getId() {
//         return id;
//     }

//     public String getPhone() {
//         return phone;
//     }

//     public void setPhone(String phone) {
//         this.phone = phone;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public double getAccumulatedAmount() {
//         return accumulatedAmount;
//     }

//     public void setAccumulatedAmount(double accumulatedAmount) {
//         this.accumulatedAmount = accumulatedAmount;
//     }

//     @Override
//     public String toString() {
//         return "ID: " + id + ", Số điện thoại: " + phone + ", Họ tên: " + name + ", Tiền tích lũy: " + accumulatedAmount;
//     }
// }
