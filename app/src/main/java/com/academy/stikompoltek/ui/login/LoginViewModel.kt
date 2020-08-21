package com.academy.stikompoltek.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.academy.stikompoltek.data.base.BaseViewModel
import com.academy.stikompoltek.utils.viewmodel.SingleLiveEvent
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel() {

    val nrpField = ObservableField<String>()
    private val nrp: String get() = nrpField.get() ?: ""

    val passwordField = ObservableField<String>()
    private val password: String get() = passwordField.get() ?: ""

    val successLogin = SingleLiveEvent<Unit>()
    val errorMessage = MutableLiveData<String>()

    fun login() {
        if (nrp == "12345" && password == "admin12345") successLogin.call()
        else errorMessage.postValue("Bad credentials")
    }
}