package com.maistruk.dao;

import com.maistruk.model.junit.JunitQuestion;

public interface JunitQuestionDao {
    
    JunitQuestion getById(Integer id);

    Integer getRowsAmount();
}
