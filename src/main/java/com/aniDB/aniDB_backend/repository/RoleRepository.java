package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.Role;
import com.aniDB.aniDB_backend.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RoleRepository {

    private final RoleMapper roleMapper;

    void save(Role role) {
        roleMapper.insertRole(role);
    }

    Role findById(Long roleId) {
       return roleMapper.selectRoleById(roleId);
    }

    Role findByName(String roleName) {
        Role role = roleMapper.selectRoleByRoleName(roleName);
        return role;
    }

    void update(Role role) {
        return;
    }

    int deleteById(Long roleId){
        int deleteCount = roleMapper.deleteRole(roleId);
        return deleteCount;
    }

    List<Role> findAll() {
        List<Role> roles = roleMapper.selectAllRoles();
        return roles;
    }
}