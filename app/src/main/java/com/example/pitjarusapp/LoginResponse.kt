package com.example.pitjarusapp

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonPrimitive

data class LoginResponseList(
//    val stores : ArrayList<LoginResponse>,

    val status: String,
    val message: String,
    val store_name: String?,
    val dc_name: String?,
    val address: String?,
    val area_id: String?,


    )
data class LoginResponse(val loginResponses: List<LoginResponseList>)

//fun parseLoginResponse(json: String): LoginResponse {
//    val gson = Gson()
//    val response = gson.fromJson(json, JsonObject::class.java)
//    val status = response.get("status").asString
//    val message = response.get("message").asString
//    val stores = response.getAsJsonArray("stores")
//    val firstStore = stores.get(0).asJsonObject
//    val store_name = firstStore.get("store_name").asString
//    val dc_name = firstStore.get("dc_name").asString
//    val address = firstStore.get("address").asString
//    val area_id = firstStore.get("area_id").asString
//    return LoginResponse(status, message, store_name, dc_name, address, area_id)
//}

fun parseLoginResponse(json: String): LoginResponse {
    val gson = Gson()
    val response = gson.fromJson(json, JsonArray::class.java)
    val loginResponses = response.map {
        val jsonObject = it.asJsonObject
        val status = jsonObject.get("status").asString
        val message = jsonObject.get("message").asString
        val store_name = jsonObject.get("store_name").asString
        val dc_name = jsonObject.get("dc_name").asString
        val address = jsonObject.get("address").asString
        val area_id = jsonObject.get("area_id").asString
        LoginResponseList(status, message, store_name, dc_name, address, area_id)
    }
    return LoginResponse(loginResponses)
}
