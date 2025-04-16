package com.lds.wasm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform