package com.kodeco.android.countryinfo.repositories

import com.kodeco.android.countryinfo.models.Country
import com.kodeco.android.countryinfo.network.CountryService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CountryRepositoryImpl(private val apiService: CountryService):CountryRepository {
    lateinit private var countries: List<Country>
    override fun fetchCountries(): Flow<List<Country>> {
        var countryFLow: Flow<List<Country>> = flow {
            //val res=retrofitService.getCountries().body() ?: listOf<Country>()
            val countriesResponse = apiService.getAllCountries()
            if (countriesResponse.isSuccessful) {
                emit(countriesResponse.body()!!)
                countries=countriesResponse.body()!!
            }

        }
        return countryFLow
    }

    override fun getCountry(index: Int): Country? {
        if(this::countries.isInitialized){
            if(index>-1 && index<countries.size){
                return countries[index]
            }
        }
        return null
    }
}
