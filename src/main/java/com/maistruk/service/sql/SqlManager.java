package com.maistruk.service.sql;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.model.sql.SqlAnswer;
import com.maistruk.model.sql.SqlQuestion;
import com.maistruk.model.sql.SqlQuestionAnswer;

@Service
public class SqlManager {

    @Autowired
    private SqlAnswerService answerService;
    
    @Autowired
    private SqlQuestionService questionService;
    
    public SqlQuestionAnswer genereteQuestion() {
        int questionAmout = questionService.getRowsAmount();
        Random random = new Random();
        int randomQuestionId = random.nextInt(questionAmout) + 1;
        SqlQuestion question = questionService.getById(randomQuestionId);
        int answerId = (4 * (randomQuestionId - 1) + 1);
        SqlAnswer answer1 = answerService.getById(answerId);
        SqlAnswer answer2 = answerService.getById(++answerId);
        SqlAnswer answer3 = answerService.getById(++answerId);
        SqlAnswer answer4 = answerService.getById(++answerId);
        
        SqlQuestionAnswer questionAnswer = new SqlQuestionAnswer();
        questionAnswer.setQuestion(question);
        questionAnswer.setAnswer1(answer1);
        questionAnswer.setAnswer2(answer2);
        questionAnswer.setAnswer3(answer3);
        questionAnswer.setAnswer4(answer4);
        return questionAnswer;
    }
    
    public SqlQuestionAnswer genereteUniqueQuestion(List<SqlQuestionAnswer> answerQuestionList) {
        SqlQuestionAnswer questionAnswer = genereteQuestion();
        Boolean check = true;
        
        while(ifConsistQuestionAnswer(questionAnswer, answerQuestionList)) {
            questionAnswer = genereteQuestion();
        }

        return questionAnswer;
    }
    
    private boolean ifConsistQuestionAnswer(SqlQuestionAnswer questionAnswer, List<SqlQuestionAnswer> answerQuestionList) {
        for(SqlQuestionAnswer questionAnswer2 : answerQuestionList) {
            if(questionAnswer2.getQuestion().getId().equals(questionAnswer.getQuestion().getId())) {
                return true;
            }
        }
        return false;
    }
}
