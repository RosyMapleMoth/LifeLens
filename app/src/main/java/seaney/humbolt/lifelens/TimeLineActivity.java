package seaney.humbolt.lifelens;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import seaney.humbolt.lifelens.Fragments.ComposeFragment;
import seaney.humbolt.lifelens.Fragments.FragmentPosts;
import seaney.humbolt.lifelens.Fragments.ProfileFragment;

public class TimeLineActivity extends AppCompatActivity {


    private BottomNavigationView btmNavView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        final FragmentManager fragmentManager = getSupportFragmentManager();



        btmNavView = findViewById(R.id.bottom_navigation);

        btmNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment frag_compose;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        frag_compose = new FragmentPosts();
                        break;
                    case R.id.compose_menu:
                        frag_compose = new ComposeFragment();
                        break;
                    case R.id.action_profile:
                        frag_compose = new ProfileFragment();
                        break;
                    default:
                        frag_compose = new ComposeFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, frag_compose).commit();
                return true;
            }
        });
        btmNavView.setSelectedItemId(R.id.compose_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.miLogout:
                ParseUser.logOutInBackground(new LogOutCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Intent i = new Intent(TimeLineActivity.this, LogInActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                        }
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
