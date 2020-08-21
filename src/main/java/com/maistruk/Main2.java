package com.maistruk;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.maistruk.config.MyConfig;
import com.maistruk.model.git.GitAnswer;
import com.maistruk.model.git.GitQuestion;
import com.maistruk.model.hibernate.HibernateAnswer;
import com.maistruk.model.hibernate.HibernateQuestion;
import com.maistruk.model.java_core.JavaCoreAnswer;
import com.maistruk.model.java_core.JavaCoreQuestion;
import com.maistruk.model.junit.JunitAnswer;
import com.maistruk.model.junit.JunitQuestion;
import com.maistruk.model.maven.MavenAnswer;
import com.maistruk.model.maven.MavenQuestion;
import com.maistruk.model.servlet.ServletAnswer;
import com.maistruk.model.servlet.ServletQuestion;
import com.maistruk.model.sql.SqlAnswer;
import com.maistruk.model.sql.SqlQuestion;
import com.maistruk.model.web.WebAnswer;
import com.maistruk.model.web.WebQuestion;
import com.maistruk.service.git.GitAnswerService;
import com.maistruk.service.git.GitQuestionService;
import com.maistruk.service.hibernate.HibernateAnswerService;
import com.maistruk.service.hibernate.HibernateQuestionService;
import com.maistruk.service.java_core.JavaCoreAnswerService;
import com.maistruk.service.java_core.JavaCoreQuestionService;
import com.maistruk.service.junit.JunitAnswerService;
import com.maistruk.service.junit.JunitQuestionService;
import com.maistruk.service.maven.MavenAnswerService;
import com.maistruk.service.maven.MavenQuestionService;
import com.maistruk.service.servlet.ServletAnswerService;
import com.maistruk.service.servlet.ServletQuestionService;
import com.maistruk.service.sql.SqlAnswerService;
import com.maistruk.service.sql.SqlQuestionService;
import com.maistruk.service.web.WebAnswerService;
import com.maistruk.service.web.WebQuestionService;

public class Main2 {

    public static void main(String[] args) {
     //   javaCoreQuetionAnswerExample();
        
     //   gitQuetionAnswerExample();
        
     //   hibernateQuetionAnswerExample();
        
     //   junitQuetionAnswerExample();
        
      //  mavenQuetionAnswerExample();
        
      //  servletQuetionAnswerExample();
        
      //  sqlQuetionAnswerExample();
        
        webQuetionAnswerExample();
    }
    
    public static void javaCoreQuetionAnswerExample() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        JavaCoreQuestionService javaCoreQuestionService = (JavaCoreQuestionService) context.getBean(JavaCoreQuestionService.class);
        JavaCoreQuestion javaCoreQuestion = javaCoreQuestionService.getById(3);
        System.out.println("Java Core question getById(3): " + javaCoreQuestion);
        System.out.println("Java Core get rows: " + javaCoreQuestionService.getRowsAmount());
        
