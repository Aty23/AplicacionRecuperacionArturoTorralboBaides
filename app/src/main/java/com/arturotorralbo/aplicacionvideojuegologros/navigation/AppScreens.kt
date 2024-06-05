package com.arturotorralbo.aplicacionvideojuegologros.navigation

sealed class AppScreens(val route: String) {
    object LoginScreen: AppScreens("login_screen")
    object HomeScreen: AppScreens("home_screen")
    object CreateArchivementsScreen: AppScreens("create_archivements_screen")
}