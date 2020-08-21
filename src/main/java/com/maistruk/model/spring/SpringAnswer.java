package com.maistruk.model.spring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "spring_answer")
public class SpringAnswer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    //@Column(length = 700)
    @Column(columnDefinition = "TEXT")
    private String answer;
    private Boolean flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "SpringAnswer [id=" + id + ", answer=" + answer + ", flag=" + flag + "]";
    }
    
    

}
