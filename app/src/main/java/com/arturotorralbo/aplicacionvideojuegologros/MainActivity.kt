package com.arturotorralbo.aplicacionvideojuegologros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.arturotorralbo.aplicacionvideojuegologros.models.achivementsList
import com.arturotorralbo.aplicacionvideojuegologros.navigation.AppNavigation
import com.arturotorralbo.aplicacionvideojuegologros.ui.theme.AplicacionVideojuegoLogrosTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            val achivements = achivementsList()

        }
        setContent {
            AplicacionVideojuegoLogrosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    AplicacionVideojuegoLogrosTheme {
        AppNavigation()
    }
}