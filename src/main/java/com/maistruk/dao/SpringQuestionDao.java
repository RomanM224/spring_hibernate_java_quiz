package com.maistruk.dao;

import com.maistruk.model.spring.SpringQuestion;

public interface SpringQuestionDao {
    
    void create(SpringQuestion springQuestion);
    
    SpringQuestion getById(Integer id);
    
    Integer getRowsAmount();
    

}
