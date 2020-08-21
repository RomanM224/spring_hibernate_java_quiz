package com.maistruk.dao;

import com.maistruk.model.servlet.ServletAnswer;

public interface ServletAnswerDao {
    
    ServletAnswer getById(Integer id);
    
    Integer getRowsAmount();

}
