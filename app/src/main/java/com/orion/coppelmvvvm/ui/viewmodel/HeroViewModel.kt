package com.orion.coppelmvvvm.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orion.coppelmvvvm.domain.GetHeroUseCase
import com.orion.coppelmvvvm.domain.GetHeroesUseCase
import com.orion.coppelmvvvm.domain.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor(
            private val getHerosUseCase : GetHeroUseCase,
            private val getHeroesUseCase : GetHeroesUseCase
): ViewModel() {


    val isNetworkAvailable = MutableLiveData<Boolean>()
    val heroModelLst = MutableLiveData<MutableList<Hero>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {



        viewModelScope.launch {
            if(heroModelLst.value?.size == 0 || heroModelLst.value.isNullOrEmpty() ){
                var result:MutableList<Hero> = arrayListOf()
                isLoading.postValue(true)
                if (isNetworkAvailable.value == true) {
                    result = getHerosUseCase()
                }
                if (!result.isNullOrEmpty()){
                    heroModelLst.postValue(result)

                }else{
                    heroModelLst.postValue(arrayListOf())
                }
                isLoading.postValue(false)
            }

        }
    }


    fun onAllCreate(){

            viewModelScope.launch {
                if(heroModelLst.value?.size == 0 || heroModelLst.value.isNullOrEmpty() ) {
                var result: MutableList<Hero> = arrayListOf()
                //isLoading.postValue(true)
                if (isNetworkAvailable.value == true) {
                    result = getHeroesUseCase()
                }
                if (!result.isNullOrEmpty()) {
                    heroModelLst.postValue(result)

                } else {
                    heroModelLst.postValue(arrayListOf())
                }
                //isLoading.postValue(false)
            }
        }

    }




}