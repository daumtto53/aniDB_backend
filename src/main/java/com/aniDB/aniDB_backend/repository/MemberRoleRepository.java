package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.MemberRole;
import com.aniDB.aniDB_backend.mapper.MemberRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRoleRepository {

    private final MemberRoleMapper memberRoleMapper;

    /**
     * Inserts a new member role into the database.
     * @param memberRole The MemberRole entity to be inserted.
     */
    @Transactional
    public void saveMemberRole(MemberRole memberRole) {
        memberRoleMapper.insertMemberRole(memberRole);
    }

    /**
     * Selects a member role by memberId and roleId.
     * @param memberId The ID of the member.
     * @param roleId The ID of the role.
     * @return The MemberRole entity if found, otherwise null.
     */
    @Transactional
    public MemberRole findMemberRoleById(Long memberId, Long roleId) {
        return memberRoleMapper.selectMemberRoleById(memberId, roleId);
    }

    /**
     * Selects all roles for a given member.
     * @param memberId The ID of the member.
     * @return A list of MemberRole entities.
     */
    @Transactional
    public List<MemberRole> findMemberRolesByMemberId(Long memberId) {
        return memberRoleMapper.selectMemberRoleByMemberId(memberId);
    }

    /**
     * Deletes a member role by memberId and roleId.
     * @param memberId The ID of the member.
     * @param roleId The ID of the role.
     * @return The number of rows affected.
     */
    @Transactional
    public int removeMemberRole(Long memberId, Long roleId) {
        return memberRoleMapper.deleteMemberRole(memberId, roleId);
    }

    /**
     * Selects all member roles in the database.
     * @return A list of all MemberRole entities.
     */
    @Transactional
    public List<MemberRole> findAllMemberRoles() {
        return memberRoleMapper.selectAllMemberRoles();
    }
}