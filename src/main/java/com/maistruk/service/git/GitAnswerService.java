package com.maistruk.service.git;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.GitAnswerDao;
import com.maistruk.model.git.GitAnswer;

@Service
public class GitAnswerService {
    
    @Autowired
    private GitAnswerDao gitAnswerDao;
    
    public GitAnswer getById(Integer id) {
        return gitAnswerDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return gitAnswerDao.getRowsAmount();
    }

}
