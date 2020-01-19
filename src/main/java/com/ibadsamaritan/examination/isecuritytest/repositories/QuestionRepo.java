package com.ibadsamaritan.examination.isecuritytest.repositories;

import com.ibadsamaritan.examination.isecuritytest.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long> {

}
