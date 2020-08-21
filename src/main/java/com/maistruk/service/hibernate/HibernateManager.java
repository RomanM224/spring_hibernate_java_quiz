package com.maistruk.service.hibernate;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.model.hibernate.HibernateAnswer;
import com.maistruk.model.hibernate.HibernateQuestion;
import com.maistruk.model.hibernate.HibernateQuestionAnswer;

@Service
public class HibernateManager {
    
    @Autowired
    private HibernateQuestionService questionService;
    
    @Autowired
    private HibernateAnswerService answerService;
    
    public HibernateQuestionAnswer genereteQuestion() {
        int questionAmout = questionService.getRowsAmount();
        Random random = new Random();
        int randomQuestionId = random.nextInt(questionAmout) + 1;
        HibernateQuestion question = questionService.getById(randomQuestionId);
        int answerId = (4 * (randomQuestionId - 1) + 1);
        HibernateAnswer answer1 = answerService.getById(answerId);
        HibernateAnswer answer2 = answerService.getById(++answerId);
        HibernateAnswer answer3 = answerService.getById(++answerId);
        HibernateAnswer answer4 = answerService.getById(++answerId);
        
        HibernateQuestionAnswer questionAnswer = new HibernateQuestionAnswer();
        questionAnswer.setQuestion(question);
        questionAnswer.setAnswer1(answer1);
        questionAnswer.setAnswer2(answer2);
        questionAnswer.setAnswer3(answer3);
        questionAnswer.setAnswer4(answer4);
        return questionAnswer;
    }
    
    public HibernateQuestionAnswer genereteUniqueQuestion(List<HibernateQuestionAnswer> answerQuestionList) {
        HibernateQuestionAnswer questionAnswer = genereteQuestion();
        Boolean check = true;
        
        while(ifConsistQuestionAnswer(questionAnswer, answerQuestionList)) {
            questionAnswer = genereteQuestion();
        }

        return questionAnswer;
    }
    
    private boolean ifConsistQuestionAnswer(HibernateQuestionAnswer questionAnswer, List<HibernateQuestionAnswer> answerQuestionList) {
        for(HibernateQuestionAnswer questionAnswer2 : answerQuestionList) {
            if(questionAnswer2.getQuestion().getId().equals(questionAnswer.getQuestion().getId())) {
                return true;
            }
        }
        return false;
    }

}
