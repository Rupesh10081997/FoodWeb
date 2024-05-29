package com.main.service;

import com.main.entities.PrivilegeModule;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PrivilegeService {

    String createAcl(MultipartFile file) throws IOException;

    List<PrivilegeModule> getAllLink();
}
