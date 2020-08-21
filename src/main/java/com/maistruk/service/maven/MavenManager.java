package com.maistruk.service.maven;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.model.maven.MavenAnswer;
import com.maistruk.model.maven.MavenQuestion;
import com.maistruk.model.maven.MavenQuestionAnswer;

@Service
public class MavenManager {
    
    @Autowired
    private MavenAnswerService answerService;
    
    @Autowired
    private MavenQuestionService questionService;
    
    public MavenQuestionAnswer genereteQuestion() {
        int questionAmout = questionService.getRowsAmount();
        Random random = new Random();
        int randomQuestionId = random.nextInt(questionAmout) + 1;
        MavenQuestion question = questionService.getById(randomQuestionId);
        int answerId = (4 * (randomQuestionId - 1) + 1);
        MavenAnswer answer1 = answerService.getById(answerId);
        MavenAnswer answer2 = answerService.getById(++answerId);
        MavenAnswer answer3 = answerService.getById(++answerId);
        MavenAnswer answer4 = answerService.getById(++answerId);
        
        MavenQuestionAnswer questionAnswer = new MavenQuestionAnswer();
        questionAnswer.setQuestion(question);
        questionAnswer.setAnswer1(answer1);
        questionAnswer.setAnswer2(answer2);
        questionAnswer.setAnswer3(answer3);
        questionAnswer.setAnswer4(answer4);
        return questionAnswer;
    }
    
    public MavenQuestionAnswer genereteUniqueQuestion(List<MavenQuestionAnswer> answerQuestionList) {
        MavenQuestionAnswer questionAnswer = genereteQuestion();
        Boolean check = true;
        
        while(ifConsistQuestionAnswer(questionAnswer, answerQuestionList)) {
            questionAnswer = genereteQuestion();
        }

        return questionAnswer;
    }
    
    private boolean ifConsistQuestionAnswer(MavenQuestionAnswer questionAnswer, List<MavenQuestionAnswer> answerQuestionList) {
        for(MavenQuestionAnswer questionAnswer2 : answerQuestionList) {
            if(questionAnswer2.getQuestion().getId().equals(questionAnswer.getQuestion().getId())) {
                return true;
            }
        }
        return false;
    }

}
