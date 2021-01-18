package com.midhun.exceldownloadactivemqconsumer.Repository;

import com.midhun.exceldownloadactivemqconsumer.model.CertificationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationHistoryRepository extends JpaRepository<CertificationHistory, Integer> {
}
