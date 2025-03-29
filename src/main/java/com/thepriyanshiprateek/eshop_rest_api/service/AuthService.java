package com.thepriyanshiprateek.eshop_rest_api.service;

import com.thepriyanshiprateek.eshop_rest_api.entity.Role;
import com.thepriyanshiprateek.eshop_rest_api.payload.LoginDto;
import com.thepriyanshiprateek.eshop_rest_api.payload.RegisterDto;

import java.util.List;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
    String createRole(String name);
    String deleteRole(String name);
    List<Role> getAllRoles();
    String getRoleByName(String name);
}
