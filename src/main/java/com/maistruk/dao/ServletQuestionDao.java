package com.maistruk.dao;

import com.maistruk.model.servlet.ServletQuestion;

public interface ServletQuestionDao {

    ServletQuestion getById(Integer id);
    
    Integer getRowsAmount();
}
