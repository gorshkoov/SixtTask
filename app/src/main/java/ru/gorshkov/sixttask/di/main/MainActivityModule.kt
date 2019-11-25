package ru.gorshkov.sixttask.di.main

import dagger.Binds
import dagger.Module
import ru.gorshkov.sixttask.base.activity.BaseActivity
import ru.gorshkov.sixttask.features.main.MainActivity
import ru.gorshkov.sixttask.features.main.interactors.CarsInteractor
import ru.gorshkov.sixttask.features.main.repositories.CarsRepository
import ru.gorshkov.sixttask.features.main.repositories.CarsRepositoryImpl

@Module(includes = [MainActivityFragmentsModule::class])
abstract class MainActivityModule {
    @Binds
    abstract fun bindBaseActivity(activity: MainActivity): BaseActivity

    @Binds
    abstract fun bindCarsRepository(repository: CarsRepositoryImpl) : CarsRepository
}