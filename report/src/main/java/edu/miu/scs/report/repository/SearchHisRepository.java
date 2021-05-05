package edu.miu.scs.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.miu.scs.report.domain.SearchHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHisRepository extends JpaRepository<SearchHistory, Long> {

}
