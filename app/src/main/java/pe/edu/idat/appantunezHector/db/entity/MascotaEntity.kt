package pe.edu.idat.appantunezHector.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblhector")
data class MascotaEntity(
    @PrimaryKey
    val codigo: String,
    val nombre: String,
    val tipo: String,
    val edad: Int
)