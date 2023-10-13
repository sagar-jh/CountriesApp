package com.kodeco.android.countryinfo.ui.screens.countryinfo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kodeco.android.countryinfo.flow.Flows
import com.kodeco.android.countryinfo.models.Country
import com.kodeco.android.countryinfo.repositories.CountryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CountryInfoViewModel(val repository: CountryRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<CountryInfoState> = MutableStateFlow(CountryInfoState.Loading)
    val uiState=_uiState.asStateFlow()
    private val counterFlow= MutableStateFlow(0)
    val mutableCounterFlow: StateFlow<Int> = counterFlow

    fun getCountries(): Flow<List<Country>> {
        _uiState.value= CountryInfoState.Loading
        return repository.fetchCountries()
    }
    fun setState(state:CountryInfoState){
        _uiState.value=state
    }

    fun counterFlow(){
        viewModelScope.launch {
            while(true){
                delay(1000)
                counterFlow.value= counterFlow.value+1;
            }
        }

    }


    class CountryInfoViewModelFactory(private val repository: CountryRepository) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            CountryInfoViewModel(repository) as T
    }
}





