package com.maistruk.dao;

import com.maistruk.model.git.GitAnswer;

public interface GitAnswerDao {

    GitAnswer getById(Integer id);

    Integer getRowsAmount();

}
