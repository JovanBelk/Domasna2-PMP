package com.example.recnik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Klik(View view) {
        EditText tekst = (EditText) findViewById(R.id.tekst2);
        String text = tekst.getText().toString();
        String definicija = Pronajdi(text);
        TextView tekstt = (TextView) findViewById(R.id.tekst1);

        if(definicija!=null)
            tekstt.setText(definicija);
            else
                tekstt.setText("Ne e pronajden takov zbor vo recnikot");
    }

    private String Pronajdi(String text) {
        InputStream input = getResources().openRawResource(R.raw.recnik);
        Scanner scan = new Scanner(input);

        while(scan.hasNext()){
            String line = scan.nextLine();
            String[] niza = line.split(",");

            if(niza[0].equalsIgnoreCase(text.trim())){
                return niza[1];
            }
        }
        return null;
    }
}





