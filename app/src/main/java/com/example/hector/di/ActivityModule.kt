package com.example.hector.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.hector.annotations.ActivityContext
import com.example.hector.ui.main.profile.interactor.ProfileInteractor
import com.example.hector.ui.main.profile.interactor.ProfileMVPInteractor
import com.example.hector.ui.main.profile.presenter.ProfileMVPPresenter
import com.example.hector.ui.main.profile.presenter.ProfilePresenter
import com.example.hector.ui.main.profile.view.ProfileMVPView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule {

    @Provides
    internal fun provideProfileInteractor(interactor: ProfileInteractor): ProfileMVPInteractor = interactor

    @Provides
    internal fun provideProfilePresenter(
        presenter: ProfilePresenter<ProfileMVPView,
                ProfileMVPInteractor>
    ): ProfileMVPPresenter<ProfileMVPView, ProfileMVPInteractor> = presenter
}