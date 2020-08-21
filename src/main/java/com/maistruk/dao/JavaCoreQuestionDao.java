package com.maistruk.dao;

import com.maistruk.model.java_core.JavaCoreQuestion;

public interface JavaCoreQuestionDao {

    JavaCoreQuestion getById(Integer id);

    Integer getRowsAmount();

}
