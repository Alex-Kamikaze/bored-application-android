package com.alexkarav.boredapplication.domain.viewmodels

import androidx.lifecycle.ViewModel
import com.alexkarav.boredapplication.domain.BoredApplicationRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
* Бизнес логика и состояния экрана со списком занятий
* Здесь используется ViewModel - https://developer.android.com/topic/libraries/architecture/viewmodel
* */
@HiltViewModel
class BoredListViewModel @Inject constructor(repo: BoredApplicationRepositoryImpl): ViewModel() {

}