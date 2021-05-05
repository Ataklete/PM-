package miu.bankapi.bank.service;

import java.util.List;

import miu.bankapi.bank.model.PaymentMethod;
import miu.bankapi.bank.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

	@Autowired
	private PaymentMethodRepository repository;

	@Override
	public void addPaymentMethod(PaymentMethod paymentmethod) {
		repository.save(paymentmethod);

	}

	@Override
	public PaymentMethod findPaymentMethodByname(String name) {

		return repository.findPaymentMethodByname(name);

	}

	@Override
	public List<PaymentMethod> getAllPaymentMethod() {
		return repository.findAll();
	}
	
	
	@Override
	public PaymentMethod findPaymentMethodById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public void deletePaymentMethod(Long id) {
		repository.deleteById(id);
	}

}
