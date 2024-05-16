package com.arturotorralbo.aplicacionvideojuegologros.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arturotorralbo.aplicacionvideojuegologros.home.presentation.HomeScreen
import com.arturotorralbo.aplicacionvideojuegologros.login.presentation.LoginScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route){
        composable(route=AppScreens.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route=AppScreens.HomeScreen.route){
            HomeScreen(navController)
        }
    }


}