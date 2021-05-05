package edu.miu.scs.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.miu.scs.report.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
