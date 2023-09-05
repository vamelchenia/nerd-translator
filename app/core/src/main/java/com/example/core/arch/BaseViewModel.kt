package com.example.core.arch

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

interface ViewState

interface ViewEvent

interface ViewEffect

abstract class BaseViewModel<
        UiState : ViewState,
        Event : ViewEvent,
        Effect : ViewEffect
        > : ViewModel() {

    abstract fun setInitialState(): UiState
    abstract fun onEventReceived(event: Event)

    private val initialState: UiState by lazy {
        setInitialState()
    }

    private val viewState: MutableState<UiState> = mutableStateOf(initialState)

    private val eventFlow: MutableSharedFlow<Event> = MutableSharedFlow()

    private val effectChannel: Channel<Effect> = Channel()
    val currentEffect = effectChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            eventFlow.collect {
                onEventReceived(it)
            }
        }
    }

    protected fun setState(reducer: UiState.() -> UiState) {
        val nextState = getState().value.reducer()
        viewState.value = nextState
    }

    protected fun applyEffect(builder: () -> Effect) {
        val current = builder()
        viewModelScope.launch {
            effectChannel.send(current)
        }
    }

    fun getState(): State<UiState> = viewState

    fun emitEvent(event: Event) {
        viewModelScope.launch {
            eventFlow.emit(event)
        }
    }
}