package com.ue.charactersidebar.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ue.charactersidebar.R;
import com.ue.charactersidebar.easy.LetterSectionActivity;
import com.ue.charactersidebar.my.MyLetterSectionActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_letter_section, R.id.btn_my_letter_section})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_letter_section:
                startActivity(new Intent(MainActivity.this,LetterSectionActivity.class));
                break;
            case R.id.btn_my_letter_section:
                startActivity(new Intent(MainActivity.this,MyLetterSectionActivity.class));
                break;
        }
    }
}
