package com.example.myapplication.mapper

import com.example.myapplication.model.User
import com.example.myapplication.model.UserDTO
import com.example.myapplication.model.UserStateProfile

fun List<UserDTO>?.mapToUserResult(): List<User> = this?.map {
    User(
        it.gender.orEmpty(),
        it.name?.first?.trim().orEmpty(),
        it.name?.last?.trim().orEmpty(),
        it.location?.city.orEmpty(),
        it.location?.country.orEmpty(),
        it.email.orEmpty(),
        it.dob?.age,
        it.dob?.date.orEmpty(),
        it.phone.orEmpty(),
        it.cell.orEmpty(),
        it.id?.value.orEmpty(),
        it.picture?.thumbnail.orEmpty(),
    )
} ?: emptyList()

fun User.mapToUserStateProfile() = UserStateProfile(
    firstName = this.firstName,
    lastName = this.lastName,
    city = this.city,
    country = this.country,
    email = this.email,
    age = this.age,
    picture = this.picture,
    status = this.status ?: false
)
