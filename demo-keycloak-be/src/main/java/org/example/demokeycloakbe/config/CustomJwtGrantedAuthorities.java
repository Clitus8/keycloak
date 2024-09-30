package org.example.demokeycloakbe.config;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;


public class CustomJwtGrantedAuthorities implements Converter<Jwt, Collection<GrantedAuthority>> {

    String nameOfClient;

    public CustomJwtGrantedAuthorities(String nameOfClient) {
        super();
        this.nameOfClient = nameOfClient;
    }

    @Override
    public <U> Converter<Jwt, U> andThen(Converter<? super Collection<GrantedAuthority>, ? extends U> after) {
        return Converter.super.andThen(after);
    }


    @Override
    public Collection<GrantedAuthority> convert(Jwt value) {
        Collection<GrantedAuthority> finalRoles = new ArrayList<>();
        extractRealmRoles(value.getClaim("realm_access"), finalRoles);
        extractClientRoles(value, finalRoles);

        return finalRoles;
    }

    private void extractRealmRoles(Object mapObject, Collection<GrantedAuthority> finalRoles) {
        if (mapObject instanceof Map) {
            Map<String, List<String>> rolesMap = (Map<String, List<String>>) mapObject;
            rolesMap.computeIfAbsent("roles", key -> new ArrayList<>())
                    .forEach(role -> finalRoles.add(new SimpleGrantedAuthority(role)));
        }
    }

    private void extractClientRoles(Jwt jwt, Collection<GrantedAuthority> finalRoles) {
        Map<String, Map<String, List<String>>> resourceAccessMap = jwt.getClaim("resource_access");
        if (resourceAccessMap != null) {
            resourceAccessMap.computeIfAbsent(this.nameOfClient, key -> Collections.emptyMap())
                    .computeIfAbsent("roles", key -> new ArrayList<>())
                    .forEach(role -> finalRoles.add(new SimpleGrantedAuthority(role)));
        }
    }


}
