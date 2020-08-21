package com.maistruk.dao;

import com.maistruk.model.web.WebQuestion;

public interface WebQuestionDao {

    WebQuestion getById(Integer id);

    Integer getRowsAmount();
}
