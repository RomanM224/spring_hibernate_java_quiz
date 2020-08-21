package com.maistruk.service.servlet;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.model.servlet.ServletAnswer;
import com.maistruk.model.servlet.ServletQuestion;
import com.maistruk.model.servlet.ServletQuestionAnswer;

@Service
public class ServletManager {
    
    @Autowired
    private ServletAnswerService answerService;
    
    @Autowired
    private ServletQuestionService questionService;
    
    public ServletQuestionAnswer genereteQuestion() {
        int questionAmout = questionService.getRowsAmount();
        Random random = new Random();
        int randomQuestionId = random.nextInt(questionAmout) + 1;
        ServletQuestion question = questionService.getById(randomQuestionId);
        int answerId = (4 * (randomQuestionId - 1) + 1);
        ServletAnswer answer1 = answerService.getById(answerId);
        ServletAnswer answer2 = answerService.getById(++answerId);
        ServletAnswer answer3 = answerService.getById(++answerId);
        ServletAnswer answer4 = answerService.getById(++answerId);
        
        ServletQuestionAnswer questionAnswer = new ServletQuestionAnswer();
        questionAnswer.setQuestion(question);
        questionAnswer.setAnswer1(answer1);
        questionAnswer.setAnswer2(answer2);
        questionAnswer.setAnswer3(answer3);
        questionAnswer.setAnswer4(answer4);
        return questionAnswer;
    }
    
    public ServletQuestionAnswer genereteUniqueQuestion(List<ServletQuestionAnswer> answerQuestionList) {
        ServletQuestionAnswer questionAnswer = genereteQuestion();
        Boolean check = true;
        
        while(ifConsistQuestionAnswer(questionAnswer, answerQuestionList)) {
            questionAnswer = genereteQuestion();
        }

        return questionAnswer;
    }
    
    private boolean ifConsistQuestionAnswer(ServletQuestionAnswer questionAnswer, List<ServletQuestionAnswer> answerQuestionList) {
        for(ServletQuestionAnswer questionAnswer2 : answerQuestionList) {
            if(questionAnswer2.getQuestion().getId().equals(questionAnswer.getQuestion().getId())) {
                return true;
            }
        }
        return false;
    }

}
