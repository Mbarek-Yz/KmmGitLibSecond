package com.example.kmmgitlib

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform