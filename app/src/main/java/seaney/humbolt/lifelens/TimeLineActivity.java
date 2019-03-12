package seaney.humbolt.lifelens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.sql.Time;
import java.util.List;

import seaney.humbolt.lifelens.Fragments.ComposeFragment;
import seaney.humbolt.lifelens.Fragments.FragmentPosts;
import seaney.humbolt.lifelens.Models.Post;
import seaney.humbolt.lifelens.adaptor.PostAdaptor;

public class TimeLineActivity extends AppCompatActivity {


    private BottomNavigationView btmNavView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        // define your fragments here
        //final Fragment fragment1 = new FirstFragment();
       // final Fragment fragment2 = new SecondFragment();
        //final Fragment fragment3 = new ThirdFragment();

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
                        frag_compose = new ComposeFragment();
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
