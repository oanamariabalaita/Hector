package com.example.hector.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.hector.BuildConfig
import com.example.hector.data.database.AppDatabase
import com.example.hector.data.database.healthIndicators.HealthIndicatorsRepo
import com.example.hector.data.database.healthIndicators.HealthIndicatorsRepository
import com.example.hector.data.database.notifications.NotificationsRepo
import com.example.hector.data.database.notifications.NotificationsRepository
import com.example.hector.data.preferences.AppPreferenceHelper
import com.example.hector.data.preferences.PreferenceHelper
import com.example.hector.di.ApiKeyInfo
import com.example.hector.di.PreferenceInfo
import com.example.hector.utils.AppConstants
import com.example.hector.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper


    internal fun provideHealthIndicatorsRepoHelper(appDatabase: AppDatabase): HealthIndicatorsRepo = HealthIndicatorsRepository(appDatabase.healthIndicatorDao())

    @Provides
    @Singleton
    internal fun provideNotificationsRepoHelper(appDatabase: AppDatabase): NotificationsRepo = NotificationsRepository (appDatabase.notificationsDao())

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

}