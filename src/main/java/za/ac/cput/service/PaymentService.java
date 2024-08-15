package za.ac.cput.service;

/**
 * PaymentFactoryTest.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payments;
import za.ac.cput.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payments create(Payments payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payments> read(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public Payments update(Payments payment) {
        return paymentRepository.save(payment);
    }

    public void delete(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    public List<Payments> findAll() {
        return paymentRepository.findAll();
    }
}
