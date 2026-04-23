package pe.edu.idat.appantunezHector.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.edu.idat.appantunezHector.db.MascotaDatabase
import pe.edu.idat.appantunezHector.db.entity.MascotaEntity

class MascotaViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = MascotaDatabase.getDatabase(application).mascotaDao()

    val mascotas: LiveData<List<MascotaEntity>> = dao.listar()

    fun insertar(mascota: MascotaEntity) {
        viewModelScope.launch {
            dao.insertar(mascota)
        }
    }

    suspend fun buscarPorCodigo(codigo: String): MascotaEntity? {
        return dao.buscarPorCodigo(codigo)
    }
}