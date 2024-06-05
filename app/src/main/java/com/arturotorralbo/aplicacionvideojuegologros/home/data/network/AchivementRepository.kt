package com.arturotorralbo.aplicacionvideojuegologros.home.data.network

import com.arturotorralbo.aplicacionvideojuegologros.models.AchivementsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AchivementRepository(
    private val client: AchivementsApi,
) {
    suspend fun doAchivements(id: Int, name: String, description: String, difficulty: String, image: String): Boolean {
        return withContext(Dispatchers.IO) {

            val response = client.getAchivements()

            response.isNotEmpty()
        }
    }

}