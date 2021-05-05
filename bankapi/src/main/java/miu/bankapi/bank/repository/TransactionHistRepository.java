package miu.bankapi.bank.repository;



import miu.bankapi.bank.model.TransactionHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface TransactionHistRepository extends JpaRepository<TransactionHist, Long> {
	
}
