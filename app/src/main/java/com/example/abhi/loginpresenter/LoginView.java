package com.example.abhi.loginpresenter;

interface LoginView {
    public String getUsername();

    void showUsernameError(int resId);

    public String getPassword();

    void showPasswordError(int resId);

    void startMainActivity();

    void showLoginError(int resId);
}
