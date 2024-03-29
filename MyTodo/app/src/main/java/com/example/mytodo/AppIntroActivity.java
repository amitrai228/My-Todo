package com.example.mytodo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class AppIntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_app_intro);

        addSlide(AppIntroFragment.newInstance("Welcome to Your Todo App", "To add a new Todo Click at the Plus Icon",
                R.drawable.one, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Want to change your todo?", "Just click on it",
                R.drawable.two, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryLight)));
        addSlide(AppIntroFragment.newInstance("Completed your todo?", "Swipe to Delete it",
                R.drawable.three, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark)));
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}
