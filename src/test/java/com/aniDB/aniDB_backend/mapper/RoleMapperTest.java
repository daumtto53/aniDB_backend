package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Role;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test_local")
class RoleMapperTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    void selectRoleById() {
        Role roleUser = roleMapper.selectRoleByRoleName("ROLE_USER");
        Role role = roleMapper.selectRoleById(roleUser.getRoleId());
        org.assertj.core.api.Assertions.assertThat(role.getRoleId()).isEqualTo(roleUser.getRoleId());
    }

    @Test
    void selectAllRoles() {
        List<Role> roles = roleMapper.selectAllRoles();
        org.assertj.core.api.Assertions.assertThat(roles.size()).isEqualTo(3);
    }

    @Test
    void selectRoleByRoleName() {
        Role roleUser = roleMapper.selectRoleByRoleName("ROLE_USER");
        org.assertj.core.api.Assertions.assertThat(roleUser.getRoleName()).isEqualTo("ROLE_USER");
    }

    @Test
    @Order(1)
    void insertRole() {
        Role role = Role.builder()
                .roleName("ROLE_ABC")
                .build();
        roleMapper.insertRole(role);
        org.assertj.core.api.Assertions.assertThat(role.getRoleName()).isEqualTo("ROLE_ABC");

    }

    @Test
    void updateRole() {
    }

    @Test
    @Order(Integer.MAX_VALUE)
    void deleteRole() {
        Role roleTest = Role.builder().roleName("ROLE_TEST").build();
        roleMapper.insertRole(roleTest);
        int cnt = roleMapper.deleteRole(roleTest.getRoleId());
        org.assertj.core.api.Assertions.assertThat(cnt).isEqualTo(1);
    }

}