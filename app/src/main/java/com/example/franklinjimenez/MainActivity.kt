package com.example.franklinjimenez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
[x] Modelo (data class)
[x] Consumo API (retrofit)
[x] Repositorio
[x] ViewModel
[ ] Fragmento de listado (listing)
[ ] RecyclerView + Adapter + ViewHolder
[ ] Fragmento de detalle (detail)
[ ] Testing unitario para mappers
[ ] Intent implícito para compartir Correo
[ ] Persistencia de datos locales (ROOM)
[ ] Testing para la base de datos
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}