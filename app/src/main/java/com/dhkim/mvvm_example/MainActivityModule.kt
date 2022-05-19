package com.dhkim.mvvm_example

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class MainActivityModule {

    @Binds
    abstract fun bindActivity(activity: MainActivity): UserContract.View

    @Binds
    abstract fun bindPresenter(impl: UserPresenter): UserContract.Presenter
}

@InstallIn(ActivityComponent::class)
@Module
object MainActivityModule2 {

    @Provides
    fun bindActivity(activity: Activity): MainActivity {
        return activity as MainActivity
    }
}