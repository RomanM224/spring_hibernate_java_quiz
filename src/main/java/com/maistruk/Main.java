package com.maistruk;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.maistruk.config.MyConfig;
import com.maistruk.dao.SpringQuestionDao;
import com.maistruk.model.spring.SpringAnswer;
import com.maistruk.model.spring.SpringQuestion;
import com.maistruk.model.spring.SpringQuestionAnswer;
import com.maistruk.service.spring.SpringAnswerService;
import com.maistruk.service.spring.SpringManager;
import com.maistruk.service.spring.SpringQuestionService;

public class Main {

    public static void main(String[] args) {

      //  saveSpringQuestion();
        
     //   getByIdSpringQustion();
        
        getByIdSpringAnswer();
//        
//        springAnswerRows();
//        
//        springQuestionRows();
//        
//        getSpringQuestionAnswer();

    }

    public static void saveSpringQuestion() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        SpringQuestionDao springQuestionDao = (SpringQuestionDao) context.getBean(SpringQuestionDao.class);
        SpringQuestion springQuestion = new SpringQuestion();
        springQuestion.setQuestion("Spring Question");

        springQuestionDao.create(springQuestion);
    }

    public static void getByIdSpringQustion() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        SpringQuestionDao springQuestionDao = (SpringQuestionDao) context.getBean(SpringQuestionDao.class);
        SpringQuestionService springQuestionService = (SpringQuestionService) context.getBean(SpringQuestionService.class);
        SpringQuestion springQuestion = springQuestionService.getById(3);
        System.out.println("Spring question getById(2): " + springQuestion);
    }
    
    public static void getByIdSpringAnswer() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        SpringAnswerService springAnswerService = (SpringAnswerService) context.getBean(SpringAnswerService.class);
        SpringAnswer springQuestion = springAnswerService.getById(1);
        System.out.println("Spring answer getById(2): " + springQuestion);
    }
    
    public static void springAnswerRows() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        SpringAnswerService springAnswerService = (SpringAnswerService) context.getBean(SpringAnswerService.class);
        Integer num = springAnswerService.getRowsAmount();
        System.out.println("Spring answer getRowsAmount(): " + num);
    }
    
    public static void springQuestionRows() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        SpringQuestionService springQuestionDao = (SpringQuestionService) context.getBean(SpringQuestionService.class);
        Integer num = springQuestionDao.getRowsAmount();
        System.out.println("Spring answer getRowsAmount(): " + num);
    }
    
    public static void getSpringQuestionAnswer() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        SpringManager springManager = (SpringManager) context.getBean(SpringManager.class);
        
        SpringQuestionAnswer springQuestionAnswer = springManager.genereteQuestion();
        System.out.println("Spring Manager getSpringQuestionAnswer() \n" + springQuestionAnswer);
    }

}
