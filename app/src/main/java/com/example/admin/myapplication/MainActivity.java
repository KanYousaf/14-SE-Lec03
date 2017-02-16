package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText userName, password;
    private RadioButton rbNone, rbDon,rbLeo,rbMike,rbRaph;
    private ImageView displayTMNTImage;
    private RatingBar rateTMNT;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=(EditText)this.findViewById(R.id.userNameEt);
        password=(EditText)this.findViewById(R.id.userPwdEt);

        rbNone=(RadioButton)this.findViewById(R.id.rb_none);
        rbNone.setChecked(true);

        displayTMNTImage=(ImageView)this.findViewById(R.id.display_character_image);
        displayTMNTImage.setVisibility(View.GONE);

        rateTMNT=(RatingBar)this.findViewById(R.id.rate_tmnt);
        rateTMNT.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateTMNT.setRating(rating);
            }
        });


    }

    public void choose_tmnt_character(View view) {
        rbDon=(RadioButton)this.findViewById(R.id.rb_don);
        rbLeo=(RadioButton)this.findViewById(R.id.rb_leo);
        rbMike=(RadioButton)this.findViewById(R.id.rb_mike);
        rbRaph=(RadioButton)this.findViewById(R.id.rb_raph);

        if(rbDon.isChecked() || rbLeo.isChecked() || rbMike.isChecked() || rbRaph.isChecked()){
            displayTMNTImage.setVisibility(View.VISIBLE);
            if(view.getId()==rbDon.getId()){
                displayTMNTImage.setImageResource(R.drawable.tmntdon);
                name=rbDon.getText().toString();
            }else if(view.getId()==rbLeo.getId()){
                displayTMNTImage.setImageResource(R.drawable.tmntleo);
                name=rbLeo.getText().toString();
            }else if(view.getId()==rbMike.getId()){
                displayTMNTImage.setImageResource(R.drawable.tmntmike);
                name=rbMike.getText().toString();
            }else{
                displayTMNTImage.setImageResource(R.drawable.tmntraph);
                name=rbRaph.getText().toString();
            }
        }else{
            displayTMNTImage.setVisibility(View.GONE);
            name=rbNone.getText().toString();
        }
    }

    public void enter_pressed_function(View view) {
        if(userName.getText().toString().trim().isEmpty() || password.getText().toString().trim().isEmpty())
        {
            Toast.makeText(MainActivity.this, "Enter User Name and Password",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "User Name: "+userName.getText().toString()
                                             +" Password: "+password.getText().toString()
                                              +" Charcter Name is: "+name
                                              + "Rating Value: "+String.valueOf(rateTMNT.getRating()), Toast.LENGTH_SHORT).show();
        }
    }
}
