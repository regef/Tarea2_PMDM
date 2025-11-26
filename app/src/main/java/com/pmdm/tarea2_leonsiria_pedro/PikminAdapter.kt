package com.pmdm.tarea2_leonsiria_pedro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adaptador para el RecyclerView que gestiona la lista de Pikmin.
 *
 * @property pikminList Lista de objetos Pikmin a mostrar.
 * @property onItemClick Función lambda que se ejecuta al pulsar un elemento.
 */
class PikminAdapter(
    private val pikminList: List<Pikmin>,
    private val onItemClick: (Pikmin) -> Unit
) : RecyclerView.Adapter<PikminAdapter.PikminViewHolder>() {

    /**
     * ViewHolder que mantiene las referencias a las vistas de cada elemento.
     *
     * @param view La vista raíz del layout del elemento.
     */
    class PikminViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivImage: ImageView = view.findViewById(R.id.itPikminImagen)
        val tvName: TextView = view.findViewById(R.id.itPikminNombre)
    }

    /**
     * Crea una nueva instancia de ViewHolder.
     *
     * @param parent El ViewGroup padre.
     * @param viewType El tipo de vista.
     * @return Un nuevo PikminViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PikminViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pikmin, parent, false)
        return PikminViewHolder(view)
    }

    /**
     * Vincula los datos de un Pikmin con las vistas del ViewHolder.
     *
     * @param holder El ViewHolder a actualizar.
     * @param position La posición del elemento en la lista.
     */
    override fun onBindViewHolder(holder: PikminViewHolder, position: Int) {
        val pikmin = pikminList[position]
        holder.tvName.text = pikmin.name
        holder.ivImage.setImageResource(pikmin.imageResId)

        // Configurar el clic en la tarjeta
        holder.itemView.setOnClickListener {
            onItemClick(pikmin)
        }
    }

    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return El tamaño de la lista.
     */
    override fun getItemCount() = pikminList.size
}