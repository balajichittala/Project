package com.charge.ev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charge.ev.entries.Entries;

@Repository
public interface EvDao extends CrudRepository<Entries, Long> {
    Entries findByEmailAndPassword(String email, String password);
    
    @Query(value = "select e.email from entries e where e.email=?1",nativeQuery = true)
    String existsByEmail(String Email);
    
    public Entries findByUserId(String userId);
    
}
