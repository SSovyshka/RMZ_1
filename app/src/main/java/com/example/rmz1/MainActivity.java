package com.example.rmz1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//          ▄▌▐▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▌
//       ▄▄██▌█ Autor: Sovyshka
//    ▄▄▄▌▐██▌█ Name: Bohdan Savchenko
//    ███████▌█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▌
//    ▀(@)▀▀▀▀▀▀▀(@)(@)▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀(@)▀

public class MainActivity extends AppCompatActivity {
    private Button button;
    private boolean styleFlag = false;
    private boolean exitFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.click_me_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick();
            }
        });
    }

    private void handleButtonClick() {
        if (!styleFlag) {
            if (exitFlag) {
                showToast("I'm done with you!", Toast.LENGTH_LONG);
                finish();
                return;
            }

            setButtonStyle(button, Color.BLACK, Color.WHITE, "Don't click on me anymore!");

            showToast("Hey, why you clicked me?!", Toast.LENGTH_SHORT);
            styleFlag = !styleFlag;
        }
        else {
            setButtonStyle(button, Color.WHITE, Color.BLACK, "Dude, you're not serious");

            styleFlag = !styleFlag;
            exitFlag = !exitFlag;
        }
    }

    private void setButtonStyle(Button btn, int backgroundColor, int textColor, String buttonText) {
        btn.setBackgroundColor(backgroundColor);
        btn.setTextColor(textColor);
        btn.setText(buttonText);
    }

    private void showToast(String message, int duration) {
        Toast.makeText(this, message, duration).show();
    }

}