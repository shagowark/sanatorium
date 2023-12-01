package com.example.sanatorium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SanatoriumApplication {


    public static void main(String[] args) {
        SpringApplication.run(SanatoriumApplication.class, args);
    }

}

//TODO обработать в контроллерах ошибку при update, добавить сообщение в Model, сообщить на странице

//TODO security (админ панель)

//TODO навесить @Transactional в сервисах?

//TODO filtration (>1 param)

//TODO pagination

//TODO static info

//TODO тесты

//TODO beautiful web ui

//TODO проверку в сервисах (?) на неверные данные.
// Например, бронь на уже занятое время
