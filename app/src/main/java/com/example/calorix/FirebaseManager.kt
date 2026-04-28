package com.example.calorix

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await

data class UserProfile(
    val uid: String = "",
    val name: String = "",
    val email: String = ""
)

object FirebaseManager {
    private const val TAG = "FirebaseManager"
    private val db: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    
    private val productsCollection = db.collection("products")
    private val usersCollection = db.collection("users")

    // --- Authentication ---
    
    suspend fun signUp(email: String, name: String, password: String): Boolean {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val user = result.user
            if (user != null) {
                // Update profile with name
                val profileUpdates = userProfileChangeRequest {
                    displayName = name
                }
                user.updateProfile(profileUpdates).await()
                
                // Save additional info to Firestore
                saveUserProfile(UserProfile(uid = user.uid, name = name, email = email))
                true
            } else false
        } catch (e: Exception) {
            Log.e(TAG, "Sign up error", e)
            false
        }
    }

    suspend fun signIn(email: String, password: String): Boolean {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            Log.e(TAG, "Sign in error", e)
            false
        }
    }

    private suspend fun saveUserProfile(profile: UserProfile) {
        try {
            usersCollection.document(profile.uid).set(profile).await()
            Log.d(TAG, "User profile saved for: ${profile.email}")
        } catch (e: Exception) {
            Log.e(TAG, "Error saving user profile", e)
        }
    }

    fun getCurrentUser() = auth.currentUser

    fun logout() {
        auth.signOut()
    }

    // --- Product Search ---
    
    suspend fun searchProducts(query: String): List<FoodProduct> {
        if (query.isBlank()) return emptyList()
        val lowercaseQuery = query.lowercase()
        Log.d(TAG, "Searching for: $lowercaseQuery")
        
        return try {
            val result: QuerySnapshot = productsCollection
                .orderBy("searchName")
                .startAt(lowercaseQuery)
                .endAt(lowercaseQuery + "\uf8ff")
                .get()
                .await()
            
            val products = result.toObjects(FoodProduct::class.java)
            Log.d(TAG, "Found ${products.size} products")
            products
        } catch (e: Exception) {
            Log.e(TAG, "Error searching products", e)
            emptyList()
        }
    }

    suspend fun getAllProducts(): List<FoodProduct> {
        return try {
            val result: QuerySnapshot = productsCollection.get().await()
            result.toObjects(FoodProduct::class.java)
        } catch (e: Exception) {
            Log.e(TAG, "Error getting all products", e)
            emptyList()
        }
    }

    suspend fun addProduct(product: FoodProduct) {
        try {
            val docRef = productsCollection.document()
            val productWithId = product.copy(
                id = docRef.id,
                searchName = product.name.lowercase()
            )
            docRef.set(productWithId).await()
            Log.d(TAG, "Added product: ${product.name}")
        } catch (e: Exception) {
            Log.e(TAG, "Error adding product", e)
        }
    }
    
    suspend fun seedDatabaseIfEmpty() {
        Log.d(TAG, "Checking if database needs seeding...")
        try {
            val current = productsCollection.limit(1).get().await()
            if (current.isEmpty) {
                Log.d(TAG, "Database is empty, seeding with Estonian products...")
                val initialProducts = listOf(
                    // Puuviljad ja marjad
                    FoodProduct(name = "Banaan", calories = 89, protein = 1.1, carbs = 22.8, fat = 0.3, category = "Puuviljad"),
                    FoodProduct(name = "Õun", calories = 52, protein = 0.3, carbs = 13.8, fat = 0.2, category = "Puuviljad"),
                    FoodProduct(name = "Pirn", calories = 57, protein = 0.4, carbs = 15.0, fat = 0.1, category = "Puuviljad"),
                    FoodProduct(name = "Maasikad", calories = 32, protein = 0.7, carbs = 7.7, fat = 0.3, category = "Marjad"),
                    FoodProduct(name = "Mustikad", calories = 57, protein = 0.7, carbs = 14.0, fat = 0.3, category = "Marjad"),
                    
                    // Köögiviljad
                    FoodProduct(name = "Kartul (keedetud)", calories = 87, protein = 1.9, carbs = 20.0, fat = 0.1, category = "Köögiviljad"),
                    FoodProduct(name = "Porgand", calories = 41, protein = 0.9, carbs = 9.6, fat = 0.2, category = "Köögiviljad"),
                    FoodProduct(name = "Kurk", calories = 15, protein = 0.7, carbs = 3.6, fat = 0.1, category = "Köögiviljad"),
                    FoodProduct(name = "Tomat", calories = 18, protein = 0.9, carbs = 3.9, fat = 0.2, category = "Köögiviljad"),
                    FoodProduct(name = "Sibul", calories = 40, protein = 1.1, carbs = 9.3, fat = 0.1, category = "Köögiviljad"),
                    
                    // Piimatooted ja munad
                    FoodProduct(name = "Muna (suur)", calories = 155, protein = 13.0, carbs = 1.1, fat = 11.0, category = "Muna"),
                    FoodProduct(name = "Piim (2.5%)", calories = 54, protein = 3.3, carbs = 4.8, fat = 2.5, category = "Piimatooted", unit = "100ml"),
                    FoodProduct(name = "Keefir", calories = 52, protein = 3.2, carbs = 4.1, fat = 2.5, category = "Piimatooted", unit = "100ml"),
                    FoodProduct(name = "Hapukoor (20%)", calories = 204, protein = 2.8, carbs = 3.6, fat = 20.0, category = "Piimatooted"),
                    FoodProduct(name = "Kodujuust", calories = 98, protein = 11.0, carbs = 3.4, fat = 4.3, category = "Piimatooted"),
                    FoodProduct(name = "Eesti juust", calories = 340, protein = 25.0, carbs = 0.0, fat = 26.0, category = "Piimatooted"),
                    FoodProduct(name = "Või (82%)", calories = 717, protein = 0.9, carbs = 0.1, fat = 82.0, category = "Piimatooted"),
                    
                    // Liha ja kala
                    FoodProduct(name = "Kanafilee", calories = 165, protein = 31.0, carbs = 0.0, fat = 3.6, category = "Liha"),
                    FoodProduct(name = "Sealiha (taisem)", calories = 242, protein = 27.0, carbs = 0.0, fat = 14.0, category = "Liha"),
                    FoodProduct(name = "Veiseliha", calories = 250, protein = 26.0, carbs = 0.0, fat = 15.0, category = "Liha"),
                    FoodProduct(name = "Lõhefilee", calories = 208, protein = 20.0, carbs = 0.0, fat = 13.0, category = "Kala"),
                    FoodProduct(name = "Suitsuvorst", calories = 350, protein = 15.0, carbs = 1.0, fat = 30.0, category = "Liha"),
                    
                    // Teraviljad ja leib
                    FoodProduct(name = "Rukileib", calories = 259, protein = 6.0, carbs = 48.0, fat = 1.5, category = "Leib"),
                    FoodProduct(name = "Sai", calories = 265, protein = 8.0, carbs = 50.0, fat = 3.0, category = "Leib"),
                    FoodProduct(name = "Täisterakaerahelbed", calories = 360, protein = 13.0, carbs = 58.0, fat = 7.0, category = "Teraviljad"),
                    FoodProduct(name = "Tatar (kuiv)", calories = 343, protein = 13.0, carbs = 71.0, fat = 3.4, category = "Teraviljad"),
                    FoodProduct(name = "Riis (valge)", calories = 130, protein = 2.7, carbs = 28.0, fat = 0.3, category = "Teraviljad"),
                    FoodProduct(name = "Makaronid (keedetud)", calories = 157, protein = 5.8, carbs = 31.0, fat = 0.9, category = "Teraviljad"),
                    
                    // Joogid ja muud
                    FoodProduct(name = "Kohv (must)", calories = 2, protein = 0.1, carbs = 0.0, fat = 0.0, category = "Joogid", unit = "100ml"),
                    FoodProduct(name = "Tee (suhkruta)", calories = 1, protein = 0.0, carbs = 0.2, fat = 0.0, category = "Joogid", unit = "100ml"),
                    FoodProduct(name = "Oliiviõli", calories = 884, protein = 0.0, carbs = 0.0, fat = 100.0, category = "Rasvad", unit = "100ml"),
                    FoodProduct(name = "Suhkur", calories = 387, protein = 0.0, carbs = 100.0, fat = 0.0, category = "Muu"),
                    FoodProduct(name = "Mesi", calories = 304, protein = 0.3, carbs = 82.0, fat = 0.0, category = "Muu")
                )
                initialProducts.forEach { addProduct(it) }
                Log.d(TAG, "Seeding complete!")
            } else {
                Log.d(TAG, "Database already has data, skipping seed.")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error during seeding", e)
        }
    }
}
