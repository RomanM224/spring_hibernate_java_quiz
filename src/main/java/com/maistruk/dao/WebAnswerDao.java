package com.maistruk.dao;

import com.maistruk.model.web.WebAnswer;

public interface WebAnswerDao {

    WebAnswer getById(Integer id);

    Integer getRowsAmount();
}
