package com.example.hector.data.local.user

import androidx.room.*
import io.reactivex.Observable
import io.reactivex.Single

@Suppress("LongParameterList")
@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM user")
    fun getAll(): Observable<List<User>>

    @Query("SELECT * FROM user WHERE id = :id ")
    fun getUserById(id: Long): User

    @Delete
    fun delete(user: User)

    @Query(
        "UPDATE user SET name =:userName, gender= :userGender,  birthyear =:userBirthYear, " +
                "height = :userHeight, weight=:userWeight, height=:userHeight, " +
                "activity=:userActivityLevel WHERE id = :userId"
    )
    fun update(
        userId: Long,
        userName: String,
        userGender: String,
        userBirthYear: Int,
        userHeight: Float,
        userWeight: Float,
        userActivityLevel: String
    )
}