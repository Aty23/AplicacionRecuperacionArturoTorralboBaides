package com.arturotorralbo.aplicacionvideojuegologros.home.domain

import com.arturotorralbo.aplicacionvideojuegologros.home.data.AchivementRepository

class AchivementsUseCase (
    private val networkRepository: AchivementRepository
){
    suspend operator fun invoke(id: Int, name: String, description: String, difficulty: String, image: String):Boolean=
        networkRepository.doAchivements(id, name, description, difficulty, image)
}