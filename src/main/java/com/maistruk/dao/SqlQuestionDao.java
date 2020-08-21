package com.maistruk.dao;

import com.maistruk.model.sql.SqlQuestion;

public interface SqlQuestionDao {

    SqlQuestion getById(Integer id);

    Integer getRowsAmount();
}
