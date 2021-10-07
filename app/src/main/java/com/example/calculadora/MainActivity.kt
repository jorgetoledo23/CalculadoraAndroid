package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var estado:Boolean = false
    var num1:Int = 0
    var num2:Int = 0
    var operacionPendiente = false
    private lateinit var tvPrincipal:TextView
    private lateinit var tvSecundario:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvPrincipal = binding.tvResultado
        tvSecundario = binding.tvHistory

        //var txtHolaMundo = binding.txtHolaMundo

        var btnCero = binding.btnCero
        var btnUno = binding.btnUno
        var btnDos = binding.btnDos
        var btnTres = binding.btnTres
        var btnCuatro = binding.btnCuatro
        var btnCinco = binding.btnCinco
        var btnSeis = binding.btnSeis
        var btnSiete = binding.btnSiete
        var btnOcho = binding.btnOcho
        var btnNueve = binding.btnNueve




        var btnMas = binding.btnMas
        var btnIgual = binding.btnIgual
        var btnMenos = binding.btnMenos
        var btnDiv = binding.btnDiv
        var btnMult = binding.btnMult

        btnCero.setOnClickListener{ escribirNum(btnCero.text.toString()) }
        btnUno.setOnClickListener{ escribirNum(btnUno.text.toString()) }
        btnDos.setOnClickListener{ escribirNum(btnDos.text.toString()) }
        btnTres.setOnClickListener{ escribirNum(btnTres.text.toString()) }
        btnCuatro.setOnClickListener{ escribirNum(btnCuatro.text.toString()) }
        btnCinco.setOnClickListener{ escribirNum(btnCinco.text.toString()) }
        btnSeis.setOnClickListener{ escribirNum(btnSeis.text.toString()) }
        btnSiete.setOnClickListener{ escribirNum(btnSiete.text.toString()) }
        btnOcho.setOnClickListener{ escribirNum(btnOcho.text.toString()) }
        btnNueve.setOnClickListener{ escribirNum(btnNueve.text.toString()) }







        btnMas.setOnClickListener{ sumar() }
        btnIgual.setOnClickListener{ igual() }
        //btnMenos.setOnClickListener{ mostrarResultado("-") }
        //btnDiv.setOnClickListener{ mostrarResultado("/") }
        //btnMult.setOnClickListener{ mostrarResultado("*") }

    }

    private fun escribirNum(num:String){
        var texto:String = ""
        if (!estado){
             texto = tvPrincipal.text.toString()
        }else{
            estado = false
        }
        tvPrincipal.text = texto + num
    }



    fun sumar(){
        if (!operacionPendiente){
            num1 = tvPrincipal.text.toString().toInt()
            tvPrincipal.text = ""
            tvSecundario.text = num1.toString() + "+"
            operacionPendiente = true
        }else{
            num2 = tvPrincipal.text.toString().toInt()
            tvSecundario.text = tvSecundario.text.toString() + num2.toString()
            tvPrincipal.text = (num1 + num2).toString()
            operacionPendiente = false
        }
    }

    fun igual(){

        if(operacionPendiente){
            num2 = tvPrincipal.text.toString().toInt()
            tvSecundario.text = tvSecundario.text.toString() + num2.toString()
            tvPrincipal.text = (num1 + num2).toString()
            operacionPendiente = false
        }

    }
}