package za.ac.cput.service;

/**
 * IPaymentS.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import za.ac.cput.domain.Payments;

import java.util.List;

public interface IPayment extends IService<Payments, Long> {
    List<Payments> findByPaymentStatus(String paymentStatus);

    Payments findByUser_Id(Long id);
}
