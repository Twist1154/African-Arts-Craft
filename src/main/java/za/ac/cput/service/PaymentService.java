package za.ac.cput.service;

/**
 * PaymentService.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Payments;
import za.ac.cput.repository.PaymentRepository;

import java.util.List;

@Service
@Transactional
public class PaymentService implements IPayment {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payments create(Payments payment) {
        return paymentRepository.save(payment);
    }

    @Override
    @Transactional(readOnly = true)
    public Payments read(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    @Override
    public Payments update(Payments payment) {
        return paymentRepository.save(payment);
    }


    public void delete(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Payments> findAll() {
        return paymentRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public List<Payments> findByPaymentStatus(String paymentStatus) {
        return paymentRepository.findByPaymentStatus(paymentStatus);
    }

    @Override
    @Transactional(readOnly = true)
    public Payments findByUser_Id(Long id) {
        return paymentRepository.findByUser_Id(id);
    }
}
