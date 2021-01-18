package com.midhun.exceldownloadactivemqconsumer.Repository;

import com.midhun.exceldownloadactivemqconsumer.model.FileDownloads;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDownloadsRepository extends CrudRepository<FileDownloads, Integer> {
}
