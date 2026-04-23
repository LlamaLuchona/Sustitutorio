package pe.edu.idat.appantunezHector.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.appantunezHector.databinding.ItemMascotaBinding
import pe.edu.idat.appantunezHector.db.entity.MascotaEntity

class MascotaAdapter(private var lista: List<MascotaEntity>) :
    RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    inner class MascotaViewHolder(private val binding: ItemMascotaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mascota: MascotaEntity) {
            binding.tvCodigo.text = "Código: ${mascota.codigo}"
            binding.tvNombre.text = "Nombre: ${mascota.nombre}"
            binding.tvTipo.text = "Tipo: ${mascota.tipo}"
            binding.tvEdad.text = "Edad: ${mascota.edad} años"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val binding = ItemMascotaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MascotaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount() = lista.size

    fun actualizar(nuevaLista: List<MascotaEntity>) {
        lista = nuevaLista
        notifyDataSetChanged()
    }
}