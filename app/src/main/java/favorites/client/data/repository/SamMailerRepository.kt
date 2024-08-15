package favorites.client.data.repository

import favorites.client.data.models.contact.SamMailerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class SamMailerRepository(private val samMailerApi: SamMailerApi){
    suspend fun submitEmail(email: SamMailerResponse): Response<SamMailerResponse>{
        return withContext(Dispatchers.IO){
            samMailerApi.submitEmail(email)
        }
    }

}

