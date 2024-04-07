package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.data.UserRepositoryImpl
import com.example.myapplication.domain.UserRepository
import com.example.myapplication.network.APIService
import com.example.room.AppDatabase
import com.example.room.UserDao
import com.example.room.UserStateProfileDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesAPIService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }

    @Singleton
    @Provides
    fun providesUserDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providesUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    fun providesUserStateProfileDao(appDatabase: AppDatabase): UserStateProfileDao {
        return appDatabase.userStateProfileDao()
    }

    @Provides
    fun providesUserRepository(
        apiService: APIService,
        userDao: UserDao,
        userStateProfileDao: UserStateProfileDao
    ): UserRepository {
        return UserRepositoryImpl(apiService, userDao, userStateProfileDao)
    }

}