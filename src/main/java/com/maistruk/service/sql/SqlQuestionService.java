package com.maistruk.service.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.SqlQuestionDao;
import com.maistruk.model.sql.SqlQuestion;


@Service
public class SqlQuestionService {
    
    @Autowired
    private SqlQuestionDao questionDao;
    
    public SqlQuestion getById(Integer id) {
        return questionDao.getById(id);
    }

    public Integer getRowsAmount() {
        return questionDao.getRowsAmount();
    }

}
