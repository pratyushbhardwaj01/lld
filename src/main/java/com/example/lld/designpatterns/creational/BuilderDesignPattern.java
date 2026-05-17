package com.example.lld.designpatterns.creational;

final class Student {
    private String name;
    private Integer age;
    private String college;
    private String gender;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.college = builder.college;
        this.gender = builder.gender;
    }
    public String getName() {
        return this.name;
    }

    public static class Builder {
        private String name;
        private Integer age;
        private String college;
        private String gender;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setCollege(String college) {
            this.college = college;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }
}


public class BuilderDesignPattern {
    public static void main(String[] args) {
        Student  student1 = new Student.Builder().setAge(10).setCollege("IIT Bombay").setGender("MALE").setName("Pratyush").build();
        System.out.println(student1.getName());
    }


}
