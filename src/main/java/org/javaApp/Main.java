package org.javaApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//@ComponentScan(basePackages = "org.javaApp")
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        }
    }
