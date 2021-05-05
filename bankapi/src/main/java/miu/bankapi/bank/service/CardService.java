package miu.bankapi.bank.service;


import java.util.List;




import miu.bankapi.bank.model.Card;


public interface CardService {
	
	public void addCard(Card card);
	public Card getCard(Long cardnumber);
	public List<Card> getAllCards();
	public boolean validateDate(int year, int month);
	public boolean validateCVV(int cvv);
	public String getCardType(Long cardnumber);
	public String addNewCard(Card card);

	
}
