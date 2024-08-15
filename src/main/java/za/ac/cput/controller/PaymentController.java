package za.ac.cput.controller;

/**
 * PaymentController.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payments;
import za.ac.cput.service.PaymentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Payments> createPayment(@RequestBody Payments payment) {
        Payments created = paymentService.create(payment);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Payments> readPayment(@PathVariable Long id) {
        Optional<Payments> payment = paymentService.read(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    public ResponseEntity<Payments> updatePayment(@RequestBody Payments payment) {
        Payments updated = paymentService.update(payment);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payments>> getAllPayments() {
        List<Payments> payments = paymentService.findAll();
        return ResponseEntity.ok(payments);
    }
}
