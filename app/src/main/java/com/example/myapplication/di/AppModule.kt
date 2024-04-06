package com.example.myapplication.di

import com.example.myapplication.data.ProductRepositoryImpl
import com.example.myapplication.domain.ProductRepository
import com.example.myapplication.network.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://wi-and-project.free.beeceptor.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesAPIService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

    @Provides
    fun providesProductRepository(apiService: APIService): ProductRepository {
        return ProductRepositoryImpl(apiService)
    }
}