package com.usian.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zby
 * @create 2020-10-28 20:05
 */

public class Student {


    private Integer id;
    private String name;
    private String pwd;
    private Integer sex;
    private Integer age;

    public Student(Integer id, String name, String pwd, Integer sex, Integer age) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public Integer getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }
}
