package sk.stuba.fei.uim.oop.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private IPaymentRepository repository;

    @Override
    public Payment save(Payment p) {
        return this.repository.save(p);
    }
}
