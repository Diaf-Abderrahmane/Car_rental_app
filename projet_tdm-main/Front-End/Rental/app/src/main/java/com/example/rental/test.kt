import okhttp3.OkHttpClient
import okhttp3.Request

fun sendGetRequest(url: String): String {
    val client = OkHttpClient()
    val request = Request.Builder().url(url).build()
    val response = client.newCall(request).execute()
    return response.body.string()
}
