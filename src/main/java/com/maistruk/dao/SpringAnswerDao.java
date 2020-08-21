package com.maistruk.dao;

import com.maistruk.model.spring.SpringAnswer;
import com.maistruk.model.spring.SpringQuestion;

public interface SpringAnswerDao {
    
    void create(SpringAnswer springAnswer);
    
    SpringAnswer getById(Integer id);
    
    Integer getRowsAmount();

}
