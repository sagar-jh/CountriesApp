package com.kodeco.android.countryinfo.flow

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

object Flows{
    private val tapFlow= MutableStateFlow(0)
    val mutableTapFlow: StateFlow<Int> = tapFlow

    private val backFlow= MutableStateFlow(0)
    val mutableBackFlow: StateFlow<Int> = backFlow

    private val counterFlow= MutableStateFlow(0)
    val mutableCounterFlow: StateFlow<Int> = counterFlow

    fun updateTap(){
        tapFlow.value= tapFlow.value+1
    }

    fun updateBackFlow(){
        backFlow.value= backFlow.value+1

    }

    fun counterFlow(){
        GlobalScope.launch {
            while(true){
                delay(1000)
                counterFlow.value= counterFlow.value+1;
            }
        }

    }
}

