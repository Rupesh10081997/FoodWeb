package com.main.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.dao.PrivilegeDao;
import com.main.entities.PrivilegeActivity;
import com.main.entities.PrivilegeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService{

    @Autowired
    PrivilegeDao dao;

    @Override
    public List<PrivilegeModule> getAllLink() {
        return dao.findAll();
    }

    @Override
    public String createAcl(MultipartFile file) throws IOException{
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            List<PrivilegeModule> modules;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                modules = objectMapper.readValue(reader, new TypeReference<List<PrivilegeModule>>() {});
            }
            dao.saveAll(modules);
        }catch(Exception ex){
            System.out.println("Error : "+ex.getMessage());
            ex.printStackTrace();
        }
        return "Acl created successfully";
    }


}
