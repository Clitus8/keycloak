package org.example.demokeycloakbe.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminBean {

        public String id;
        public String name;
        public String role;

        public AdminBean(String id, String name, String role) {
            super();
            this.id = id;
            this.name = name;
            this.role = role;
        }

}
