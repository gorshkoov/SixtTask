package ru.gorshkov.sixttask.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.gorshkov.sixttask.di.scopes.ActivityScope
import ru.gorshkov.sixttask.di.viewmodel.ViewModelFactory
import ru.gorshkov.sixttask.features.main.MainViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun provideMainViewModel(photoViewModel: MainViewModel): ViewModel

    @Binds
    @ActivityScope
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}