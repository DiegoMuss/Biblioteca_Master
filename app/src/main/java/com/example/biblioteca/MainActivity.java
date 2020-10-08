package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText text1, text2;
    private TextView textv;
    private ProgressBar progress;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (EditText) findViewById(R.id.name);
        text2 = (EditText) findViewById(R.id.password);
        textv = (TextView) findViewById(R.id.txtv);
        progress = (ProgressBar) findViewById(R.id.pb);
        boton = (Button) findViewById(R.id.button);

        progress.setVisibility(View.INVISIBLE);
        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user, password;
                user = text1.getText().toString();
                password = text2.getText().toString();

                if ((user.equals("android") || user.equals("Android")) && (password.equals("123")))
                {

                    new Task().execute();
                }
                else
                {
                    textv.setText("Usuario o contraseña incorrecta, intentelo nuevamente");
                }
            }
        });

    }

    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute()
        {
            progress.setVisibility(View.VISIBLE);
        }
        @Override
        protected String doInBackground(String... strings) {
            for(int i=1; i<=10; i++)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s)
        {
            Intent i = new Intent(getBaseContext(), home.class);
            startActivity(i);
        }
    }

    public void github (View v)
    {
        ArrayList<String> libros=new ArrayList<String>();

        libros.add("Farenheit");
        libros.add("Revival");
        libros.add("El Alquimista");

        Intent i = new Intent(getBaseContext(), github_act.class);

        i.putExtra("listalibros",libros);
        startActivity(i);
    }
}