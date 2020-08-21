package com.maistruk.dao;

import com.maistruk.model.java_core.JavaCoreAnswer;

public interface JavaCoreAnswerDao {

    JavaCoreAnswer getById(Integer id);

    Integer getRowsAmount();

}
