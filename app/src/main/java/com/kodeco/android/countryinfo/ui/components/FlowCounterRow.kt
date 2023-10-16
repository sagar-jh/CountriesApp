package com.kodeco.android.countryinfo.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kodeco.android.countryinfo.flow.Flows
import com.kodeco.android.countryinfo.ui.screens.countryinfo.CountryInfoViewModel

@Composable
fun FlowCounterRow(onRefreshClick: () -> Unit,tap:Int,back:Int) {

    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White)

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.White) ,
            Arrangement.SpaceBetween ,
            Alignment.CenterVertically ,
        ) {
            Text("Taps: $tap", color=Color.Black)
            Button(onClick = {
                onRefreshClick()
            }) {
                Text("Refresh")
            }
            Text("Back: $back",color=Color.Black)



        }
    }
}
