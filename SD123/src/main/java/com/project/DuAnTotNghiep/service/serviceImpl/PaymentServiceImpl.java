package com.project.DuAnTotNghiep.service.serviceImpl;

import com.project.DuAnTotNghiep.entity.Bill;
import com.project.DuAnTotNghiep.entity.Payment;
import com.project.DuAnTotNghiep.repository.PaymentRepository;
import com.project.DuAnTotNghiep.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void processPayment(Bill bill) {
        // Kiểm tra nếu đối tượng bill là null
        if (bill == null) {
            throw new IllegalArgumentException("Bill cannot be null");
        }

        // Khởi tạo đối tượng Payment
        Payment payment = new Payment();

        // Thiết lập bill cho payment
        payment.setBill(bill);

        // Lưu payment vào cơ sở dữ liệu hoặc thực hiện các hành động cần thiết khác
        paymentRepository.save(payment);
    }

}
