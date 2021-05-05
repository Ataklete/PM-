package miu.bankapi.bank.repository;


import miu.bankapi.bank.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

	public PaymentMethod findPaymentMethodByname(String name);
}
