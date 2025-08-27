package com.example.proyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
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
        val spOperaciones: Spinner = findViewById(R.id.sp_operaciones)

        // CREAREMOS NUESTRO PRIMER ARRAY
        val menuSpOperaciones = listOf("Sumar", "Restar"," Multiplicar", "Dividir")

        // VAMOS A COMPLETAR EL SPINNER OPERACIONES
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            menuSpOperaciones
        )

        spOperaciones.adapter = adapter

        btnCalcular.setOnClickListener {
            var calcN1:Int = numeroUno.text.toString().toIntOrNull() ?: 0
            var calcN2:Int = numeroDos.text.toString().toIntOrNull() ?: 0

            if(spOperaciones.selectedItem == "Sumar"){
                var resultadoOP:Int = OpMatematicas.sumar(calcN1,calcN2)
                txResultado.text = resultadoOP.toString()
            }else if(spOperaciones.selectedItem == "Restar"){
                var resultadoOP:Int = OpMatematicas.restar(calcN1,calcN2)
                txResultado.text = resultadoOP.toString()
            }else if(spOperaciones.selectedItem == "Dividir"){
                var resultadoOP:Int = OpMatematicas.dividir(calcN1,calcN2)
                txResultado.text = resultadoOP.toString()
            }





        }
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}