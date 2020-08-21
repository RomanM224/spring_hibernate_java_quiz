package com.maistruk.model.servlet;

public class ServletQuestionAnswer {
    
    private ServletQuestion question;
    private ServletAnswer answer1;
    private ServletAnswer answer2;
    private ServletAnswer answer3;
    private ServletAnswer answer4;
    public ServletQuestion getQuestion() {
        return question;
    }
    public void setQuestion(ServletQuestion question) {
        this.question = question;
    }
    public ServletAnswer getAnswer1() {
        return answer1;
    }
    public void setAnswer1(ServletAnswer answer1) {
        this.answer1 = answer1;
    }
    public ServletAnswer getAnswer2() {
        return answer2;
    }
    public void setAnswer2(ServletAnswer answer2) {
        this.answer2 = answer2;
    }
    public ServletAnswer getAnswer3() {
        return answer3;
    }
    public void setAnswer3(ServletAnswer answer3) {
        this.answer3 = answer3;
    }
    public ServletAnswer getAnswer4() {
        return answer4;
    }
    public void setAnswer4(ServletAnswer answer4) {
        this.answer4 = answer4;
    }
    
    @Override
    public String toString() {
        return "ServletQuestionAnswer [question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
                + ", answer3=" + answer3 + ", answer4=" + answer4 + "]";
    }
    
    

}
