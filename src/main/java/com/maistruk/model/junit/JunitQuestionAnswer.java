package com.maistruk.model.junit;

public class JunitQuestionAnswer {

    private JunitQuestion question;
    private JunitAnswer answer1;
    private JunitAnswer answer2;
    private JunitAnswer answer3;
    private JunitAnswer answer4;

    public JunitQuestion getQuestion() {
        return question;
    }

    public void setQuestion(JunitQuestion question) {
        this.question = question;
    }

    public JunitAnswer getAnswer1() {
        return answer1;
    }

    public void setAnswer1(JunitAnswer answer1) {
        this.answer1 = answer1;
    }

    public JunitAnswer getAnswer2() {
        return answer2;
    }

    public void setAnswer2(JunitAnswer answer2) {
        this.answer2 = answer2;
    }

    public JunitAnswer getAnswer3() {
        return answer3;
    }

    public void setAnswer3(JunitAnswer answer3) {
        this.answer3 = answer3;
    }

    public JunitAnswer getAnswer4() {
        return answer4;
    }

    public void setAnswer4(JunitAnswer answer4) {
        this.answer4 = answer4;
    }

    @Override
    public String toString() {
        return "JunitQuestionAnswer [question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
                + ", answer3=" + answer3 + ", answer4=" + answer4 + "]";
    }

    
}
