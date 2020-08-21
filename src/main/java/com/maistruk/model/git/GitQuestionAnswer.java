package com.maistruk.model.git;

public class GitQuestionAnswer {

    private GitQuestion question;
    private GitAnswer answer1;
    private GitAnswer answer2;
    private GitAnswer answer3;
    private GitAnswer answer4;

    public GitQuestion getQuestion() {
        return question;
    }

    public void setQuestion(GitQuestion question) {
        this.question = question;
    }

    public GitAnswer getAnswer1() {
        return answer1;
    }

    public void setAnswer1(GitAnswer answer1) {
        this.answer1 = answer1;
    }

    public GitAnswer getAnswer2() {
        return answer2;
    }

    public void setAnswer2(GitAnswer answer2) {
        this.answer2 = answer2;
    }

    public GitAnswer getAnswer3() {
        return answer3;
    }

    public void setAnswer3(GitAnswer answer3) {
        this.answer3 = answer3;
    }

    public GitAnswer getAnswer4() {
        return answer4;
    }

    public void setAnswer4(GitAnswer answer4) {
        this.answer4 = answer4;
    }

    @Override
    public String toString() {
        return "GitQuestionAnswer [question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
                + ", answer3=" + answer3 + ", answer4=" + answer4 + "]";
    }
    
    

}
