package com.scj.leetcode.test;

/**
 * @author shengchaojie
 * @date 2020-05-11
 **/
public class Child extends Parent implements People{

    public Child() {
        System.out.println("specialMethod constructor");
    }

    public static void staticMethod(){
        System.out.println("static method");
    }

    @Override
    public void specialMethod() {
        System.out.println("specialMethod child");
    }

    public void virtualMethod(){
        System.out.println("virtual");
    }

    @Override
    public void walk() {
        System.out.println("walk");
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.specialMethod();
        child.virtualMethod();
        child.walk();
        Child.staticMethod();

        Parent parent = child;
        parent.specialMethod();

        People people = child;
        people.walk();


    }
}
