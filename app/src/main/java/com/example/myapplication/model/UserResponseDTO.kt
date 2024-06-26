package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class UserResponseDTO(
    @field:SerializedName("results")
    val users: List<UserDTO>? = null,
    @field:SerializedName("info")
    val info: InfoDTO? = null
)

data class UserDTO(
    @field:SerializedName("gender")
    val gender: String? = null,
    @field:SerializedName("name")
    val name: NameDTO? = null,
    @field:SerializedName("location")
    val location: LocationDTO? = null,
    @field:SerializedName("email")
    val email: String? = null,
    @field:SerializedName("login")
    val login: LoginDTO? = null,
    @field:SerializedName("dob")
    val dob: DOBDTO? = null,
    @field:SerializedName("registered")
    val registered: RegisteredDTO? = null,
    @field:SerializedName("phone")
    val phone: String? = null,
    @field:SerializedName("cell")
    val cell: String? = null,
    @field:SerializedName("id")
    val id: IdDTO? = null,
    @field:SerializedName("picture")
    val picture: PictureDTO? = null,
    @field:SerializedName("nat")
    val nat: String? = null
)

data class InfoDTO(
    @field:SerializedName("seed")
    val seed: String? = null,
    @field:SerializedName("results")
    val results: Int? = null,
    @field:SerializedName("page")
    val page: Int? = null,
    @field:SerializedName("version")
    val version: String? = null,
)

data class NameDTO(
    @field:SerializedName("title")
    val title: String? = null,
    @field:SerializedName("first")
    val first: String? = null,
    @field:SerializedName("last")
    val last: String? = null,
)

data class LocationDTO(
    @field:SerializedName("street")
    val street: StreetDTO? = null,
    @field:SerializedName("city")
    val city: String? = null,
    @field:SerializedName("state")
    val state: String? = null,
    @field:SerializedName("country")
    val country: String? = null,
    @field:SerializedName("postcode")
    val postcode: String? = null,
    @field:SerializedName("coordinates")
    val coordinates: CoordinatesDTO? = null,
    @field:SerializedName("timezone")
    val timezone: TimeZoneDTO? = null,
)

data class StreetDTO(
    @field:SerializedName("number")
    val number: Int? = null,
    @field:SerializedName("name")
    val name: String? = null,
)

data class CoordinatesDTO(
    @field:SerializedName("latitude")
    val latitude: String? = null,
    @field:SerializedName("longitude")
    val longitude: String? = null,
)

data class TimeZoneDTO(
    @field:SerializedName("offset")
    val offset: String? = null,
    @field:SerializedName("description")
    val description: String? = null,
)

data class LoginDTO(
    @field:SerializedName("uuid")
    val uuid: String? = null,
    @field:SerializedName("username")
    val username: String? = null,
    @field:SerializedName("password")
    val password: String? = null,
    @field:SerializedName("salt")
    val salt: String? = null,
    @field:SerializedName("md5")
    val md5: String? = null,
    @field:SerializedName("sha1")
    val sha1: String? = null,
    @field:SerializedName("sha256")
    val sha256: String? = null,
)

data class DOBDTO(
    @field:SerializedName("date")
    val date: String? = null,
    @field:SerializedName("age")
    val age: Int? = null,
)

data class RegisteredDTO(
    @field:SerializedName("date")
    val date: String? = null,
    @field:SerializedName("age")
    val age: Int? = null,
)

data class IdDTO(
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("value")
    val value: String? = null,
)

data class PictureDTO(
    @field:SerializedName("large")
    val large: String? = null,
    @field:SerializedName("medium")
    val medium: String? = null,
    @field:SerializedName("thumbnail")
    val thumbnail: String? = null,
)