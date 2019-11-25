package ru.gorshkov.sixttask.di.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.gorshkov.sixttask.di.scopes.FragmentScope
import ru.gorshkov.sixttask.features.list.ListFragment
import ru.gorshkov.sixttask.features.map.MapFragment

@Module
abstract class MainActivityFragmentsModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMapFragment(): MapFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment
}