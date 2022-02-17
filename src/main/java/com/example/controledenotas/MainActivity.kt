package com.example.controledenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

lateinit var nomeEditText : EditText
lateinit var nota1EditText : EditText
lateinit var nota2EditText : EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)


        calcular.setOnClickListener {
            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)
            nomeEditText = findViewById(R.id.nome)

            val resultado = findViewById<TextView>(R.id.resultado)



            if (validarCampo()) {
                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()


                val media = calcularMedia(nota1, nota2)

                resultado.text = situacaoAluno(media)
            }


        }

        sair.setOnClickListener {
            finish()
        }
    }




    private fun validarCampo(): Boolean {
        var noError = true

        if (nomeEditText.text.isBlank()) {
            nomeEditText.setError("digite seu nome")
            noError = false
        }
        if (nota1EditText.text.isBlank()) {
            nota1EditText.setError("Digite sua nota 1")
            noError = false
        }

        if (nota2EditText.text.isBlank()) {
            nota2EditText.setError("Digite sua nota 2")
            noError = false
        }
        return noError
    }
}
