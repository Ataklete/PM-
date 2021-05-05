package miu.bankapi.bank.service;

import miu.bankapi.bank.model.Transaction;
import miu.bankapi.bank.model.TransactionHist;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.Map;



public interface TransactionHistService {

	void saveTransactionHist(Transaction transaction, boolean response, LocalDate date, LocalTime time);
	
	List<TransactionHist> getAllTransactionHist();
	double getTotalTransaction(boolean response);

    double getTotalTransactionAmt();

    Map<Month, Double> getTransactionByMonth(int i);
}
