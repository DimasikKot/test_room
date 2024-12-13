package org.koma.room_test.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1
)

abstract class MainDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}