package com.academy.stikompoltek.di.module

import com.academy.stikompoltek.di.FragmentScoped
import com.academy.stikompoltek.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}