package com.arturotorralbo.aplicacionvideojuegologros.dependencyinjection

import com.arturotorralbo.aplicacionvideojuegologros.models.Achivement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl("https://tbddonkzztxfwcwfobmg.supabase.co/rest/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    @Singleton
    @Provides
    fun provideAchivement(retrofit: Retrofit): Achivement = retrofit.create(Achivement::class.java)
}