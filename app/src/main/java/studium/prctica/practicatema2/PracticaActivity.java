package studium.prctica.practicatema2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import studium.prctica.prcticatema1.R;

public class PracticaActivity extends AppCompatActivity  {

    Spinner lista1;
    EditText editNombre,editapellidos,editedad;
    TextView txtNombre,txtApellidos,txtEdad,txtVhijos,txtgenero,txtdatos,txtdatosError;
    Switch switch1;
    Button btn1,btn2;
    RadioGroup RG;
    ArrayAdapter adapEstados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica);

        //Obtenemos una referencia a los controles de la interfaz
        txtNombre = (TextView)findViewById(R.id.nombre);
        txtApellidos = (TextView)findViewById(R.id.apellidos);
        txtEdad = (TextView)findViewById(R.id.edad);

        editNombre = (EditText) findViewById(R.id.editText3);
        editapellidos = (EditText) findViewById(R.id.editText4);
        editedad = (EditText) findViewById(R.id.editText5);
        txtdatosError = (TextView)findViewById(R.id.textView0);
        txtVhijos = (TextView)findViewById(R.id.textView9);
        txtgenero = (TextView) findViewById(R.id.textView7);
        switch1 = (Switch) findViewById(R.id.switch1);
        lista1 = (Spinner) findViewById(R.id.lista1);
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        RG = (RadioGroup) findViewById(R.id.radioButton1);

        txtdatosError.setVisibility(View.INVISIBLE);

         adapEstados =  ArrayAdapter.createFromResource(this,R.array.estado2,
                        android.R.layout.simple_spinner_dropdown_item);

        lista1.setAdapter(adapEstados);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Obtenemos radiobutton seleccionado
                int rg1 = RG.getCheckedRadioButtonId();
                RadioButton rb1 = findViewById(rg1);

                 if(!editNombre.getText().toString().isEmpty() &&
                         !editapellidos.getText().toString().isEmpty() &&
                         !editedad.getText().toString().isEmpty())

                {
                    //Condicion edad
                    String años= editedad.getText().toString();
                    int años2 = Integer.parseInt(años);
                    String edadFinal="";

                    if(años2<18){edadFinal="Menor de edad";}
                    else{edadFinal="Mayor de edad";}

                    //Creamos el Intent
                    Intent intent = new Intent(PracticaActivity.this,
                            EtiquetaMostrarDatos.class);
                    intent.putExtra("DATOS",editapellidos.getText().toString()+", "+
                            editNombre.getText().toString()+"\n"+edadFinal +", "+ rb1.getText()+
                            ", " + lista1.getSelectedItem()+"\n" + txtVhijos.getText() +
                            switch1.getTextOff()+"\n");


                    //Iniciamos la nueva actividad
                    startActivity(intent);

                }

                else if (editNombre.getText().toString().isEmpty() ||
                         editapellidos.getText().toString().isEmpty() ||
                         editedad.getText().toString().isEmpty()) {
                     txtdatosError.setText(R.string.datosError);
                     String data= txtdatosError.getText().toString();
                     if(editNombre.getText().toString().isEmpty()){
                        data+=txtNombre.getText().toString();
                     }
                     if(editapellidos.getText().toString().isEmpty()){
                         data+=txtApellidos.getText().toString();
                     }
                     if(editedad.getText().toString().isEmpty()){
                         data+=txtEdad.getText().toString();
                     }
                     String caca= getResources().getString(R.string.mujer);


                    txtdatosError.setText(data+caca);
                     txtdatosError.setVisibility(View.VISIBLE);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNombre.setText("");
                editedad.setText("");
                editapellidos.setText("");
                switch1.setChecked(false);
                RG.check(R.id.radioButton6);
                txtdatosError.setVisibility(View.INVISIBLE);
                txtdatosError.setText(R.string.datosError);
            }
        });

    }

}
