package ru.gorshkov.sixttask.di.main

import dagger.Binds
import dagger.Module
import ru.gorshkov.sixttask.base.BaseActivity
import ru.gorshkov.sixttask.features.main.MainActivity

@Module(includes = [MainActivityFragmentsModule::class])
abstract class MainActivityModule {
    @Binds
    abstract fun bindBaseActivity(activity: MainActivity): BaseActivity
}