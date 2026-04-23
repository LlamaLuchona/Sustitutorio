package pe.edu.idat.appantunezHector.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.idat.appantunezHector.db.dao.MascotaDao
import pe.edu.idat.appantunezHector.db.entity.MascotaEntity

@Database(entities = [MascotaEntity::class], version = 1)
abstract class MascotaDatabase : RoomDatabase() {

    abstract fun mascotaDao(): MascotaDao

    companion object {
        @Volatile
        private var INSTANCE: MascotaDatabase? = null

        fun getDatabase(context: Context): MascotaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MascotaDatabase::class.java,
                    "bdsm74243982"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}