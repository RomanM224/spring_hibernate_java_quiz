package com.maistruk.service.junit;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.dao.JunitAnswerDao;
import com.maistruk.model.junit.JunitAnswer;

@Service
public class JunitAnswerService {

    @Autowired
    private JunitAnswerDao answerDao;

    public JunitAnswer getById(Integer id) {
        return answerDao.getById(id);
    }

    public Integer getRowsAmount() {
        return answerDao.getRowsAmount();
    }

}
