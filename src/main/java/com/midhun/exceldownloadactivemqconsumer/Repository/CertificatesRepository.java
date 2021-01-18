package com.midhun.exceldownloadactivemqconsumer.Repository;

import com.midhun.exceldownloadactivemqconsumer.model.Certifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatesRepository extends JpaRepository<Certifications, Integer> {
}
