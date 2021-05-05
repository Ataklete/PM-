package miu.bankapi.bank.repository;

import java.math.BigInteger;

;
import miu.bankapi.bank.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CardRepository extends JpaRepository<Card, Long>
{

}
