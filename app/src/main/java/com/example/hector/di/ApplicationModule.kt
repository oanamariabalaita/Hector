package com.example.hector.di

import dagger.Module
import android.app.Application
import android.content.Context
import androidx.room.Room.*
import com.example.hector.BuildConfig
import com.example.hector.annotations.ApiKeyInfo
import com.example.hector.annotations.PreferenceInfo
import com.example.hector.data.local.AppDatabase
import com.example.hector.data.local.healthIndicators.HealthIndicatorsRepo
import com.example.hector.data.local.healthIndicators.HealthIndicatorsRepository
import com.example.hector.data.local.notifications.NotificationsRepo
import com.example.hector.data.local.notifications.NotificationsRepository
import com.example.hector.api.ApiHeader
import com.example.hector.api.ApiHelper
import com.example.hector.api.AppApiHelper
import com.example.hector.data.local.users.UsersLocalRepo
import com.example.hector.data.local.users.UsersLocalRepository
import com.example.hector.data.preferences.AppPreferenceHelper
import com.example.hector.data.preferences.PreferenceHelper
import com.example.hector.utils.AppConstants
import com.example.hector.utils.SchedulerProvider
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@SuppressWarnings("TooManyFunctions")
@Module
class ApplicationModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    //Mock value !!!
    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = BuildConfig.APPLICATION_ID

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
    @Singleton
    internal fun UsersRepoHelper(appDatabase: AppDatabase): UsersLocalRepo =
        UsersLocalRepository(appDatabase.usersDao())

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()
}