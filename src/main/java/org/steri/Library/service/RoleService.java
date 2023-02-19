package org.steri.Library.service;

import org.steri.Library.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();

    Set<Role> getRolesByIdArr(Long[] idList);

    void save(Role userRole);
}