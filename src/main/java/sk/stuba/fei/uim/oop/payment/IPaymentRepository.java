package sk.stuba.fei.uim.oop.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
