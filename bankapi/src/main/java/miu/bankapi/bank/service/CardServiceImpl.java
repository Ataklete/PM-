package miu.bankapi.bank.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import miu.bankapi.bank.model.Card;
import miu.bankapi.bank.model.PaymentMethod;
import miu.bankapi.bank.repository.CardRepository;
import miu.bankapi.bank.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CardServiceImpl implements CardService {

	
	@Autowired
	private CardRepository repository;
	@Autowired
	private PaymentMethodRepository payment;
	
	@Override
	public void addCard(Card card) {
		repository.save(card);
		
	}

	@Override
	public Card getCard(Long cardnumber) {
		Optional<Card> card = repository.findById(cardnumber);
		return card.orElse(null);
	}

	@Override
	public List<Card> getAllCards() {
		return repository.findAll();
	}
	
	
	public boolean validateDate(int year, int month) {
		LocalDate ld = LocalDate.now();
		if (year < ld.getYear() || (year == ld.getYear() && month < ld.getMonthValue())) return false;
		
		return true;
	}
	
	
	public boolean validateCVV(int cvv) {
		String newcvv = String.valueOf(cvv);
		if (newcvv.length() != 3)
		return false;
		
		return true;
	}
	
	@Override
	public String getCardType(Long cardnumber) {
		if (cardnumber.toString().length() < 13)
		return null;
		int num = Integer.parseInt(cardnumber.toString().substring(0, 4));
		List<PaymentMethod> method = payment.findAll();
		String cardtype = method.stream().filter(p -> p.getRangeFrom() <= num && p.getRangeTo() >= num).map(p -> p.getName()).findFirst().orElse(null);
		
		return cardtype;
	}
	
	
	@Override
	public String addNewCard(Card card) {
		
		int year = card.getYear();
		int month = card.getMonth();
		int cvv = card.getCvv();
		Long cardnumber = card.getCardNumber();
		String cardholder = card.getCardHolder();
		String address = card.getBillingAddress();
			
//			if (!validateDate(year, month))
//			return "Card expiration date is invalid";
//			if (!validateCVV(cvv))
//			return "Card number is invalid";
			Card newcard = new Card( cardnumber, cvv, cardholder, year, month, address);
			addCard(newcard);
			return "Card added successfully";
			
		}
}
