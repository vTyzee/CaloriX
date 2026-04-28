package com.example.calorix

data class FoodProduct(
    val id: String = "",
    val name: String = "",
    val searchName: String = "", // Lowercase version for case-insensitive search
    val calories: Int = 0,
    val protein: Double = 0.0,
    val carbs: Double = 0.0,
    val fat: Double = 0.0,
    val unit: String = "100g",
    val category: String = ""
)
