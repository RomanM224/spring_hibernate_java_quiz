package com.maistruk.service.java_core;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.model.java_core.JavaCoreAnswer;
import com.maistruk.model.java_core.JavaCoreQuestion;
import com.maistruk.model.java_core.JavaCoreQuestionAnswer;
import com.maistruk.model.spring.SpringQuestionAnswer;

@Service
public class JavaCoreManager {
    
    @Autowired
    private JavaCoreQuestionService javaCoreQuestionService;
    
    @Autowired
    private JavaCoreAnswerService javaCoreAnswerService;

    public JavaCoreQuestionAnswer genereteQuestion() {
        int questionAmout = javaCoreQuestionService.getRowsAmount();
        Random random = new Random();
        int randomQuestionId = random.nextInt(questionAmout) + 1;
        JavaCoreQuestion javaCoreQuestion = javaCoreQuestionService.getById(randomQuestionId);
        int answerId = (4 * (randomQuestionId - 1) + 1);
        JavaCoreAnswer javaCoreAnswer1 = javaCoreAnswerService.getById(answerId);
        JavaCoreAnswer javaCoreAnswer2 = javaCoreAnswerService.getById(++answerId);
        JavaCoreAnswer javaCoreAnswer3 = javaCoreAnswerService.getById(++answerId);
        JavaCoreAnswer javaCoreAnswer4 = javaCoreAnswerService.getById(++answerId);
        
        JavaCoreQuestionAnswer javaCoreQuestionAnswer = new JavaCoreQuestionAnswer();
        javaCoreQuestionAnswer.setJavaCoreQuestion(javaCoreQuestion);
        javaCoreQuestionAnswer.setJavaCoreAnswer1(javaCoreAnswer1);
        javaCoreQuestionAnswer.setJavaCoreAnswer2(javaCoreAnswer2);
        javaCoreQuestionAnswer.setJavaCoreAnswer3(javaCoreAnswer3);
        javaCoreQuestionAnswer.setJavaCoreAnswer4(javaCoreAnswer4);
        return javaCoreQuestionAnswer;
    }
    
    public JavaCoreQuestionAnswer genereteUniqueQuestion(List<JavaCoreQuestionAnswer> javaCoreAnswerQuestionList) {
        JavaCoreQuestionAnswer javaCoreQuestionAnswer = genereteQuestion();
        Boolean check = true;
        
        while(ifConsistSpringQuestionAnswer(javaCoreQuestionAnswer, javaCoreAnswerQuestionList)) {
            javaCoreQuestionAnswer = genereteQuestion();
        }

        return javaCoreQuestionAnswer;
    }
    
    private boolean ifConsistSpringQuestionAnswer(JavaCoreQuestionAnswer javaCoreQuestionAnswer, List<JavaCoreQuestionAnswer> javaCoreAnswerQuestionList) {
        for(JavaCoreQuestionAnswer javaCoreQuestionAnswer2 : javaCoreAnswerQuestionList) {
            if(javaCoreQuestionAnswer2.getJavaCoreQuestion().getId().equals(javaCoreQuestionAnswer.getJavaCoreQuestion().getId())) {
                return true;
            }
        }
        return false;
    }

}
