package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R.color;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @SuppressLint("SetTextI18n")
    public void BT_Calcular(View View)
    {
        EditText NotaP1 = findViewById(R.id.LBL_Nota_P1);
        EditText NotaP2 = findViewById(R.id.LBL_Nota_P2);
        EditText NotaAT = findViewById(R.id.LBL_Nota_AT);

        TextView txt_resultado = findViewById(R.id.TXT_Resultado);
        TextView txt_alerta = findViewById(R.id.TXT_Alerta);
        TextView txt_situacao = findViewById(R.id.TXT_Situacao);

        double P1 = Double.parseDouble(NotaP1.getText().toString());
        double P2 = Double.parseDouble(NotaP2.getText().toString());
        double AT = Double.parseDouble(NotaAT.getText().toString());

        if(P1 >= 10.1 || P2 >= 10.1 || AT >= 10.1)
        {
           txt_alerta.setText("Somente Nota de 0 a 10");
            NotaP1.setText("");
            NotaP2.setText("");
            NotaAT.setText("");
            txt_resultado.setText("");
            txt_situacao.setText("");

        }
        else
        {
            txt_alerta.setText("");

            double NotaFinal = (((P1 * 0.4 + P2 * 0.6) * 0.8) + AT * 0.2);

            @SuppressLint("DefaultLocale") String Resultado = String.format("Sua Nota Final É: %.2f", NotaFinal);
            if (NotaFinal >= 6)
            {
                txt_resultado.setTextColor(getResources().getColor(color.verde));
                txt_situacao.setTextColor(getResources().getColor(color.verde));

                txt_resultado.setText(Resultado);
                txt_situacao.setText("APROVADO");
            }
            else
            {
                txt_resultado.setTextColor(getResources().getColor(color.red));
                txt_situacao.setTextColor(getResources().getColor(color.red));

                txt_resultado.setText(Resultado);
                txt_situacao.setText("REPROVADO");
            }


        }

    }

    public void BT_Limpar(View V)
    {
        EditText NotaP1 = findViewById(R.id.LBL_Nota_P1);
        EditText NotaP2 = findViewById(R.id.LBL_Nota_P2);
        EditText NotaAT = findViewById(R.id.LBL_Nota_AT);

        TextView txt_resultado = findViewById(R.id.TXT_Resultado);
        TextView txt_alerta = findViewById(R.id.TXT_Alerta);
        TextView txt_situacao = findViewById(R.id.TXT_Situacao);

        NotaP1.setText("");
        NotaP2.setText("");
        NotaAT.setText("");

        txt_resultado.setText("");
        txt_alerta.setText("");
        txt_situacao.setText("");
    }

}