package org.example.demokeycloakbe.controller;

import org.example.demokeycloakbe.bean.AdminBean;
import org.example.demokeycloakbe.bean.ManagerBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @GetMapping(value = "/api/v1/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<AdminBean> getCustomer() {
        List<AdminBean> adminList = new ArrayList<>();

        AdminBean v1 = new AdminBean("1", "customer 1", "ADMIN");
        AdminBean v2 = new AdminBean("2", "customer 2", "SUPER_ADMIN");

        adminList.add(v1);
        adminList.add(v2);
        return adminList;
    }

    @GetMapping(value = "/api/v1/manager")
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    public List<ManagerBean> getManager() {
        List<ManagerBean> managerList = new ArrayList<>();

        ManagerBean v1 = new ManagerBean("1", "customer 1", "MANAGER", "VietNam");
        ManagerBean v2 = new ManagerBean("2", "customer 2", "EXECUTIVE", "HaNoi");

        managerList.add(v1);
        managerList.add(v2);
        return managerList;
    }

}
