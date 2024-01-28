package com.kamath.bookdigest.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kamath.bookdigest.data.model.User

//@Dao
//interface UserDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUser(user: User)
//
//    @Query("SELECT * FROM users WHERE id = :userId")
//    suspend fun getUserById(userId: String): User?
//}