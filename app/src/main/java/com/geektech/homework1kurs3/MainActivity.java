package com.geektech.homework1kurs3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button send;
    private EditText address, subject, emailtext;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.btn_send);
        address =  findViewById(R.id.et_mail);
        subject =  findViewById(R.id.et_theme);
        emailtext =  findViewById(R.id.et_massage);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


            Intent intent=new Intent(Intent.ACTION_SENDTO,
                    Uri.fromParts("mailto",address.getText().toString(),null));
            intent.putExtra(Intent.EXTRA_EMAIL,address.getText().toString());
            intent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT,emailtext.getText().toString());
            startActivity(Intent.createChooser(intent,"send"));

       }

        });
    }
}