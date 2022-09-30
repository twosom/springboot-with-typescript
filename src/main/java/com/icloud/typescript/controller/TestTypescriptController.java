package com.icloud.typescript.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestTypescriptController {

    @GetMapping("/hello")
    public ResponseEntity<HelloModel> hello() {
        return ResponseEntity.ok(
                new HelloModel("Hope", 28)
        );
    }


    static class HelloModel {
        private String name;
        private Integer age;

        public HelloModel(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

}
