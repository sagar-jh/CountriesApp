package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.flow.Flows
import com.kodeco.android.countryinfo.models.Country
import com.kodeco.android.countryinfo.sample.sampleCountries
import com.kodeco.android.countryinfo.ui.screens.countrydetails.CountryDetailsScreen
import com.kodeco.android.countryinfo.ui.screens.countryinfo.CountryInfoViewModel

@Composable
fun CountryInfoList(
    countries: List<Country>,
    onRefreshClick: () -> Unit,

   // TODO: Utilize this onRefreshClick
) {
    var selectedCountry: Country? by remember { mutableStateOf(null) }
    var tap:Int by remember  {
        mutableStateOf(0)
    }
    var back:Int by remember{
        mutableIntStateOf(0)
    }
    Column {
        // TODO: Implement the Row composable here that contains the
        //  the tap/back flow data and the refresh button.
        FlowCounterRow(onRefreshClick,tap,back)
        selectedCountry?.let { country ->
            CountryDetailsScreen(country) {
                selectedCountry = null
                back=back.inc()
            }
        } ?: run {
            LazyColumn {
                items(countries) { country ->
                    CountryInfoRow(country) {
                        selectedCountry = country
                        tap=tap.inc()

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CountryInfoListPreview() {
   /* CountryInfoList(
        countries = sampleCountries,
        onRefreshClick = {},
    )*/
}
