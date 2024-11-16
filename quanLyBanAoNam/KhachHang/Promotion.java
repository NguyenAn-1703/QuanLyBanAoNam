// public class Promotion {
//     private static final double MINIMUM_ACCUMULATED_AMOUNT = 1000.0;
//     private static final double ACCUMULATION_RATE = 0.01; // 1% của hóa đơn

//     public static double applyPromotion(Customer customer, double billAmount) {
//         double finalAmount = billAmount;

//         if (customer.getAccumulatedAmount() > MINIMUM_ACCUMULATED_AMOUNT) {
//             finalAmount -= customer.getAccumulatedAmount(); // Trừ tiền tích lũy vào hóa đơn
//             if (finalAmount < 0) {
//                 finalAmount = 0; // Đảm bảo hóa đơn không âm
//             }
//             System.out.println("Đã áp dụng " + customer.getAccumulatedAmount() + " từ tiền tích lũy.");
//             customer.setAccumulatedAmount(0); // Đặt lại tiền tích lũy sau khi sử dụng
//         } else {
//             System.out.println("Tiền tích lũy không đủ để áp dụng khuyến mãi.");
//         }

//         double accumulatedIncrease = billAmount * ACCUMULATION_RATE;
//         customer.setAccumulatedAmount(customer.getAccumulatedAmount() + accumulatedIncrease);

//         System.out.println("Tiền tích lũy mới của khách hàng: " + customer.getAccumulatedAmount());
//         return finalAmount;
//     }
// }
