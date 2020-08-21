package com.maistruk.model.web;

public class WebQuestionAnswer {

    private WebQuestion question;
    private WebAnswer answer1;
    private WebAnswer answer2;
    private WebAnswer answer3;
    private WebAnswer answer4;

    public WebQuestion getQuestion() {
        return question;
    }

    public void setQuestion(WebQuestion question) {
        this.question = question;
    }

    public WebAnswer getAnswer1() {
        return answer1;
    }

    public void setAnswer1(WebAnswer answer1) {
        this.answer1 = answer1;
    }

    public WebAnswer getAnswer2() {
        return answer2;
    }

    public void setAnswer2(WebAnswer answer2) {
        this.answer2 = answer2;
    }

    public WebAnswer getAnswer3() {
        return answer3;
    }

    public void setAnswer3(WebAnswer answer3) {
        this.answer3 = answer3;
    }

    public WebAnswer getAnswer4() {
        return answer4;
    }

    public void setAnswer4(WebAnswer answer4) {
        this.answer4 = answer4;
    }

    @Override
    public String toString() {
        return "WebQuestionAnswer [question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
                + ", answer3=" + answer3 + ", answer4=" + answer4 + "]";
    }
    
    

}
