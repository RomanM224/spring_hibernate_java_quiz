package com.maistruk.dao;

import com.maistruk.model.junit.JunitAnswer;

public interface JunitAnswerDao {
    
    JunitAnswer getById(Integer id);

    Integer getRowsAmount();

}
