package com.example.finalticmas
import com.example.finalticmas.MainViewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Test
import org.junit.After
import org.junit.Before
import org.junit.Assert.*
import org.junit.Rule

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)

class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

        @get:Rule
        val instantTaskRule = InstantTaskExecutorRule()
        private val dispatcher = StandardTestDispatcher()

        @Before
        fun setup() {
            Dispatchers.setMain(dispatcher)
            viewModel = MainViewModel()
        }
        @After
        fun tearDown() {
            Dispatchers.resetMain()
        }

        @Test
        fun mainViewModel_CheckInitialValue() = runTest {
            val value = viewModel.comparar.value?.cadena1
            assertEquals(null , value)
         }

        @Test
        fun mainViewModel_TestComparar() = runTest {
            launch {
                viewModel.Compararcadena("1","1")
            }
            advanceUntilIdle()
            val value = viewModel.comparar.value?.resultado
            assertEquals("Iguales",value)

        }
        @Test
        fun mainViewModel_TestCompararDifrentes() = runTest {
            launch {
                viewModel.Compararcadena("r","1")
            }
            advanceUntilIdle()
            val value = viewModel.comparar.value?.resultado
            assertEquals("Diferentes",value)

        }

}