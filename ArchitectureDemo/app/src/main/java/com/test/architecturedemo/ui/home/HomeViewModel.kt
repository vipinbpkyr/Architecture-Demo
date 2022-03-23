package com.test.architecturedemo.ui.home

import com.test.architecturedemo.domain.MyUseCase
import com.test.architecturedemo.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class UiState(
    val loading: Boolean = false,
    val errorMessage: String = "",
    val items: List<String>? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(private val myUseCase: MyUseCase) : BaseViewModel() {
    private val _uiState = MutableStateFlow(UiState(loading = false))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun getList() {
        _uiState.update {
            it.copy(loading = true)
        }

        executeUseCase("", myUseCase, onSuccess = { lists ->
            _uiState.update {
                it.copy(loading = false, items = lists)
            }
        }, onError = {
            _uiState.update {
                it.copy(loading = false)
            }
        })
    }
}