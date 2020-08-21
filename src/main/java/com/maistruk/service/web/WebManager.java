package com.maistruk.service.web;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.model.web.WebAnswer;
import com.maistruk.model.web.WebQuestion;
import com.maistruk.model.web.WebQuestionAnswer;


@Service
public class WebManager {

    @Autowired
    private WebAnswerService answerService;
    
    @Autowired
    private WebQuestionService questionService;
    
    public WebQuestionAnswer genereteQuestion() {
        int questionAmout = questionService.getRowsAmount();
        Random random = new Random();
        int randomQuestionId = random.nextInt(questionAmout) + 1;
        WebQuestion question = questionService.getById(randomQuestionId);
        int answerId = (4 * (randomQuestionId - 1) + 1);
        WebAnswer answer1 = answerService.getById(answerId);
        WebAnswer answer2 = answerService.getById(++answerId);
        WebAnswer answer3 = answerService.getById(++answerId);
        WebAnswer answer4 = answerService.getById(++answerId);
        
        WebQuestionAnswer questionAnswer = new WebQuestionAnswer();
        questionAnswer.setQuestion(question);
        questionAnswer.setAnswer1(answer1);
        questionAnswer.setAnswer2(answer2);
        questionAnswer.setAnswer3(answer3);
        questionAnswer.setAnswer4(answer4);
        return questionAnswer;
    }
    
    public WebQuestionAnswer genereteUniqueQuestion(List<WebQuestionAnswer> answerQuestionList) {
        WebQuestionAnswer questionAnswer = genereteQuestion();
        Boolean check = true;
        
        while(ifConsistQuestionAnswer(questionAnswer, answerQuestionList)) {
            questionAnswer = genereteQuestion();
        }

        return questionAnswer;
    }
    
    private boolean ifConsistQuestionAnswer(WebQuestionAnswer questionAnswer, List<WebQuestionAnswer> answerQuestionList) {
        for(WebQuestionAnswer questionAnswer2 : answerQuestionList) {
            if(questionAnswer2.getQuestion().getId().equals(questionAnswer.getQuestion().getId())) {
                return true;
            }
        }
        return false;
    }
}
