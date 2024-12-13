package org.koma.room_test.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.koma.room_test.database.MainDatabase
import org.koma.room_test.database.Note
import org.koma.room_test.database.NoteDao

@Composable
fun UiNoteUpsert(modifier: Modifier = Modifier, noteDao: NoteDao) {
    val scope = rememberCoroutineScope()
    var newName by remember { mutableStateOf("") }
    Card(elevation = 8.dp, modifier = modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
            TextField(newName, { newName = it }, Modifier.weight(1f))
            IconButton(
                onClick = {
                    scope.launch {
                        noteDao.upsert(note = Note(newName))
                    }
                },
                modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    }
}