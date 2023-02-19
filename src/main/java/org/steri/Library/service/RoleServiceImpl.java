package org.steri.Library.service;

import org.springframework.stereotype.Service;
import org.steri.Library.entity.Role;
import org.steri.Library.repo.RoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    final RoleRepository roleRepository;

    @PersistenceContext
    private EntityManager em;

    public RoleServiceImpl(RoleRepository roleRepository, EntityManager em) {
        this.roleRepository = roleRepository;
        this.em = em;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Set<Role> getRolesByIdArr(Long[] idList) {
        Set<Role> result = new HashSet<>();
        for (Long id : idList) {
            result.add(roleRepository.findById(id).get());
        }
        return result;
    }

    @Override
    public void save(Role role) {
        em.persist(role);
    }
}
