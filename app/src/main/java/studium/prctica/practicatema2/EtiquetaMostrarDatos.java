package studium.prctica.practicatema2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import studium.prctica.prcticatema1.R;


public class EtiquetaMostrarDatos extends AppCompatActivity {

    TextView txtV;
    Button btn3;
    //prueba para ver si actualiza
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etiqueta_mostrar_datos);

        //Localizar los controles
        txtV = (TextView) findViewById(R.id.textView10);
        btn3 = (Button) findViewById(R.id.button3);

        //Recuperamos la información pasada en el intent
        //Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar



            txtV.setText(getIntent().getExtras().getString("DATOS"));

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(EtiquetaMostrarDatos.this,
                        PracticaActivity.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}