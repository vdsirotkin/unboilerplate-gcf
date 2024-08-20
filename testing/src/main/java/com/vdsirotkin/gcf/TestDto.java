package com.vdsirotkin.gcf;

public record TestDto(String name, int age) {

    @Override
    public String toString() {
        return "TestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
