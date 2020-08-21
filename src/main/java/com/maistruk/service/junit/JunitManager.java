package com.maistruk.service.junit;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.model.junit.JunitAnswer;
import com.maistruk.model.junit.JunitQuestion;
import com.maistruk.model.junit.JunitQuestionAnswer;

@Service
public class JunitManager {
    
    @Autowired
    private JunitQuestionService questionService;
    
    @Autowired
    private JunitAnswerService answerService;
    
    public JunitQuestionAnswer genereteQuestion() {
        int questionAmout = questionService.getRowsAmount();
        Random random = new Random();
        int randomQuestionId = random.nextInt(questionAmout) + 1;
        JunitQuestion question = questionService.getById(randomQuestionId);
        int answerId = (4 * (randomQuestionId - 1) + 1);
        JunitAnswer answer1 = answerService.getById(answerId);
        JunitAnswer answer2 = answerService.getById(++answerId);
        JunitAnswer answer3 = answerService.getById(++answerId);
        JunitAnswer answer4 = answerService.getById(++answerId);
        
        JunitQuestionAnswer questionAnswer = new JunitQuestionAnswer();
        questionAnswer.setQuestion(question);
        questionAnswer.setAnswer1(answer1);
        questionAnswer.setAnswer2(answer2);
        questionAnswer.setAnswer3(answer3);
        questionAnswer.setAnswer4(answer4);
        return questionAnswer;
    }
    
    public JunitQuestionAnswer genereteUniqueQuestion(List<JunitQuestionAnswer> answerQuestionList) {
        JunitQuestionAnswer questionAnswer = genereteQuestion();
        Boolean check = true;
        
        while(ifConsistQuestionAnswer(questionAnswer, answerQuestionList)) {
            questionAnswer = genereteQuestion();
        }
        return questionAnswer;
    }
    
    private boolean ifConsistQuestionAnswer(JunitQuestionAnswer questionAnswer, List<JunitQuestionAnswer> answerQuestionList) {
        for(JunitQuestionAnswer questionAnswer2 : answerQuestionList) {
            if(questionAnswer2.getQuestion().getId().equals(questionAnswer.getQuestion().getId())) {
                return true;
            }
        }
        return false;
    }

}
