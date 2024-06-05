package com.arturotorralbo.aplicacionvideojuegologros.resources

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun IconBack(navController: NavController){
    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back",
        modifier = Modifier
            .clickable { navController.popBackStack() }
            .padding(10.dp)
    )
}
