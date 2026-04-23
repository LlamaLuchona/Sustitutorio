package pe.edu.idat.appantunezHector.retrofit.api

import pe.edu.idat.appantunezHector.model.Producto
import retrofit2.http.GET

data class ProductoResponse(
    val products: List<Producto>
)

interface ProductoApi {
    @GET("products")
    suspend fun getProductos(): ProductoResponse
}