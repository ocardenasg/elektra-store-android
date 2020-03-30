package mx.com.elektra.store.utils

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import mx.com.elektra.store.interfaces.HttpResponse

class Network(var activity: AppCompatActivity) {

    private fun hasNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo.isAvailable != null && networkInfo.isConnected
    }

    fun httpRequest(context: Context, url: String, httpResponse: HttpResponse) {
        val queue = Volley.newRequestQueue(context)

        if (this.hasNetwork(context)) {
            val request =
                StringRequest(Request.Method.GET, url, Response.Listener { response ->
                    httpResponse.httpResponseSuccess(response)
                }, Response.ErrorListener { error ->
                    Log.d("HTTP_REQUEST_ERROR", error.message)
                    Message.errorMessage(context, Errors.HTTP_ERROR)
                })
            queue.add(request)
        } else {
            Message.errorMessage(context, Errors.NO_NETWORK_CONNECTION)
        }
    }
}