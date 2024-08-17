package com.aniDB.aniDB_backend.mapper;


import com.aniDB.aniDB_backend.entity.MemberRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface MemberRoleMapper {

    void insertMemberRole(MemberRole memberRole);

    MemberRole selectMemberRoleById(@Param("memberId") Long memberId, @Param("roleId") Long roleId);

    List<MemberRole> selectMemberRoleByMemberId(Long memberId);

    int deleteMemberRole(Long memberId, Long roleId);

    List<MemberRole> selectAllMemberRoles();
}