        JavaCoreAnswerService javaCoreAnswerService = (JavaCoreAnswerService) context.getBean(JavaCoreAnswerService.class);
        JavaCoreAnswer javaCoreAnswer = javaCoreAnswerService.getById(3);
        System.out.println("Java Core answer getById(3): " + javaCoreAnswer);
        System.out.println("Java Core get rows: " + javaCoreAnswerService.getRowsAmount());
    }
    
    public static void gitQuetionAnswerExample() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        GitQuestionService questionService = (GitQuestionService) context.getBean(GitQuestionService.class);
        GitQuestion question = questionService.getById(3);
        System.out.println("Git question getById(3): " + question);
        System.out.println("Git get rows: " + questionService.getRowsAmount());
        
        GitAnswerService answerService = (GitAnswerService) context.getBean(GitAnswerService.class);
        GitAnswer answer = answerService.getById(3);
        System.out.println("Git answer getById(3): " + answer);
        System.out.println("Git get rows: " + answerService.getRowsAmount());
    }
    
    public static void hibernateQuetionAnswerExample() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        HibernateQuestionService questionService = (HibernateQuestionService) context.getBean(HibernateQuestionService.class);
        HibernateQuestion question = questionService.getById(3);
        System.out.println("Hibernate question getById(3): " + question);
        System.out.println("Hibernate get rows: " + questionService.getRowsAmount());
        
        HibernateAnswerService answerService = (HibernateAnswerService) context.getBean(HibernateAnswerService.class);
        HibernateAnswer answer = answerService.getById(3);
        System.out.println("Hibernate answer getById(3): " + answer);
        System.out.println("Hibernate get rows: " + answerService.getRowsAmount());
    }
    
    public static void junitQuetionAnswerExample() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        JunitQuestionService questionService = (JunitQuestionService) context.getBean(JunitQuestionService.class);
        JunitQuestion question = questionService.getById(3);
        System.out.println("Junit question getById(3): " + question);
        System.out.println("Junit get rows: " + questionService.getRowsAmount());
        
        JunitAnswerService answerService = (JunitAnswerService) context.getBean(JunitAnswerService.class);
        JunitAnswer answer = answerService.getById(3);
        System.out.println("Junit answer getById(3): " + answer);
        System.out.println("Junit get rows: " + answerService.getRowsAmount());
    }
    
    public static void mavenQuetionAnswerExample() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        MavenQuestionService questionService = (MavenQuestionService) context.getBean(MavenQuestionService.class);
        MavenQuestion question = questionService.getById(3);
        System.out.println("Maven question getById(3): " + question);
        System.out.println("Maven get rows: " + questionService.getRowsAmount());
        
        MavenAnswerService answerService = (MavenAnswerService) context.getBean(MavenAnswerService.class);
        MavenAnswer answer = answerService.getById(3);
        System.out.println("Maven answer getById(3): " + answer);
        System.out.println("Maven get rows: " + answerService.getRowsAmount());
    }
    
    public static void servletQuetionAnswerExample() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        ServletQuestionService questionService = (ServletQuestionService) context.getBean(ServletQuestionService.class);
        ServletQuestion question = questionService.getById(3);
        System.out.println("Servlet question getById(3): " + question);
        System.out.println("Servlet get rows: " + questionService.getRowsAmount());
        
        ServletAnswerService answerService = (ServletAnswerService) context.getBean(ServletAnswerService.class);
        ServletAnswer answer = answerService.getById(3);
        System.out.println("Servlet answer getById(3): " + answer);
        System.out.println("Servlet get rows: " + answerService.getRowsAmount());
    }
    
    public static void sqlQuetionAnswerExample() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        SqlQuestionService questionService = (SqlQuestionService) context.getBean(SqlQuestionService.class);
        SqlQuestion question = questionService.getById(3);
        System.out.println("Servlet question getById(3): " + question);
        System.out.println("Servlet get rows: " + questionService.getRowsAmount());
        
        SqlAnswerService answerService = (SqlAnswerService) context.getBean(SqlAnswerService.class);
        SqlAnswer answer = answerService.getById(3);
        System.out.println("Servlet answer getById(3): " + answer);
        System.out.println("Servlet get rows: " + answerService.getRowsAmount());
    }
    
    public static void webQuetionAnswerExample() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        WebQuestionService questionService = (WebQuestionService) context.getBean(WebQuestionService.class);
        WebQuestion question = questionService.getById(3);
        System.out.println("Servlet question getById(3): " + question);
        System.out.println("Servlet get rows: " + questionService.getRowsAmount());
        
        WebAnswerService answerService = (WebAnswerService) context.getBean(WebAnswerService.class);
        WebAnswer answer = answerService.getById(3);
        System.out.println("Servlet answer getById(3): " + answer);
        System.out.println("Servlet get rows: " + answerService.getRowsAmount());
    }


}
