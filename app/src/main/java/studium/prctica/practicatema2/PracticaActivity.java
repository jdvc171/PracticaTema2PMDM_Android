package studium.prctica.practicatema2;

import android.graphics.Typeface;
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

import studium.prctica.prcticatema2.R;

public class PracticaActivity extends AppCompatActivity  {

    Spinner lista1;
    EditText editNombre,editapellidos,editedad;
    TextView txtNombre,txtApellidos,txtEdad,txtVhijos,txtgenero,txtdatosError,txtCorrecto,txtEstado;
    Switch switch1;
    Button btn1,btn2;
    RadioGroup RG;
    ArrayAdapter adapEstados;

    //objetos para la fuente
    Typeface West;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica);

        //Obtenemos una referencia a los controles de la interfaz
        txtNombre = findViewById(R.id.nombre);
        txtApellidos = findViewById(R.id.apellidos);
        txtEdad = findViewById(R.id.edad);

        editNombre =  findViewById(R.id.editText3);
        editapellidos =  findViewById(R.id.editText4);
        editedad =  findViewById(R.id.editText5);
        txtEstado = findViewById(R.id.textView8);
        txtdatosError = findViewById(R.id.textView0);
        txtCorrecto = findViewById(R.id.textViewCorrecto);
        txtVhijos = findViewById(R.id.textView9);
        txtgenero =  findViewById(R.id.textView7);
        switch1 =  findViewById(R.id.switch1);
        lista1 =  findViewById(R.id.lista1);
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        RG =  findViewById(R.id.radioButton1);

        txtdatosError.setVisibility(View.INVISIBLE);
        txtCorrecto.setVisibility(View.INVISIBLE);
         adapEstados =  ArrayAdapter.createFromResource(this,R.array.estado2,
                        android.R.layout.simple_spinner_dropdown_item);

        lista1.setAdapter(adapEstados);

        //aplicamos fuente a elementos
        String fuente1 = "fuentes/West.ttf";
        this.West = Typeface.createFromAsset(getAssets(),fuente1);
        txtNombre.setTypeface(West);
        txtApellidos.setTypeface(West);
        txtEdad.setTypeface(West);
        txtgenero.setTypeface(West);
        txtCorrecto.setTypeface(West);
        txtVhijos.setTypeface(West);
        txtEstado.setTypeface(West);
        btn1.setTypeface(West);
        btn2.setTypeface(West);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Obtenemos radiobutton seleccionado
                int rg1 = RG.getCheckedRadioButtonId();
                RadioButton rb1 = findViewById(rg1);
                txtdatosError.setVisibility(View.INVISIBLE);
                txtCorrecto.setText("");

                //obtenemos el valor del switch
                String sino="";
                boolean nosi = switch1.isChecked();
                if (nosi==true){
                    sino=switch1.getTextOn().toString();
                }
                else{
                    sino =switch1.getTextOff().toString();
                }

                //Iniciamos las condiciones para mostrar resultados
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



                    txtCorrecto.setText(editapellidos.getText().toString()+", "+
                            editNombre.getText().toString()+"\n"+edadFinal +", "+ rb1.getText()+
                            ", " + lista1.getSelectedItem()+"\n" + txtVhijos.getText() +
                            sino+"\n");
                    txtCorrecto.setVisibility(View.VISIBLE);

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


                     txtdatosError.setText(data);
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
                lista1.setSelection(0);
                txtCorrecto.setText("");
                txtCorrecto.setVisibility(View.INVISIBLE);
                txtdatosError.setVisibility(View.INVISIBLE);
                txtdatosError.setText(R.string.datosError);
            }
        });

    }

}
