package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText userName, password;
    private RadioButton rbNone, rbDon,rbLeo,rbMike,rbRaph;
    private ImageView displayTMNTImage;
    private RatingBar rateTMNT;
    private String name;
    private Spinner tmnt_spinner;
    private String[] character_name_array, character_detail_array;
    private TextView display_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=(EditText)this.findViewById(R.id.userNameEt);
        password=(EditText)this.findViewById(R.id.userPwdEt);

        rbNone=(RadioButton)this.findViewById(R.id.rb_none);
        rbNone.setChecked(true);

        displayTMNTImage=(ImageView)this.findViewById(R.id.display_character_image);
        // make the view of image totally disappear on screen
        displayTMNTImage.setVisibility(View.GONE);

        rateTMNT=(RatingBar)this.findViewById(R.id.rate_tmnt);
        rateTMNT.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rateTMNT.setRating(rating);
            }
        });

        //spinner ID+ spinner Adapter
        tmnt_spinner=(Spinner)this.findViewById(R.id.tmnt_spinner);
        //string array
        character_name_array=getResources().getStringArray(R.array.tmnt_item_array);
        // adapter provides data to spinner
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, character_name_array);
        tmnt_spinner.setAdapter(adapter);
        tmnt_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(MainActivity.this,"Select any Item", Toast.LENGTH_SHORT).show();
                }else{
                    character_detail_array=getResources().getStringArray(R.array.tmnt_item_array_details);
                    display_text_view=(TextView)MainActivity.this.findViewById(R.id.display_character_details);
                    display_text_view.setText("The position is: "+position
                                    + "Item Details: "+character_detail_array[position]);


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void choose_tmnt_character(View view) {
        rbDon=(RadioButton)this.findViewById(R.id.rb_don);
        rbLeo=(RadioButton)this.findViewById(R.id.rb_leo);
        rbMike=(RadioButton)this.findViewById(R.id.rb_mike);
        rbRaph=(RadioButton)this.findViewById(R.id.rb_raph);
        // check if any radio button is clicked other than none for displaying image
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

    //menu details
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflater provides menu from XML file
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Home:
                Toast.makeText(this, "Home Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Search:
                Toast.makeText(this, "Search Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Play_store:
                Toast.makeText(this, "PlayStore Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Exit:
                Toast.makeText(this, "Exit Clicked",Toast.LENGTH_SHORT).show();
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
