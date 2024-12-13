package org.koma.room_test

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koma.room_test.database.MainDatabase
import org.koma.room_test.ui.UiNote
import org.koma.room_test.ui.UiNoteUpsert

@Composable
fun App(mainDatabase: MainDatabase) {
    MaterialTheme {
        val notes by mainDatabase.noteDao().getAllNote().collectAsState(initial = emptyList())
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                UiNoteUpsert(noteDao = mainDatabase.noteDao())
            }
            items(notes) {note ->
                UiNote(
                    noteDao = mainDatabase.noteDao(),
                    it = note
                )
            }
        }
    }
}

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform