package com.maistruk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maistruk.model.sql.SqlAnswerFlags;
import com.maistruk.model.sql.SqlQuestionAnswer;
import com.maistruk.service.sql.SqlManager;

@Controller
public class SqlController {
    
    @Autowired
    private SqlManager manager;
    
    @RequestMapping(value = "/sqlStart", method = RequestMethod.POST)
    public ModelAndView startQuiz(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sql/question.jsp");
        SqlQuestionAnswer questionAnswer = manager.genereteQuestion();
        SqlAnswerFlags  answerFlags = new SqlAnswerFlags();
        answerFlags.setFlags(questionAnswer);
        
        List<SqlQuestionAnswer> questionAnswerList = new ArrayList<>();
        questionAnswerList.add(questionAnswer);
        List<SqlAnswerFlags> answerFlagsList = new ArrayList<>();
        answerFlagsList.add(answerFlags);
        
        session.setAttribute("sqlQuestionAnswerList", questionAnswerList);
        session.setAttribute("sqlAnswerFlagsList", answerFlagsList);

        return modelAndView;
    }
    
    @RequestMapping(value = "/sqlNextQuestion", method = RequestMethod.POST)
    public ModelAndView nextQuestion(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<SqlAnswerFlags> answerFlagsList = (ArrayList<SqlAnswerFlags>) session.getAttribute("sqlAnswerFlagsList");
        SqlAnswerFlags answerFlags = answerFlagsList.get(answerFlagsList.size() - 1);
        if(request.getParameter("answer1") != null) {
            answerFlags.setMyAnswerFlag1(true);
        } else {
            answerFlags.setMyAnswerFlag1(false);
        }
        
        if(request.getParameter("answer2") != null) {
            answerFlags.setMyAnswerFlag2(true);
        } else {
            answerFlags.setMyAnswerFlag2(false);
        }
        
        if(request.getParameter("answer3") != null) {
            answerFlags.setMyAnswerFlag3(true);
        } else {
            answerFlags.setMyAnswerFlag3(false);
        }
        
        if(request.getParameter("answer4") != null) {
            answerFlags.setMyAnswerFlag4(true);
        } else {
            answerFlags.setMyAnswerFlag4(false);
        }
        System.out.println(answerFlagsList);
        List<SqlQuestionAnswer> questionAnswerList = (ArrayList<SqlQuestionAnswer>) session.getAttribute("sqlQuestionAnswerList");
        if(questionAnswerList.size() < 15) {
            SqlQuestionAnswer questionAnswer = manager.genereteUniqueQuestion(questionAnswerList);
            answerFlags = new SqlAnswerFlags();
            answerFlags.setFlags(questionAnswer);
            questionAnswerList.add(questionAnswer);
            answerFlagsList.add(answerFlags);
//            session.setAttribute("springQuestionAnswerList", springQuestionAnswerList);
//            session.setAttribute("springAnswerFlagsList", springAnswerFlagsList);
            modelAndView.setViewName("sql/question.jsp");
        } else {
            modelAndView.setViewName("sql/result.jsp");
        }
        return modelAndView;
    }
}
