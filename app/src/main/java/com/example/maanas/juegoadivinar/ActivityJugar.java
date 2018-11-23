package com.example.maanas.juegoadivinar;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityJugar extends AppCompatActivity {
EditText et_num_usuario;
TextView tv_intentos;
Button btn_comprobar;
View v;
    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        et_num_usuario=findViewById(R.id.et_num_usuario);
        tv_intentos=findViewById(R.id.tv_intentos);
        btn_comprobar=findViewById(R.id.btn_comprobar);

    }


    public int obtenerAleatorio(){
        double d=Math.random();
        int n_maximo = MainActivity.darNumMaximo();
        double aleatorio=d*n_maximo;
        int n_aleatorio=(int)aleatorio;
        return n_aleatorio;

    }


    int intentos = 0;
    int numero_aleatorio = obtenerAleatorio();

public void comprobar(View v) {
            String numero = et_num_usuario.getText().toString();

            int n_maximo= MainActivity.darNumMaximo();
   buttonEffect(btn_comprobar);


  if (numero.equals(""))
    {
        Toast.makeText(this, "Introduzca un número, y luego pulse enviar.", Toast.LENGTH_LONG).show();
    }
    else
  {
      int numero_usuario = Integer.parseInt(numero);

        if (numero_usuario > n_maximo)
            {
            intentos++;
            tv_intentos.setText(String.valueOf(intentos));
            Toast.makeText(this, "¿No  te acuerdas del número que me has dicho? Era " + n_maximo + ", así que no te pases.", Toast.LENGTH_SHORT).show();
            }
        else
            {

            if (numero_usuario == numero_aleatorio) {
                intentos++;
                tv_intentos.setText(String.valueOf(intentos));
                Toast.makeText(this, "Muy bien, has acertado, has necesitado " + intentos + " intentos.", Toast.LENGTH_LONG).show();

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);

            }

            else if (numero_usuario < numero_aleatorio) {
                intentos++;
                tv_intentos.setText(String.valueOf(intentos));
                Toast.makeText(this, "No estaba pensando en ese número. Intentalo otra vez, es mayor.", Toast.LENGTH_LONG).show();

            }

            else if (numero_usuario > numero_aleatorio) {
                intentos++;
                tv_intentos.setText(String.valueOf(intentos));
                Toast.makeText(this, "Ese número no es, es menor, inténtalo otra vez.", Toast.LENGTH_LONG).show();
            }

            }
       }
    et_num_usuario.setText("");

    }


    private void buttonEffect(Button btn_comprobar) {
        btn_comprobar.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521,PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }



}
