package com.maistruk.service.git;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.model.git.GitAnswer;
import com.maistruk.model.git.GitQuestion;
import com.maistruk.model.git.GitQuestionAnswer;

@Service
public class GitManager {
    
    @Autowired
    private GitAnswerService answerService;
    
    @Autowired
    private GitQuestionService questionService;
    
    public GitQuestionAnswer genereteQuestion() {
        int questionAmout = questionService.getRowsAmount();
        Random random = new Random();
        int randomQuestionId = random.nextInt(questionAmout) + 1;
        GitQuestion javaCoreQuestion = questionService.getById(randomQuestionId);
        int answerId = (4 * (randomQuestionId - 1) + 1);
        GitAnswer answer1 = answerService.getById(answerId);
        GitAnswer answer2 = answerService.getById(++answerId);
        GitAnswer answer3 = answerService.getById(++answerId);
        GitAnswer answer4 = answerService.getById(++answerId);
        
        GitQuestionAnswer questionAnswer = new GitQuestionAnswer();
        questionAnswer.setQuestion(javaCoreQuestion);
        questionAnswer.setAnswer1(answer1);
        questionAnswer.setAnswer2(answer2);
        questionAnswer.setAnswer3(answer3);
        questionAnswer.setAnswer4(answer4);
        return questionAnswer;
    }
    
    public GitQuestionAnswer genereteUniqueQuestion(List<GitQuestionAnswer> answerQuestionList) {
        GitQuestionAnswer questionAnswer = genereteQuestion();
        Boolean check = true;
        
        while(ifConsistQuestionAnswer(questionAnswer, answerQuestionList)) {
            questionAnswer = genereteQuestion();
        }

        return questionAnswer;
    }
    
    private boolean ifConsistQuestionAnswer(GitQuestionAnswer questionAnswer, List<GitQuestionAnswer> answerQuestionList) {
        for(GitQuestionAnswer questionAnswer2 : answerQuestionList) {
            if(questionAnswer2.getQuestion().getId().equals(questionAnswer.getQuestion().getId())) {
                return true;
            }
        }
        return false;
    }

}
