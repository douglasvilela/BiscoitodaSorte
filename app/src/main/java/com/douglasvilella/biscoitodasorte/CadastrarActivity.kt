package com.douglasvilella.biscoitodasorte

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.douglasvilella.biscoitodasorte.databinding.ActivityCadastrarBinding

class CadastrarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityCadastrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastroCadastrar.setOnClickListener{
            val nome = binding.edtCadastroNome.text.toString().trim()
            val sobrenome = binding.edtCadastroSobrenome.text.toString().trim()
            val email = binding.edtCadastroEmail.text.toString().trim()
            val senha = binding.edtCadastroSenha.text.toString().trim()

            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else {
                val sharedPrefs = getSharedPreferences(
                    "cadastro_$email",
                    Context.MODE_PRIVATE
                ) //Chamando o sharedPrefs


                val editPrefs = sharedPrefs.edit()
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)

                editPrefs.apply()

                Toast.makeText(this, "Usuário Cadastrado", Toast.LENGTH_LONG).show()
                val mIntent = Intent(this, LoginActivity::class.java)

                mIntent.putExtra("INTENT_EMAIL", email)
                startActivity(mIntent)

                finish()
            }
        }
    }
}