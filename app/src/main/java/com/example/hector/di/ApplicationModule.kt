package com.example.hector.di

import dagger.Module
import android.app.Application
import android.content.Context
import androidx.room.Room.*
import com.example.hector.annotations.ApiKeyInfo
import com.example.hector.annotations.PreferenceInfo
import com.example.hector.data.database.AppDatabase
import com.example.hector.data.database.healthIndicators.HealthIndicatorsRepo
import com.example.hector.data.database.healthIndicators.HealthIndicatorsRepository
import com.example.hector.data.database.notifications.NotificationsRepo
import com.example.hector.data.database.notifications.NotificationsRepository
import com.example.hector.data.network.ApiHeader
import com.example.hector.data.network.ApiHelper
import com.example.hector.data.network.AppApiHelper
import com.example.hector.data.preferences.AppPreferenceHelper
import com.example.hector.data.preferences.PreferenceHelper
import com.example.hector.utils.AppConstants
import com.example.hector.utils.SchedulerProvider
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class ApplicationModule {


    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

//    @Provides
//    @ApiKeyInfo
//    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(apiKey = apiKey,
        userId = preferenceHelper.getCurrentUserId(),
        accessToken = preferenceHelper.getAccessToken())

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun provideHealthIndicatorsRepoHelper(appDatabase: AppDatabase): HealthIndicatorsRepo = HealthIndicatorsRepository(appDatabase.healthIndicatorDao())

    @Provides
    @Singleton
    internal fun provideNotificationsRepoHelper(appDatabase: AppDatabase): NotificationsRepo = NotificationsRepository (appDatabase.notificationsDao())

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()
}