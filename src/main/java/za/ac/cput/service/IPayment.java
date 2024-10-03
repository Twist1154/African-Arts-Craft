package za.ac.cput.service;

import za.ac.cput.domain.Payments;

import java.util.List;

public interface IPayment extends IService<Payments, Long> {
    List<Payments> findByPaymentStatus(String paymentStatus);

    Payments findByUser_Id(Long id);
}
