package com.miu.service;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelService {
    boolean batchImport(String fileName, MultipartFile file) throws Exception;
}
