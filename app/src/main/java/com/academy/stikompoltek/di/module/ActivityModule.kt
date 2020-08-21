package com.academy.stikompoltek.di.module

import com.academy.stikompoltek.ui.home.MainActivity
import com.academy.stikompoltek.di.ActivityScoped
import com.academy.stikompoltek.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity
}