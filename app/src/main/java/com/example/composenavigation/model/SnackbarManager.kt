package com.example.composenavigation.model

import androidx.annotation.StringRes
import androidx.compose.runtime.currentComposer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.UUID

data class Message(val id: Long, @StringRes val messageId: Int)

//class responsible for managing Snackbar message to show on the screen
object SnackbarManager {

    private val _message: MutableStateFlow<List<Message>> = MutableStateFlow(emptyList())
    val messages: StateFlow<List<Message>> get() = _message.asStateFlow()

    fun showMessage(@StringRes messageTextId: Int) {
        _message.update { currentMessages ->
            currentMessages + Message(
                id = UUID.randomUUID().mostSignificantBits,
                messageId = messageTextId
            )
        }
    }

    fun setMessageShow(messageId: Long) {
        _message.update { currentMessages -> currentMessages.filterNot { it.id == messageId } }
    }
}
