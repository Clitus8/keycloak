package org.example.demokeycloakbe.bean;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ManagerBean {
    public String id;
    public String name;
    public String managerRole;
    public String address;

    public ManagerBean(String id, String name, String managerRole, String address) {
        super();
        this.id = id;
        this.name = name;
        this.managerRole = managerRole;
        this.address = address;
    }

}
