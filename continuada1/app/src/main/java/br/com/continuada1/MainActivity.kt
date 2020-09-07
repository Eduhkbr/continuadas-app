package br.com.continuada1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validaCampos(componente: View){
        val aulasPresentes = aulas_freq.text.toString().toDouble()
        val aulasTotais = aulas_totais.text.toString().toDouble()
        var frequencia = 0.0
        var frase = ""

        if(aulasPresentes > aulasTotais){
            frase = "As presenças não podem ser superior ao número de aulas."
        }else if(aulasTotais < 5){
            frase = "O número de aulas não podem ser inferiores a 5"
        }else{
            frequencia = (aulasPresentes*100)/aulasTotais
            frase = "${nome_aluno.text} sua frequência é de ${frequencia}%. "

            if(frequencia >= 70){
                frase += "Você está aprovado!"
                aviso.setTextColor(Color.BLUE)
            }else{
                frase += "Você está reprovado!"
                aviso.setTextColor(Color.RED)
            }

        }

        aviso.text = frase
        aviso.visibility = View.VISIBLE
    }
}