package com.test.architecturedemo.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.architecturedemo.domain.BaseUseCase
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    fun <P, R> executeUseCase(param: P,
                                            useCase: BaseUseCase<P, R>,
                                            onSuccess: (R) -> Unit,
                                            onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                onSuccess.invoke(useCase.invoke(param))
            } catch (e: Exception) {
                onError.invoke(e.message ?: "Error occured")
            }
        }
    }
}