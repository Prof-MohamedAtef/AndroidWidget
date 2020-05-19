package mo.ed.aad.mywidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SessionManagement sessionManagement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManagement=new SessionManagement(getApplicationContext());
        sessionManagement.setCOVIDData("Wash Hands regularly", "Keep Safe in Home", "Don't use other's tool");
    }
}
