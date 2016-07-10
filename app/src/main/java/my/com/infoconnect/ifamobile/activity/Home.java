package my.com.infoconnect.ifamobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import my.com.infoconnect.ifamobile.R;

/**
 * Created by ibrahimaziztejokusumo on 7/10/16.
 */
public class Home extends AppCompatActivity
{
    // ONCREATE

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // INITIALIZATION

        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_home);

        Button buttonProspect = (Button) findViewById(R.id.buttonProspect);


        // EVENT

        buttonProspect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent GoToProspect = new Intent(Home.this, Prospect.class);
                startActivity(GoToProspect);
            }
        });
    }
}
