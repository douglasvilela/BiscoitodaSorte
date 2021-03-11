package com.douglasvilella.biscoitodasorte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.douglasvilella.biscoitodasorte.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextUInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        /*
        Estou criando um array com as frases sortidas
        * */
        val listaSortida = arrayListOf(
            "A vida trará coisas boas se você tiver paciência",
            "Nao compense na ira, o que lhe falta na razão",
            "Defeitos e virtudes sao apenas dois lados da moeda",
            "Não há que ser forte, há que ser flexível",
            "Siga os bons e aprende com eles",
            "Quem quer colher rosas deve suportar os espinhos",
            "É mais fácil conseguir o perdão do que a permissão",
            "A maior barreira para o sucesso é o medo do fracasso.",
            "O insucesso é apenas uma oportunidade para recomeçar de novo com mais experiência.",
            "Motivação não é sinónimo de transformação, mas um passo em sua direção.",
            "Demonstre amor e alegria em todas as oportunidades e verás que a paz nasce dentro de você",
            "A maior de todas as torres começa no solo.",
            "A juventude não é uma época da vida, é um estado de espírito.",
            "Aquele que se importa com o sentimento dos outros, não é um tolo.",
            "O riso é a menor distância entre duas pessoas.",
            "Surpreender e ser surpreendido é o segredo do amor.",
            "Espere pelo mais sábio dos conselhos: o tempo.",
            "Vencer é 90 por cento suor e 40 por cento técnica.",
            "Deixe de lado as preocupações e seja feliz.",
            "Coragem é a resistência ao medo, domínio do medo, e não a ausência do medo."


        )

        binding.btnBiscoito.setOnClickListener{
            var indice = Random.nextInt(0, listaSortida.lastIndex)
            binding.txvSorteio.text = listaSortida[indice]

            //val alert = AlertDialog.Builder(this@MainActivity)

            //alert.setTitle("BISCOITO DO DIA!")
            //alert.setMessage("$sorteioLista")

            //Definir rótulo do botão e escutando seu click
            //alert.setPositiveButton("Sair") { dialog, which ->
              //  val mIntent = Intent(this, MainActivity::class.java)
              //  startActivity(mIntent)
            //}

            //Definindo o rótulo do botão  e escutando seu click
            //alert.setNeutralButton("Não") {dialog, which ->}
            /* desativa a possibilidade do usuário cancelar a caixa de diálogo
            ao clicar fora da mesma, dessa forma o usuário é obrigado a interagir
            com os botões
             */

           // alert.setCancelable(false)

            //alert.show()

        }

    }
}