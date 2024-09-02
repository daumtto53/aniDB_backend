package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.Role;
import com.aniDB.aniDB_backend.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RoleRepository {

    private final RoleMapper roleMapper;

    @Transactional
    public void save(Role role) {
        roleMapper.insertRole(role);
    }

    @Transactional
    public Role findById(Long roleId) {
       return roleMapper.selectRoleById(roleId);
    }

    @Transactional
    public Role findByName(String roleName) {
        Role role = roleMapper.selectRoleByRoleName(roleName);
        return role;
    }

    @Transactional
    public List<String> findByMemberId(Long memberId) {
        return roleMapper.selectRoleByMemberId(memberId);
    }

    @Transactional
    public void update(Role role) {
        return;
    }

    @Transactional
    public int deleteById(Long roleId){
        int deleteCount = roleMapper.deleteRole(roleId);
        return deleteCount;
    }

    @Transactional
    public List<Role> findAll() {
        List<Role> roles = roleMapper.selectAllRoles();
        return roles;
    }
}