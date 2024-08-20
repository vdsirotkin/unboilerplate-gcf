package com.vdsirotkin.gcf;

public class TestDto {
    private final String name;
    private final int age;

    public TestDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
