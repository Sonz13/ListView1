package com.example.listview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listview.databinding.ActivityMainBinding
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var listaComidas: ArrayList<Comidas> = ArrayList()
    lateinit var arrayAdapter: ArrayAdapter<*>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaComidas.add(Comidas("Chilaquiles", "Mexico", "https://patijinich.com/es/wp-content/uploads/sites/3/2017/07/207-chilaquiles-verdes.jpg", "Guiso compuesto de tortillas de maiz, cortadas en triangulos, fritas y cocidas en salsa."))
        listaComidas.add(Comidas("Pie Floater", "Australia", "https://img.100r.systems/img/09d6b8fd86ccba50b8b63539a355d0dd.jpg", "Trozo de carne que flota en una sopa de guisantes acompañada de salsa de tomate."))
        listaComidas.add(Comidas("Cangrejo al Chili", "Singapur", "https://img.100r.systems/img/6ef6fd0d5e17f976e79428c2e008d415.jpg", "Cangrejo con ajo, jengibre, nueces de macadamia, chiles rojos, caldo de pollo, salsa de chili."))
        listaComidas.add(Comidas("Zurek", "Polonia", "https://img.100r.systems/img/8b01511065f454a4cc0c07a535189ced.jpg", "Trozos de carne de cerdo, harina de centeno, huevo y un poquito de nata."))
        listaComidas.add(Comidas("Moros y Cristianos", "Cuba", "https://img.100r.systems/img/47c8029236557db4f4c37bd2310052ec.jpg", "Frijoles negros y arroz que acompaña carnes o guisos."))
        listaComidas.add(Comidas("Jamon de Parma", "Italia", "https://img.100r.systems/img/25e14174826040d1c4eb2bb6f50a2238.jpg", "Un jamon crudo tipico de italia, llamado prosciutto di parma."))
        listaComidas.add(Comidas("Xiaolongbao", "China", "https://img.100r.systems/img/0311119bb9927b0654451522ef5df38a.jpg", "Pequeños panes cocinados al vapor rellenos de carno o algun caldo."))
        listaComidas.add(Comidas("Schweinshaxe", "Alemania", "https://img.100r.systems/img/699f2a2de757aacc5297f83d8e44cedd.jpg", "Codillo de cordero asado acompañado de patatas fritas y mostaza."))
        listaComidas.add(Comidas("Borsch", "Rusia", "https://img.100r.systems/img/3fe3b43d5c2fe37f329ee1456d21e6a9.jpg", "Sopa de verdura con un toque de remolacha de color rosado."))
        listaComidas.add(Comidas("Caldo Verde", "Portugal", "https://img.100r.systems/img/27171e6fe4e1632b3685a1f881948d8b.jpg", "Caldo de col verde rizada, con patatas, ajo, aceite de oliva y algunas esoecias."))


        var adapter = MyAdapter(this, listaComidas)

        binding.listaComidas.adapter = adapter

        binding.listaComidas.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(MainActivity@this, ComidaDetailActivity::class.java).apply{
                putExtra("TITLE", listaComidas[id.toInt()].title)
                putExtra("DESCRIPTION", listaComidas[id.toInt()].description)
                putExtra("PICTURE", listaComidas[id.toInt()].image)
                putExtra("COUNTRY", listaComidas[id.toInt()].pais)
            }
            startActivity(intent)
        }

    }
}