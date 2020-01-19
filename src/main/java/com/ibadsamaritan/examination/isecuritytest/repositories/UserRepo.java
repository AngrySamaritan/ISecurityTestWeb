package com.ibadsamaritan.examination.isecuritytest.repositories;


import com.ibadsamaritan.examination.isecuritytest.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<User, Long> {
    @Query("SELECT u.id FROM User u WHERE u.email = ?1")
    public List<UserRepo> getIdByEmail(String email);

    @Query("SELECT u.id FROM User u WHERE u.username = ?1")
    public List<UserRepo> getIdByUsername(String username);
}
