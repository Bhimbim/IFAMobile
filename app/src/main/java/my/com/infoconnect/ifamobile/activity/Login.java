package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import id.co.jne.jnemobile.courier.R;
import id.co.jne.jnemobile.courier.function.TypefaceGenerator;
import id.co.jne.jnemobile.courier.variable.constant.UserInterface;


// ACTIVITY

public class Login extends AppCompatActivity
{
    // IMPORT

        public TypefaceGenerator functionTypefaceGenerator;
        // protected LinkGenerator functionLinkGenerator;

        // LAYOUT

        protected List<Integer> listTypefacePrimary = new ArrayList<Integer>();
        protected List<Integer> listTypefaceSecondary = new ArrayList<Integer>();
        protected List<Integer> listTypefaceTertiary = new ArrayList<Integer>();


    // ON CREATE

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // INITIALIZATION

        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_login);

        functionTypefaceGenerator = new TypefaceGenerator(this, this);


        // TYPEFACE

        listTypefaceSecondary.add(R.id.editTextUserName);
        listTypefaceSecondary.add(R.id.editTextPassword);
        listTypefaceSecondary.add(R.id.buttonLogin);

        functionTypefaceGenerator.typefaceImplementor(listTypefaceSecondary, functionTypefaceGenerator.typefaceSecondary
                (), UserInterface.FONT_SECONDARY_NAME);


        // LAYOUT

            // LAYOUT DECLARATION

            Button buttonLogin = (Button) findViewById(R.id.buttonLogin);


        // EVENT

        buttonLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent GoToLogin = new Intent(getApplicationContext(), Home.class);
                GoToLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(GoToLogin);
            }
        });
    }
}