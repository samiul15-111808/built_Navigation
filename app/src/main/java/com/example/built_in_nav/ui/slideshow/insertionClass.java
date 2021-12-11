package com.example.built_in_nav.ui.slideshow;

public class insertionClass {

    String name;

    public insertionClass(String name, String course, String section) {
        this.name = name;
        this.course = course;
        this.section = section;
    }

    String course;
    String section;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getSection(){
        return section;
    }
    public void setSection(String section){
        this.section = section;
    }

    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }

}
