package com.example.listview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.databinding.ActivityComidaDetailBinding
import com.squareup.picasso.Picasso

class ComidaDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComidaDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComidaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("TITLE")
        val description = intent.getStringExtra("DESCRIPTION")
        val image = intent.getStringExtra("PICTURE")
        val pais = intent.getStringExtra("COUNTRY")

        binding.comidaTitle.text = title
        binding.comidaPais.text = pais
        binding.comidaDesc.text = description
        binding.btnComp.setOnClickListener { shareText(description) }

        Picasso.get().load(image).into(binding.comidaFoto)

        fun closeDialog(view: View){
            finish()
        }


    }
    fun shareText(text: String?){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(sendIntent, "Compartir con"))
    }
}