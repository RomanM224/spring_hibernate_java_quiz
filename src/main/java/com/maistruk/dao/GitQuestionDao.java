package com.maistruk.dao;

import com.maistruk.model.git.GitQuestion;

public interface GitQuestionDao {

    GitQuestion getById(Integer id);

    Integer getRowsAmount();

}
