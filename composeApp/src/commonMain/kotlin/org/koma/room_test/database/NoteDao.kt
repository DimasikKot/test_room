package org.koma.room_test.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Upsert
    suspend fun upsert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM Note")
    fun getAllNote(): Flow<List<Note>>

}

@Entity
data class Note(
    val text: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)