package pe.edu.idat.appantunezHector

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import pe.edu.idat.appantunezHector.databinding.ActivityMainBinding
import pe.edu.idat.appantunezHector.db.entity.MascotaEntity
import pe.edu.idat.appantunezHector.viewmodel.MascotaViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MascotaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            guardarMascota()
        }

        binding.btnIngresar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun guardarMascota() {
        val codigo = binding.etCodigo.text.toString().trim()
        val nombre = binding.etNombre.text.toString().trim()
        val tipo = binding.etTipo.text.toString().trim()
        val edadStr = binding.etEdad.text.toString().trim()

        // Validaciones
        if (codigo.isEmpty() || nombre.isEmpty() || tipo.isEmpty() || edadStr.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return
        }

        val edad = edadStr.toInt()
        if (edad <= 0) {
            Toast.makeText(this, "La edad debe ser mayor a 0", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            val existe = viewModel.buscarPorCodigo(codigo)
            if (existe != null) {
                runOnUiThread {
                    Toast.makeText(this@MainActivity, "El código ya existe", Toast.LENGTH_SHORT).show()
                }
                return@launch
            }

            val mascota = MascotaEntity(codigo, nombre, tipo, edad)
            viewModel.insertar(mascota)

            runOnUiThread {
                Toast.makeText(this@MainActivity, "Mascota guardada correctamente", Toast.LENGTH_SHORT).show()
                limpiarCampos()
            }
        }
    }

    private fun limpiarCampos() {
        binding.etCodigo.text.clear()
        binding.etNombre.text.clear()
        binding.etTipo.text.clear()
        binding.etEdad.text.clear()
    }
}