package prova.dam.pmdm.ad3b;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Alejandro on 16/12/16.
 */
public class SActivity extends Activity{

    public static final String PREFS = "My preferences";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);

        final TextView name = (TextView) findViewById(R.id.name);
        final TextView dni = (TextView) findViewById(R.id.dni);
        final TextView bdate = (TextView) findViewById(R.id.bdate);
        final TextView sex = (TextView) findViewById(R.id.sex);

        SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
        name.setText(mySharedPreferences.getString("name", ""));
        dni.setText(mySharedPreferences.getString("dni", ""));
        bdate.setText(mySharedPreferences.getString("bdate", ""));
        sex.setText(mySharedPreferences.getString("sex",""));
    }
}
