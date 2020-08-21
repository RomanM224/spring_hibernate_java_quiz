package com.maistruk.service.spring;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistruk.model.spring.SpringAnswer;
import com.maistruk.model.spring.SpringQuestion;
import com.maistruk.model.spring.SpringQuestionAnswer;

@Service
public class SpringManager {
    
    @Autowired
    private SpringQuestionService springQuestionService;

    @Autowired
    private SpringAnswerService springAnswerService;
    
    public SpringQuestionAnswer genereteQuestion() {
        int questionAmout = springQuestionService.getRowsAmount();
        Random random = new Random();
        int randomQuestionId = random.nextInt(questionAmout) + 1;
        SpringQuestion springQuestion = springQuestionService.getById(randomQuestionId);
        int answerId = (4 * (randomQuestionId - 1) + 1);
        SpringAnswer springAnswer1 = springAnswerService.getById(answerId);
        SpringAnswer springAnswer2 = springAnswerService.getById(++answerId);
        SpringAnswer springAnswer3 = springAnswerService.getById(++answerId);
        SpringAnswer springAnswer4 = springAnswerService.getById(++answerId);
        
        SpringQuestionAnswer springQuestionAnswer = new SpringQuestionAnswer();
        springQuestionAnswer.setSpringQuestion(springQuestion);
        springQuestionAnswer.setSpringAnswer1(springAnswer1);
        springQuestionAnswer.setSpringAnswer2(springAnswer2);
        springQuestionAnswer.setSpringAnswer3(springAnswer3);
        springQuestionAnswer.setSpringAnswer4(springAnswer4);
        return springQuestionAnswer;
    }
    
    public SpringQuestionAnswer genereteUniqueQuestion(List<SpringQuestionAnswer> springAnswerQuestionList) {
        SpringQuestionAnswer springQuestionAnswer = genereteQuestion();
        Boolean check = true;
        
        while(ifConsistSpringQuestionAnswer(springQuestionAnswer, springAnswerQuestionList)) {
            springQuestionAnswer = genereteQuestion();
        }

        return springQuestionAnswer;
    }
    
    private boolean ifConsistSpringQuestionAnswer(SpringQuestionAnswer springQuestionAnswer, List<SpringQuestionAnswer> springAnswerQuestionList) {
        for(SpringQuestionAnswer springQuestionAnswer2 : springAnswerQuestionList) {
            if(springQuestionAnswer2.getSpringQuestion().getId().equals(springQuestionAnswer.getSpringQuestion().getId())) {
                return true;
            }
        }
        return false;
    }
    
    

}
