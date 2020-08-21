package com.maistruk.dao;

import com.maistruk.model.sql.SqlAnswer;

public interface SqlAnswerDao {

    SqlAnswer getById(Integer id);

    Integer getRowsAmount();
}
