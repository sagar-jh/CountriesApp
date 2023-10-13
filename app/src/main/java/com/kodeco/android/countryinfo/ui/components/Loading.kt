package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.flow.Flows
import kotlinx.coroutines.flow.StateFlow

@Composable
fun Loading(load:StateFlow<Int>) {
    var counter:Int by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        // TODO: Show the current Flows.counterFlow value here in Text composable
        LaunchedEffect(Unit){
            load.collect{
                counter=it
            }
        }
        Text("Loading...App up: $counter")
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun LoadingPreview() {
    //Loading()
}
