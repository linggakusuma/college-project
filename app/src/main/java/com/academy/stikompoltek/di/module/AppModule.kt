package com.academy.stikompoltek.di.module

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.provider.Settings
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context


    companion object {

        const val NAME = "cache-corvid"

        @Provides
        @Singleton
        fun provideSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
        }

        @Provides
        @Singleton
        fun provideResources(context: Context): Resources = context.resources

        @SuppressLint("MissingPermission", "HardwareIds")
        @Provides
        @Singleton
        @Named("DEVICE_ID")
        fun provideDeviceId(context: Context): String = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID) ?: ""

    }

}
