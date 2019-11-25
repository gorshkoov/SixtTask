package ru.gorshkov.sixttask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import ru.gorshkov.sixttask.base.TestCoroutineRule
import ru.gorshkov.sixttask.base.TestCoroutinesDispatcher
import ru.gorshkov.sixttask.data.pojo.SixtCar
import ru.gorshkov.sixttask.features.main.MainViewModel
import ru.gorshkov.sixttask.features.main.interactors.CarsInteractor
import ru.gorshkov.sixttask.features.main.repositories.CarsRepository

@RunWith(JUnit4::class)
class SixtTaskTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var mainViewModel: MainViewModel
    @InjectMocks
    private lateinit var carsInteractor: CarsInteractor
    @Mock
    private lateinit var carsRepository: CarsRepository

    @Mock
    private lateinit var carsStateObserver: Observer<List<SixtCar>>
    @Mock
    private lateinit var errorStateObserver: Observer<Int>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel(
            carsInteractor,
            TestCoroutinesDispatcher()
        ).apply {
            carsGetLiveData.observeForever(carsStateObserver)
            errorLiveData.observeForever(errorStateObserver)
        }
    }

    @Test
    fun shouldShowCarsTest() = testCoroutineRule.runBlockingTest {
        val cars = List(1) {
            SixtCar()
        }
        whenever((carsInteractor.getCars())).thenReturn(cars)

        mainViewModel.activityCreated()

        verify(carsStateObserver).onChanged(cars)
    }

    @Test
    fun shouldShowErrorTest() = testCoroutineRule.runBlockingTest {
        whenever((carsInteractor.getCars())).thenThrow(Error())

        mainViewModel.activityCreated()

        verify(errorStateObserver).onChanged(R.string.default_error)
    }
}