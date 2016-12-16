package prova.dam.pmdm.ad3b;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

    public static final String PREFS = "My preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bsend = (Button) findViewById(R.id.bsend);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText dni = (EditText) findViewById(R.id.dni);
        final EditText bdate = (EditText) findViewById(R.id.bdate);
        final RadioButton man = (RadioButton) findViewById(R.id.man);
        final RadioButton wom = (RadioButton) findViewById(R.id.wom);

        bsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el objeto de Preferencias, pero antes se debería comprobar que todo esta lleno
                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

                // Creamos un editor para modificar las preferencias
                SharedPreferences.Editor editor = mySharedPreferences.edit();

                //Guardamos lo necesario
                editor.putString("name",name.getText().toString());
                editor.putString("dni",dni.getText().toString());
                editor.putString("bdate",bdate.getText().toString());
                if(man.isChecked()){
                    editor.putString("sex","Hombre");
                }else if(wom.isChecked()){
                    editor.putString("sex", "Mujer");
                }
                Intent sAct = new Intent(getApplicationContext(), SActivity.class);
                startActivity(sAct);

            }
        });
    }
}
