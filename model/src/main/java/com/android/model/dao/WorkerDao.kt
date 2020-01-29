package com.android.model.dao

import androidx.room.*
import com.android.model.Worker
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface WorkerDao {

    @Query("SELECT * FROM worker")
    fun getAll(): Observable<List<Worker>>

    @Query("SELECT * FROM worker WHERE id = :id")
    fun getById(id: Long): Worker

    @Insert
    fun insert(employee: Worker) : Completable

    @Update
    fun update(employee: Worker)

    @Delete
    fun delete(employee: Worker)
}