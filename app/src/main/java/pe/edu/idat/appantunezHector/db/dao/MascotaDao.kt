package pe.edu.idat.appantunezHector.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pe.edu.idat.appantunezHector.db.entity.MascotaEntity

@Dao
interface MascotaDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertar(mascota: MascotaEntity)

    @Query("SELECT * FROM tblhector")
    fun listar(): LiveData<List<MascotaEntity>>

    @Query("SELECT * FROM tblhector WHERE codigo = :codigo")
    suspend fun buscarPorCodigo(codigo: String): MascotaEntity?
}