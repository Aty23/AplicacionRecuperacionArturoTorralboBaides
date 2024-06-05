package com.arturotorralbo.aplicacionvideojuegologros.home.data

import com.arturotorralbo.aplicacionvideojuegologros.home.data.network.AchivementService
import javax.inject.Inject

class AchivementRepository @Inject constructor(private val api: AchivementService) {

        suspend fun doAchivements(id: Int, name: String, description: String, difficulty: String, image: String) =
            api.doAchivements(id, name, description, difficulty, image)
    }

