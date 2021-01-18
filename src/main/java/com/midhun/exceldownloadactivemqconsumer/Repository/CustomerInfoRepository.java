package com.midhun.exceldownloadactivemqconsumer.Repository;

import com.midhun.exceldownloadactivemqconsumer.model.CustomerInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInfoRepository extends CrudRepository<CustomerInfo, Integer> {
    CustomerInfo findByUsername(String username);
}
