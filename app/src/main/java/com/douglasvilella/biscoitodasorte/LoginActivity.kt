package com.douglasvilella.biscoitodasorte

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.douglasvilella.biscoitodasorte.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginEntrar.setOnClickListener{
            val email = binding.edtLoginEmail.text.toString().trim().toLowerCase()
            val senha = binding.edtLoginSenha.text.toString().trim()

            if(email.isEmpty()){
                binding.edtLoginEmail.error = "Preencha seu email"
                binding.edtLoginEmail.requestFocus()
            } else if (senha.isEmpty()){
                binding.edtLoginSenha.error = "Por favor, insira sua senha"
                binding.edtLoginSenha.requestFocus()
            } else {
                //Shared prefs
                val sharedPrefs = getSharedPreferences(
                    "cadastro_$email",
                    Context.MODE_PRIVATE
                )

                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")

                if (email == emailPrefs && senha == senhaPrefs){
                    Toast.makeText(this, "Usuário Logado", Toast.LENGTH_LONG).show()

                    //Abrir Main Activity após sucesso de login
                    val mIntent = Intent(this, MainActivity::class.java)

                    startActivity(mIntent)
                    finish()
                } else {
                    Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnLoginCadastrar.setOnClickListener{
            val mIntent = Intent(this, CadastrarActivity::class.java)
            startActivity(mIntent)
        }
    }
}