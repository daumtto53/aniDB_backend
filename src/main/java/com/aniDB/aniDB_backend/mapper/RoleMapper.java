package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {

    void insertRole(Role role);

    Role selectRoleById(Long roleId);

    Role selectRoleByRoleName(String roleName);

    void updateRole(Role role);

    int deleteRole(Long roleId);

    List<Role> selectAllRoles();
}
