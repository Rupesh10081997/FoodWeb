package com.main.service;

import com.main.dao.PrivilegeDao;
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
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
            List<PrivilegeModule> modules = new ArrayList<>();

            //dao.saveAll(modules);



        }catch(Exception ex){
            ex.printStackTrace();
        }

        return "";
    }


}
