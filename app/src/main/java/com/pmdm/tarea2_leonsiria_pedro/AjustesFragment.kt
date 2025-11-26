package com.pmdm.tarea2_leonsiria_pedro

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.fragment.app.Fragment
import android.widget.Switch
import java.util.Locale

/**
 * Fragmento de ajustes para configurar Idioma y Tema.
 */
class AjustesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ajustes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Usamos SwitchMaterial (el clásico compatible)
        val switchLanguage = view.findViewById<Switch>(R.id.switchIdioma)
        val switchDarkMode = view.findViewById<Switch>(R.id.switchModoOscuro)

        // 1. Configurar estado inicial del TEMA
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        switchDarkMode.isChecked = currentNightMode == Configuration.UI_MODE_NIGHT_YES

        // 2. Configurar estado inicial del IDIOMA
        val appLocales = AppCompatDelegate.getApplicationLocales()
        if (!appLocales.isEmpty) {
            switchLanguage.isChecked = appLocales.toLanguageTags().contains("es")
        } else {
            val systemLocale = Locale.getDefault()
            switchLanguage.isChecked = systemLocale.language == "es"
        }

        // 3. Listeners
        switchLanguage.setOnCheckedChangeListener { _, isChecked ->
            val languageCode = if (isChecked) "es" else "en"
            val appLocale = LocaleListCompat.forLanguageTags(languageCode)
            AppCompatDelegate.setApplicationLocales(appLocale)
        }

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}