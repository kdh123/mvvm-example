package com.dhkim.mvvm_example

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object API {

    @Singleton
    @Provides
    fun service() : Service = Retrofit.Builder()
                            .baseUrl("https://api.github.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create()

    @Singleton
    @Provides
    fun provideRepository(service:Service) : Repository = RepositoryImpl(service)

}