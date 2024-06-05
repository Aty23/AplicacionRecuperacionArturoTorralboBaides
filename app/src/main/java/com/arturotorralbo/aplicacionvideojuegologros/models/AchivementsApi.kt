package com.arturotorralbo.aplicacionvideojuegologros.models

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.from
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface AchivementsApi {
    @GET("achivements")
    suspend fun getAchivements(
        //también he probado con @Header en vez de @Query y tampoco ha funcionado
        @Query("apikey") apiKey: String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRiZGRvbmt6enR4Zndjd2ZvYm1nIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTcwODE5MTgsImV4cCI6MjAzMjY1NzkxOH0.luOlwTRWD9SdIc3G5l3QuV8TYc1kce2zDf0adoio_No",
        @Query("Authorization") authorization: String = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRiZGRvbmt6enR4Zndjd2ZvYm1nIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTcwODE5MTgsImV4cCI6MjAzMjY1NzkxOH0.luOlwTRWD9SdIc3G5l3QuV8TYc1kce2zDf0adoio_No"
    ): List<Achivement>
}

val supabase = createSupabaseClient(
    supabaseUrl = "https://tbddonkzztxfwcwfobmg.supabase.co/rest/v1/",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRiZGRvbmt6enR4Zndjd2ZvYm1nIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTcwODE5MTgsImV4cCI6MjAzMjY1NzkxOH0.luOlwTRWD9SdIc3G5l3QuV8TYc1kce2zDf0adoio_No"

) {}

    suspend fun achivementsList():List<Achivement>{
        return supabase.from("achivements").select().decodeList<Achivement>()
    }






object AchivementsApiFactory {
    fun makeAchivementsApi(): AchivementsApi {
        return Retrofit.Builder()
            .baseUrl("https://tbddonkzztxfwcwfobmg.supabase.co/rest/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AchivementsApi::class.java)
    }
}