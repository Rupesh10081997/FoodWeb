package com.main.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.dao.PrivilegeDao;
import com.main.dao.RolePrivilegeDao;
import com.main.entities.Privilege;
import com.main.entities.PrivilegeActivity;
import com.main.entities.PrivilegeModule;
import com.main.entities.RolePrivilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PrivilegeServiceImpl implements PrivilegeService{

    @Autowired
    PrivilegeDao dao;

    @Autowired
    RolePrivilegeDao rolePrivilegeDao;

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

    @Override
    public List<PrivilegeModule> fetchLinkRoleWise() {
        List<RolePrivilege> rolePrivileges = rolePrivilegeDao.findAll();
        List<PrivilegeModule> privilegeModuleList = dao.findAll();

        return privilegeModuleList.stream()
                .map(module -> {
                    // Filter rolePrivileges by module ID
                    List<RolePrivilege> rolePrivilegesModule = rolePrivileges.stream()
                            .filter(rolePrivilege -> rolePrivilege.getPrivilegeModuleId() == module.getPrivilegeModuleId())
                            .collect(Collectors.toList());

                    // Filter activities within each module
                    List<PrivilegeActivity> filteredActivities = module.getActivity().stream()
                            .map(activity -> {
                                // Filter rolePrivileges by activity ID
                                Set<Integer> rolePrivilegesForActivity = rolePrivilegesModule.stream()
                                        .filter(rolePrivilege -> rolePrivilege.getPrivilegeActivityId() == activity.getPrivilegeActivityId())
                                        .map(RolePrivilege::getPrivilegeId)
                                        .collect(Collectors.toSet());

                                // Filter privileges within each activity
                                List<Privilege> filteredPrivileges = activity.getPrivilege().stream()
                                        .map(privilege -> {
                                            if(rolePrivilegesForActivity.contains(privilege.getPrivilegeId())){
                                                privilege.setAssign(true);
                                            }
                                            return privilege;
                                        })
                                        .collect(Collectors.toList());

                                // Set filtered privileges to the activity
                                activity.setPrivilege(filteredPrivileges);
                                return activity;
                            })
                            .collect(Collectors.toList());

                    // Set filtered activities to the module
                    module.setActivity(filteredActivities);
                    return module;
                })
                .collect(Collectors.toList());
    }


}
