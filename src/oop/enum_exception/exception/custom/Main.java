package oop.enum_exception.exception.custom;

import oop.enum_exception.custom.LoginUser;

public class Main {
    public static void main(String[] args) {
        LoginUser user = new LoginUser("admin", "aa123");
        String result = null;
        try {
            result = user.authenticate("admin", "aa123");

        } catch (LoginInvalidException e) {
            System.out.println(e.getMessage());
            System.out.println("입력하신 값"+ e.getInputAccount());
        }

        System.out.println("result = " + result);
    }
}
