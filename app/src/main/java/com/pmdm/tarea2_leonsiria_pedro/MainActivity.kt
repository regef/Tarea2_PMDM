package com.pmdm.tarea2_leonsiria_pedro

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

/**
 * Actividad principal que actúa como contenedor de los fragmentos.
 * Configura la navegación y la Toolbar superior.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar la Toolbar personalizada
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Obtener el NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Unir Toolbar y NavController
        appBarConfiguration = AppBarConfiguration(setOf(R.id.listaFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    /**
     * Maneja la acción de la flecha "Atrás" en la Toolbar.
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    /**
     * Infla el menú de opciones.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    /**
     * Gestiona los clics en el menú.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
                //Acerca de
            R.id.action_acercade -> {
                showAboutDialog()
                true
            }
                //Ajustes
            R.id.action_ajustes -> {
                navController.navigate(R.id.ajustesFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Muestra el diálogo "Acerca de...".
     */
    private fun showAboutDialog() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.about_title))
            .setMessage(getString(R.string.about_message))
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .setIcon(R.mipmap.ic_launcher_round) // Icono de la app
            .show()
    }
}