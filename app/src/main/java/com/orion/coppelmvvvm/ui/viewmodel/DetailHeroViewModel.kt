package com.orion.coppelmvvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orion.coppelmvvvm.domain.GetDetailHeroUseCase
import com.orion.coppelmvvvm.domain.model.DetailHero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailHeroViewModel@Inject constructor(
    private val getDetailHeroUseCase : GetDetailHeroUseCase
): ViewModel() {
    val isNetworkAvailable = MutableLiveData<Boolean>()
    val detailHero = MutableLiveData<DetailHero>()



    fun onCreate(id:Int){
        viewModelScope.launch {
            var  result:DetailHero?
            if (isNetworkAvailable.value == true) {
                result = getDetailHeroUseCase(id = id)
                detailHero.postValue(result!!)

            }
        }

    }
}