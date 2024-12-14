package ru.kirillova.itgirls.entity;

import ru.kirillova.itgirls.exception.WrongLoginException;
import ru.kirillova.itgirls.exception.WrongLoginOrPasswordException;
import ru.kirillova.itgirls.exception.WrongPasswordException;

import java.util.HashMap;
import java.util.Map;

public class Account {

    private String login;
    private String password;
    Map<String, String> loginAndPassword = new HashMap<String, String>();

    public Account() {
    }

    public void setLogin(String login) throws WrongLoginException {
        checkLogin(login);
        this.login = login;
        addLoginAndPassword();
    }

    public void setPassword(String password, String confirmPassword) throws WrongPasswordException {
        checkPassword(password, confirmPassword);
        this.password = password;
        addLoginAndPassword();
    }

    public void checkLogin(String login) throws WrongLoginException {
        if (login == null || login.length() < 5 || login.length() > 20) {
            throw new WrongLoginException("Неверный логин");
        }

        this.login = login;
    }

    public void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password == null || password.length() < 8 || password.length() > 20) {
            throw new WrongPasswordException("Неверный пароль");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public void addLoginAndPassword() {
        loginAndPassword.put(login, password);
    }

    public void checkLoginAndPassword(String login, String password) throws WrongLoginOrPasswordException {
        if (loginAndPassword.containsKey(login) && loginAndPassword.get(login).equals(password)) {
            System.out.println("Вы успешно вошли в аккаунт!");
        } else {
            throw new WrongLoginOrPasswordException("Неверный логин или пароль");
        }
    }
}