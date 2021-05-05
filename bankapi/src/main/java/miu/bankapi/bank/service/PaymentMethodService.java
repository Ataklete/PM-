package miu.bankapi.bank.service;

import miu.bankapi.bank.model.PaymentMethod;

import java.util.List;



public interface PaymentMethodService {

	public void addPaymentMethod(PaymentMethod paymentmethod);

	public List<PaymentMethod> getAllPaymentMethod();

	public PaymentMethod findPaymentMethodByname(String name);
	
	public PaymentMethod findPaymentMethodById(Long id);
	
	public void deletePaymentMethod(Long id);

}
