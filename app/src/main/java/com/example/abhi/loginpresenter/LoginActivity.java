package com.example.abhi.loginpresenter;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.mockito.stubbing.OngoingStubbing;

public class LoginActivity extends AppCompatActivity implements LoginView{
    EditText usernameView;
    EditText passwordView;
    LoginPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    public void  onLoginClicked(View view){
        presenter.onLoginClicked();
        String username = usernameView.getText().toString();
        String password = passwordView.getText().toString();

        boolean loggedIn = new LoginService().login(username, password);
        if(loggedIn){
            new ActivityUtil(this).startMainActivity();
        }
        else{
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public String getUsername() {
        return usernameView.getText().toString();
    }

    @Override
    public void showUsernameError(int resId) {
        usernameView.setError(getString(resId));
    }

    @Override
    public String getPassword(){
        return passwordView.getText().toString();
    }

    @Override
    public void showPasswordError(int resId){
        passwordView.setError(getString(resId));
    }

    @Override
    public void startMainActivity(){
        new ActivityUtil(this).startMainActivity();
    }

    public void showLoginError(int resId){
        Toast.makeText(this, getString(R.string.login_failed), Toast.LENGTH_SHORT).show();

    }
}
