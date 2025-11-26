package com.pmdm.tarea2_leonsiria_pedro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

/**
 * Fragmento que muestra el listado de Pikmin en una cuadrícula.
 * Apartado A.
 */
class ListaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Snackbar de bienvenida
        Snackbar.make(view, getString(R.string.welcome_pesado), Snackbar.LENGTH_SHORT).show()

        val pikminList = listOf(
            Pikmin(getString(R.string.name_red), getString(R.string.desc_red), R.drawable.red),
            Pikmin(getString(R.string.name_yellow), getString(R.string.desc_yellow), R.drawable.yellow),
            Pikmin(getString(R.string.name_blue), getString(R.string.desc_blue), R.drawable.blue),
            Pikmin(getString(R.string.name_white), getString(R.string.desc_white), R.drawable.white),
            Pikmin(getString(R.string.name_purple), getString(R.string.desc_purple), R.drawable.purple),
            Pikmin(getString(R.string.name_rock), getString(R.string.desc_rock), R.drawable.rock),
            Pikmin(getString(R.string.name_winged), getString(R.string.desc_winged), R.drawable.winged),
            Pikmin(getString(R.string.name_ice), getString(R.string.desc_ice), R.drawable.ice),
            Pikmin(getString(R.string.name_glow), getString(R.string.desc_glow), R.drawable.glow)
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        recyclerView.adapter = PikminAdapter(pikminList) { pikmin ->

            val bundle = bundleOf(
                "pikmin_name" to pikmin.name,
                "pikmin_desc" to pikmin.description,
                "pikmin_image" to pikmin.imageResId
            )

            findNavController().navigate(R.id.action_list_to_detail, bundle)
        }
    }
}