package com.example.hector.ui.main.notifications

import com.example.hector.ui.main.notifications.view.NotificationsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NotificationsFragmentProvider {
    @ContributesAndroidInjector
    abstract internal fun provideNotificationsFragment(): NotificationsFragment
}