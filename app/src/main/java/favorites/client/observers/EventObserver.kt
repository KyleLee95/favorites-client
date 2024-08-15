package favorites.client.observers

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import favorites.client.data.models.logging.LogEvent
import favorites.client.data.repository.ApiProvider
import favorites.client.data.repository.LoggingServiceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventObserver(private val sessionEmail: String) : DefaultLifecycleObserver {
    private val loggingRepository: LoggingServiceRepository= LoggingServiceRepository(ApiProvider.loggingApi())

    override fun onCreate(owner: LifecycleOwner) {
        Log.i("event", "onCreate")
        logEvent("onCreate")
    }

    override fun onStop(owner: LifecycleOwner) {

        Log.i("event", "onStop")
        logEvent(event = "onStop")
    }

    override fun onStart(owner: LifecycleOwner) {

        Log.i("event", "onStart")
        logEvent(event = "onStart")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        logEvent(event = "onDestroy")
        Log.i("event", "onDestroy")
    }

    override fun onResume(owner: LifecycleOwner) {
        logEvent("onResume")
        Log.i("event", "onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        logEvent("onPause")
        Log.i("event", "onPause")
    }

    private fun logEvent(event: String) {
        val logEvent = LogEvent(sessionEmail, event, System.currentTimeMillis() / 1000)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                loggingRepository.logEvent(logEvent)
            } catch (e: Exception) {
                Log.e("logging-error", e.message ?: "Unknown error occurred when trying to log the event.")
            }
        }
    }

    fun logUserEvent(event: String){
        logEvent(event)
    }
}

