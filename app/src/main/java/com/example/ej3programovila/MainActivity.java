package com.example.ej3programovila;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Atributos que representan cada elemento visual que diseñen
    //Propiedades de la clase
    private EditText tbNombre, tbnCelular;
    private TextView txtResultado;
    private Button btnInvertir;

    private String nombre;
    private  int celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        /*Para configurarar al boton y decirle que este pendiente al evento click
        * que se haga sobre el boton usamos el metodo del tipo SETTER
        * Y en realidad ustede quieren configurar un concepto llamado
        * LISTENER ALGO QUE ESTA PENDIENTE A QUE PASE CIERTO EVENTO*/
        //btnInvertir.setOnClickListener(this.onClick());
    }

    private void inicializarVistas(){
        /*Definimos el enlace de las variables o  atributos
        con sus componentes visuales que se han disenado
        Inicilizando las vistas, refereciandolas */

        txtResultado = findViewById(R.id.textView);
        tbNombre = findViewById(R.id.tbNombre);
        tbnCelular = findViewById(R.id.tbnCelular);
        btnInvertir = findViewById(R.id.btnInvertir);

    }

    private void obtenerInformacionUsuario(){
        /*Para obtener la informacion que el usuario introduce en los campos
        de texto, se obtiene esos valores del atributo TEXT que esta presente
        en el disenador y para obtener algo en POO en JAVA se debe usar GETTER
        Para obtener texto usaremos .getText */

        //Casteos

        nombre = tbNombre.getText().toString();
        String celularText = tbnCelular.getText().toString();
        celular = Integer.parseInt(celularText);
    }

    private void invertirNumero(){
        int resto = 0, invertido=0;
        while(this.celular > 0){
            resto = this.celular % 10;
            invertido = invertido * 10 + resto;
            this.celular = this.celular / 10;
        }
        txtResultado=setText("Hola "+ nombre +" el valor invertirdo es: " + invertido);
    }

    @Override
    public void onClick(View view){
        obtenerInformacionUsuario();
        invertirNumero();
    }

}