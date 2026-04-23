package pe.edu.idat.appantunezHector.retrofit

import pe.edu.idat.appantunezHector.retrofit.api.ProductoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClienteRetrofit {

    private const val BASE_URL = "https://dummyjson.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val productoApi: ProductoApi = retrofit.create(ProductoApi::class.java)
}