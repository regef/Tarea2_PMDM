package com.pmdm.tarea2_leonsiria_pedro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast

/**
 * Fragmento que muestra el detalle completo de un Pikmin seleccionado.
 * Apartado B del enunciado.
 */
class PaginapikFragment : Fragment() {

    /**
     * Infla el diseño del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.paginapik_detalles, container, false)
    }

    /**
     * Se ejecuta al crear la vista. Recupera los argumentos pasados desde la lista.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recuperar datos del Bundle (argumentos)
        val name = arguments?.getString("pikmin_name")
        val description = arguments?.getString("pikmin_desc")
        val imageResId = arguments?.getInt("pikmin_image")

        if(name!=null){
            val mensaje = getString(R.string.toast_selected, name)
            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
        }

        // Referencias a las vistas
        val ivImage = view.findViewById<ImageView>(R.id.LaImagen)
        val tvName = view.findViewById<TextView>(R.id.ElNombrePik)
        val tvDesc = view.findViewById<TextView>(R.id.LaDescripcionPik)

        // Asignar valores
        tvName.text = name
        tvDesc.text = description
        if (imageResId != null) {
            ivImage.setImageResource(imageResId)
        }
    }
}