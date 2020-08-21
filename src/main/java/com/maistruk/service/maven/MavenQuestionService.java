package com.maistruk.service.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.MavenQuestionDao;
import com.maistruk.model.maven.MavenQuestion;

@Service
public class MavenQuestionService {
    
    @Autowired
    private MavenQuestionDao questionDao;
    
    public MavenQuestion getById(Integer id) {
        return questionDao.getById(id);
    }

    public Integer getRowsAmount() {
        return questionDao.getRowsAmount();
    }

}
