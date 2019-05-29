package com.example.hector.ui.main.profile

import com.example.hector.ui.main.profile.interactor.ProfileInteractor
import com.example.hector.ui.main.profile.interactor.ProfileMVPInteractor
import com.example.hector.ui.main.profile.presenter.ProfileMVPPresenter
import com.example.hector.ui.main.profile.presenter.ProfilePresenter
import com.example.hector.ui.main.profile.view.ProfileMVPView
import dagger.Module
import dagger.Provides

@Module
class ProfileFragmentModule {

    @Provides
    internal fun provideProfileInteractor(interactor: ProfileInteractor): ProfileMVPInteractor = interactor

    @Provides
    internal fun provideProfilePresenter(
        presenter: ProfilePresenter<ProfileMVPView,
                ProfileMVPInteractor>
    )
            : ProfileMVPPresenter<ProfileMVPView, ProfileMVPInteractor> = presenter
}