package com.example.app

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyRepository @Inject constructor() {

    val text = "It works!"
}
