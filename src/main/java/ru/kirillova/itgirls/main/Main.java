package ru.kirillova.itgirls.main;

import ru.kirillova.itgirls.entity.Account;
import ru.kirillova.itgirls.exception.WrongLoginException;
import ru.kirillova.itgirls.exception.WrongLoginOrPasswordException;
import ru.kirillova.itgirls.exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        try {
            account.setLogin("loginlogin");
        } catch (WrongLoginException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            account.setPassword("aaaabbbbb", "aaaabbbbb");
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            account.checkLoginAndPassword("loginlogin", "aaaabbbbb");
        } catch (WrongLoginOrPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
