package pe.edu.idat.appantunezHector

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pe.edu.idat.appantunezHector.databinding.ActivityHomeBinding
import pe.edu.idat.appantunezHector.ui.ApiFragment
import pe.edu.idat.appantunezHector.ui.MascotasFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fragment por defecto
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ApiFragment())
            .commit()

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_api -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ApiFragment())
                        .commit()
                    true
                }
                R.id.nav_mascotas -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, MascotasFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}