package miu.bankapi.bank.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class TransactionHist {

	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name = "transaction_id")
	private Transaction transaction;
	private boolean response;
	private LocalDate date;
	private LocalTime time;

	public TransactionHist(Transaction transaction, boolean response, LocalDate date, LocalTime time) {
		this.transaction = transaction;
		this.response = response;
		this.date = date;
		this.time = time;

	}

	public TransactionHist() {

	}

	public Transaction getTransaction() {
		return transaction;
	}

	public boolean getResponse() {
		return response;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}
	public Month getMonth() {
		return date.getMonth();
	}
	public Double getTransactionAmount() {
		return transaction.getAmount();
	}

}
