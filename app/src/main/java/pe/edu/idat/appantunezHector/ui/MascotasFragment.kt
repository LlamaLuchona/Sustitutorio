package pe.edu.idat.appantunezHector.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.appantunezHector.adapter.MascotaAdapter
import pe.edu.idat.appantunezHector.databinding.FragmentMascotasBinding
import pe.edu.idat.appantunezHector.viewmodel.MascotaViewModel

class MascotasFragment : Fragment() {

    private lateinit var binding: FragmentMascotasBinding
    private lateinit var adapter: MascotaAdapter
    private val viewModel: MascotaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMascotasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MascotaAdapter(emptyList())
        binding.rvMascotas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMascotas.adapter = adapter

        viewModel.mascotas.observe(viewLifecycleOwner) { lista ->
            adapter.actualizar(lista)
        }
    }
}