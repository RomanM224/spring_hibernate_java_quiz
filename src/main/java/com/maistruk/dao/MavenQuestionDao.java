package com.maistruk.dao;

import com.maistruk.model.maven.MavenQuestion;

public interface MavenQuestionDao {
    
    MavenQuestion getById(Integer id);

    Integer getRowsAmount();

}
