package com.example.abhi.loginpresenter;

class LoginService {
    public boolean login(String username, String password) {
        return "thunder".equals(username) && "flash".equals(password);
    }
}
