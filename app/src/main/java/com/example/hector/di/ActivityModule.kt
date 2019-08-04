package com.example.hector.di

import com.example.hector.annotations.PerActivity
import com.example.hector.ui.main.profile.interactor.ProfileInteractor
import com.example.hector.ui.main.profile.interactor.ProfileMVPInteractor
import com.example.hector.ui.main.profile.presenter.ProfileMVPPresenter
import com.example.hector.ui.main.profile.presenter.ProfilePresenter
import com.example.hector.ui.main.profile.view.ProfileMVPView
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    @PerActivity
    internal fun provideProfileMVPInteractor(interactor: ProfileInteractor): ProfileMVPInteractor = interactor

    @Provides
    @PerActivity
    internal fun provideProfileMVPPresenter(presenter: ProfilePresenter<ProfileMVPView, ProfileMVPInteractor>): ProfileMVPPresenter<ProfileMVPView, ProfileMVPInteractor> =
        presenter
}