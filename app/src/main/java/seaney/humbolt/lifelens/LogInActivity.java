package seaney.humbolt.lifelens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LogInActivity extends AppCompatActivity {


    private Button btnLogin, btnSignup;
    private TextView tvUsername, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // set all views
        findViews();

        if (ParseUser.getCurrentUser() != null)
        {
            Intent i = new Intent(LogInActivity.this, TimeLineActivity.class);
            startActivity(i);
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(tvUsername.getText().toString(), tvPassword.getText().toString(), new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Intent i = new Intent(LogInActivity.this, TimeLineActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(getBaseContext(),"Password and Username did not match our records", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser newUser = new ParseUser();
                newUser.setUsername(tvUsername.getText().toString());
                newUser.setPassword(tvPassword.getText().toString());

                newUser.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Intent i = new Intent(LogInActivity.this, TimeLineActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(),"Sorry but something went wrong please try again later",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        login();
    }

    // set up all view values that are needed
    public void findViews()
    {
        btnSignup = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        tvUsername = findViewById(R.id.tiUsername);
        tvPassword = findViewById(R.id.tiPassword);
    }


    public void login()
    {
        // TODO add log in request
    }
}
