package com.maistruk.service.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.SqlAnswerDao;
import com.maistruk.model.sql.SqlAnswer;

@Service
public class SqlAnswerService {
    
    @Autowired
    private SqlAnswerDao answerDao;

    public SqlAnswer getById(Integer id) {
        return answerDao.getById(id);
    }
    
    public Integer getRowsAmount() {
        return answerDao.getRowsAmount();
    }
}
