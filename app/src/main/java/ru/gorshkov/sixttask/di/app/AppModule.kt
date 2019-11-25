package ru.gorshkov.sixttask.di.app

import android.app.Application
import android.content.Context
import ru.gorshkov.sixttask.di.main.MainActivityModule
import ru.gorshkov.sixttask.di.viewmodel.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import ru.gorshkov.sixttask.base.coroutines.CoroutinesDispatcher
import ru.gorshkov.sixttask.base.coroutines.DefaultCoroutinesDispatcher
import ru.gorshkov.sixttask.features.main.MainActivity
import ru.gorshkov.sixttask.di.scopes.ActivityScope

@Module(includes = [AndroidInjectionModule::class, NetworkModule::class])
abstract class AppModule {
    @Binds
    abstract fun bindBaseContext(app : Application) : Context

    @Binds
    abstract fun bindCoroutinesDispatchers(coroutinesDispatcher: DefaultCoroutinesDispatcher) : CoroutinesDispatcher

    @ContributesAndroidInjector(modules = [ViewModelModule::class, MainActivityModule::class])
    @ActivityScope
    abstract fun contributeMainActivity(): MainActivity
}