package com.example.proyectobase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


// IMPORT PACKAGE CUSTOM ULTIS PARA CALCULAR
import com.example.proyectobase.utils.OpMatematicas

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val numeroUno: EditText = findViewById(R.id.ed_text_uno)
        val numeroDos: EditText = findViewById(R.id.ed_text_dos)
        val txResultado: TextView = findViewById(R.id.tx_resultado)
        val btnCalcular: Button = findViewById(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            var calcN1:Int = numeroUno.text.toString().toIntOrNull() ?: 0
            var calcN2:Int = numeroDos.text.toString().toIntOrNull() ?: 0

            var resultadoOP:Int = OpMatematicas.sumar(calcN1,calcN2)

            txResultado.text = resultadoOP.toString()

        }
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}