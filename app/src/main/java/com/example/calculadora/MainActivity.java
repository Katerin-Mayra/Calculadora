package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView inputlabel;
    String cad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cad="";
        loadComponets();
       // String cad = "2+4*(3+1)+(66.32*26.2323)";
        /*
        String cad = "2+4*(3+1)+(3+10.5)+(2*1)+(10-5)*(2^2)+(3/4)";
        Calculadora calc= new Calculadora(cad);
        String results= calc.solve();
        Log.d("RESULT=>",results);
       */

        /*
        String regx = "\\([\\d\\+\\-\\*\\/\\^\\.]+\\)";
        RegularMatch match =new RegularMatch(cad,regx);
        ArrayList<String> results= match.match();
        for(int i=0;i<results.size();i++){
            Log.d("RESULTS",results.get(i));
            /*
            Toast.makeText(this, results.get(i),Toast.LENGTH_LONG).show();


        }
*/
    }

    private void loadComponets() {
        inputlabel=findViewById(R.id.maininput);
        Button runbtn = findViewById(R.id.resultfinal);
        Button clear= findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cad="";
                inputlabel.setText("");
            }
        });
        runbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calculadora calc= new Calculadora(cad);
                String results= calc.solve();
                inputlabel.setText(results);

            }
        });
        Integer[] lista  ={
               R.id.button0,R.id.button1,
                R.id.button2,R.id.button3,
                R.id.button4,R.id.button5,
                R.id.button6,R.id.button7,
                R.id.button8,R.id.button9,
                R.id.button10,R.id.button11,
                R.id.button13,
                R.id.button14,R.id.button15,
                R.id.button19,R.id.button20,
                R.id.button21
        };
        for (int i=0; i< lista.length;i++){
            Button btn =findViewById(lista[i]);
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        cad += btn.getText();
        inputlabel.setText(cad);

    }
}












