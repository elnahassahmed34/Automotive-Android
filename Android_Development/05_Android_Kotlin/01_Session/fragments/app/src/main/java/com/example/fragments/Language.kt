package com.example.fragments

data class Language(var name : String)

object RecyclerRepo{

    fun getLanguages() = listOf<Language>(
        Language("c"),
        Language("c++"),
        Language("Java"),
        Language("Kotlin"),
        Language("Obj C"),
        Language("Swift"),
        Language("Go"),
        Language("C#"),
        Language("Python"),
        Language("Rust"),
    )

}