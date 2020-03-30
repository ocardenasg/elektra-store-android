package mx.com.elektra.store.utils

import android.content.Context
import android.widget.Toast

class Message {
    companion object {
        fun errorMessage(context: Context, error: Errors) {
            val message: String = when (error) {
                Errors.NO_NETWORK_CONNECTION -> "No network connection"
                Errors.HTTP_ERROR -> "Error on http request"
                Errors.PERMISSION_DENIED -> "Permission denied"
            }

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}