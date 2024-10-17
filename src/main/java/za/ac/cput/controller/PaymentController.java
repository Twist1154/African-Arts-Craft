package za.ac.cput.controller;

/**
 * PaymentController.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payments;
import za.ac.cput.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Payments> createPayment(@RequestBody Payments payment) {
        logger.debug("Request to create payment: {}", payment);
        Payments created = paymentService.create(payment);
        logger.debug("Payment created successfully: {}", created);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Payments> readPayment(@PathVariable Long id) {
        logger.debug("Request to read payment with ID: {}", id);
        Payments payment = paymentService.read(id);
        if (payment != null) {
            logger.debug("Payment found: {}", payment);
            return ResponseEntity.ok(payment);
        } else {
            logger.debug("Payment with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Payments> updatePayment(@RequestBody Payments payment) {
        logger.debug("Request to update payment: {}", payment);
        Payments updated = paymentService.update(payment);
        logger.debug("Payment updated successfully: {}", updated);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        logger.debug("Request to delete payment with ID: {}", id);
        paymentService.delete(id);
        logger.debug("Payment with ID: {} deleted successfully", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payments>> getAllPayments() {
        logger.debug("Request to retrieve all payments");
        List<Payments> payments = paymentService.findAll();
        logger.debug("Retrieved all payments: {}", payments);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Payments>> findByPaymentStatus(@PathVariable String status) {
        logger.debug("Request to find payments with status: {}", status);
        List<Payments> payments = paymentService.findByPaymentStatus(status);
        if (payments.isEmpty()) {
            logger.debug("No payments found with status: {}", status);
            return ResponseEntity.notFound().build();
        } else {
            logger.debug("Payments found with status {}: {}", status, payments);
            return ResponseEntity.ok(payments);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Payments> findByUserId(@PathVariable Long userId) {
        logger.debug("Request to find payment by user ID: {}", userId);
        Payments payment = paymentService.findByUser_Id(userId);
        if (payment != null) {
            logger.debug("Payment found for user ID {}: {}", userId, payment);
            return ResponseEntity.ok(payment);
        } else {
            logger.debug("No payment found for user ID: {}", userId);
            return ResponseEntity.notFound().build();
        }
    }
}
