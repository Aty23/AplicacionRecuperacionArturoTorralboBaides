package com.arturotorralbo.aplicacionvideojuegologros.home.data.network

import com.arturotorralbo.aplicacionvideojuegologros.models.AchivementsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AchivementService @Inject constructor(
    private val client: AchivementsApi,
) {
    suspend fun doAchivements(id: Int, name: String, description: String, difficulty: String, image: String): Boolean {
        return withContext(Dispatchers.IO) {

            val response = client.getAchivements()

            response[0].name.isNotEmpty()
        }
    }
}