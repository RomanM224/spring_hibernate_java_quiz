package com.maistruk.dao;

import com.maistruk.model.maven.MavenAnswer;

public interface MavenAnswerDao {
    
    MavenAnswer getById(Integer id);

    Integer getRowsAmount();

}
