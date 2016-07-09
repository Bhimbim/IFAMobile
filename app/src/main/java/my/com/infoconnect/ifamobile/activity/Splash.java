package my.com.infoconnect.ifamobile.activity;


// IMPORT

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import id.co.jne.jnemobile.courier.R;


// ACTIVITY

public class Splash extends AppCompatActivity
{
    // ON CREATE

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // LAYOUT DECLARATION

        setContentView(R.layout.screen_splash);

        // EVENT

        // EVENT

        final Intent GoToLogin = new Intent(this, Login.class);
        GoToLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        android.os.Handler HandlerSplash = new android.os.Handler();
        HandlerSplash.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(GoToLogin);
            }
        }, 3000);
    }
}