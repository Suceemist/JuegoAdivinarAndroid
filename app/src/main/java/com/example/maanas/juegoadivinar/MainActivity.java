package com.example.maanas.juegoadivinar;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   static EditText et_num_maximo;
   Button btn_jugar;

    public static int darNumMaximo() {
        String numero = et_num_maximo.getText().toString();
        int numero_maximo = Integer.parseInt(numero);
        return numero_maximo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_num_maximo=findViewById(R.id.et_num_maximo);
        btn_jugar=findViewById(R.id.btn_jugar);

    }

  public void jugar(View v){

      buttonEffect(btn_jugar);

        if (et_num_maximo.getText().toString().equals(""))
        {
            Toast.makeText(this, "Introduzca un número máximo, y luego pulse jugar", Toast.LENGTH_SHORT).show();
        }
         else
            {
           int n_maximo =  darNumMaximo();
           if(darNumMaximo()>200)
           {
            Toast.makeText(this, "Tampoco te hagas sufrir así, que sea un número menor de 200.", Toast.LENGTH_SHORT).show();
           }
             else
               {
                Intent i = new Intent(this, ActivityJugar.class);
                startActivity(i);
               }

           }
    }

    private void buttonEffect(Button btn_jugar) {
        btn_jugar.setOnTouchListener(new View.OnTouchListener() {

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
