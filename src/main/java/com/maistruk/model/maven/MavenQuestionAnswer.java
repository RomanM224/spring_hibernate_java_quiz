package com.maistruk.model.maven;

public class MavenQuestionAnswer {

    private MavenQuestion question;
    private MavenAnswer answer1;
    private MavenAnswer answer2;
    private MavenAnswer answer3;
    private MavenAnswer answer4;

    public MavenQuestion getQuestion() {
        return question;
    }

    public void setQuestion(MavenQuestion question) {
        this.question = question;
    }

    public MavenAnswer getAnswer1() {
        return answer1;
    }

    public void setAnswer1(MavenAnswer answer1) {
        this.answer1 = answer1;
    }

    public MavenAnswer getAnswer2() {
        return answer2;
    }

    public void setAnswer2(MavenAnswer answer2) {
        this.answer2 = answer2;
    }

    public MavenAnswer getAnswer3() {
        return answer3;
    }

    public void setAnswer3(MavenAnswer answer3) {
        this.answer3 = answer3;
    }

    public MavenAnswer getAnswer4() {
        return answer4;
    }

    public void setAnswer4(MavenAnswer answer4) {
        this.answer4 = answer4;
    }

    @Override
    public String toString() {
        return "MavenQuestionAnswer [question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
                + ", answer3=" + answer3 + ", answer4=" + answer4 + "]";
    }
}
