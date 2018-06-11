package com.example.abhi.loginpresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginActivityTest {
    @Mock
    private LoginView view;
    @Mock
    private LoginService service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception{
        presenter = new LoginPresenter(view, service);
    }
    @Test
    public void ShowsErrorMessageIfUsernameIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showUsernameError(R.string.username_error);
    }


    @Test
    public void ShowsErrorMessageIfPasswordIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("thunder");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showPasswordError(R.string.password_error);
    }

    @Test
    public void ChecksBothUserNameAndPassword() throws Exception{
        when(view.getUsername()).thenReturn("thunder");
        when(view.getPassword()).thenReturn("flash");
        when(service.login("thunder", "flash")).thenReturn(true);
        presenter.onLoginClicked();

        verify(view).startMainActivity();
    }

     @Test
    public void ShowsErrorMessageIfBothUsernameAndPasswordIsWrong() throws Exception {
        when(view.getUsername()).thenReturn("thunder");
        when(view.getPassword()).thenReturn("flash");
         when(service.login("thunder", "flash")).thenReturn(false);
        presenter.onLoginClicked();

        verify(view).showLoginError(R.string.login_failed);
    }
}