package com.myy.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Cat implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private int id;
    private String name;
    private String color;

    public Cat() {
        super();
        System.out.println("Cat构造器");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware接口的setBeanFactory方法!");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware的setBeanName方法!");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean的afterPrppertiesSet方法!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean的destory方法!");
    }
    public void myInit(){
        System.out.println("调用<bean>的init方法!");
    }
    public void myDestory(){
        System.out.println("调用bean>的destory方法!");
    }
}
