package com.example.democustomrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;

@Component
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final EntityManager em;

    @Autowired
    public UserCustomRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<String> getNameByID(Long id) {
        final Query nativeQuery = em.createNativeQuery("SELECT  name from USER where id = ?");
        nativeQuery.setParameter(1, id);
        String res = (String) nativeQuery.getSingleResult();

        return Optional.ofNullable(res);
    }
}

