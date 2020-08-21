package com.maistruk.service.git;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.GitAnswerDao;
import com.maistruk.dao.GitQuestionDao;
import com.maistruk.model.git.GitAnswer;
import com.maistruk.model.git.GitQuestion;
@Service
public class GitQuestionService {
    
    @Autowired
    private GitQuestionDao gitQuestionDao;
    
    public GitQuestion getById(Integer id) {
        return gitQuestionDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return gitQuestionDao.getRowsAmount();
    }


}
