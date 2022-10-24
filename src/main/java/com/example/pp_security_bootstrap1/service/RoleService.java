package com.example.pp_security_bootstrap1.service;

import com.example.pp_security_bootstrap1.model.Role;

public interface RoleService {
    Role findRoleByName(String name);
}