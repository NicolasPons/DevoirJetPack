package com.example.devoir_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.devoir_jetpack.ui.profile.ProfileScreen
import com.example.devoir_jetpack.ui.theme.DevoirjetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevoirjetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        name = "Camille Durand",
                        role = "Développeuse Android junior",
                        description = "Étudiante en informatique, je crée des applications mobiles avec Kotlin et Jetpack Compose.",
                        skills = listOf("Kotlin", "Jetpack Compose", "Git"),
                        contact = "camille.durand@example.com",
                        availability = "Disponible pour un stage",
                        availabilityDescription = "Proposer un stage à Camille Durand",
                        onAvailabilityClick = {
                            // Aucune action pour l'instant : la gestion d'état n'est pas encore au programme.
                        },
                        onContactClick = {
                            // Aucune action pour l'instant : la gestion d'état n'est pas encore au programme.
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}