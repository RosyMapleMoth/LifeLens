package seaney.humbolt.lifelens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity {


    private Button login;
    private TextView Username, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // set all views
        findViews();




        login();
    }


    // set up all view values that are needed
    public void findViews()
    {
        login = findViewById(R.id.btnLogin);
        Username = findViewById(R.id.tiUsername);
        Password = findViewById(R.id.tiPassword);
    }


    public void login()
    {
        // TODO add log in request
    }
}
