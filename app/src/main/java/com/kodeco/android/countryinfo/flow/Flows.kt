package com.kodeco.android.countryinfo.flow

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

object Flows{
    private val tapFlow= MutableStateFlow(0)
    val mutableTapFlow: StateFlow<Int> = tapFlow

    private val backFlow= MutableStateFlow(0)
    val mutableBackFlow: StateFlow<Int> = backFlow

    private val counterFlow= MutableStateFlow(0)
    val mutableCounterFlow: StateFlow<Int> = counterFlow

    private val combineFlow= MutableStateFlow(0)
    val mutableCombineFlow: StateFlow<Int> = combineFlow

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
    /*
        I created a total flow which basically shows a total of both tap and back flow. Based on my understanding,
        the total flow should emit if either tap or back flow is fired. But it was not working for me
     */
    fun combineFlow(){
        tapFlow.zip(backFlow){tap,back->
            tap+back
        }
    }


}

