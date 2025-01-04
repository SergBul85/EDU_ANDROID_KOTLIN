package com.example.notes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NotesApp() {
    var notes by remember { mutableStateOf(listOf<OneNote>()) }
    var showDialogAlert by remember { mutableStateOf(false) }
    var nameNote by remember { mutableStateOf("") }
    var descriptionNote by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        LazyColumn(
            modifier = Modifier.padding(12.dp)
        ) {
            items(notes) {
                NoteView(it, {}, {})
            }
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = { showDialogAlert = true }
            ) {
                Text("+")
            }
        }
    }

    if (showDialogAlert) {
        AlertDialog(
            title = { Text("Add new note") },
            onDismissRequest = {
                showDialogAlert = false
                nameNote = ""
                descriptionNote = ""
            },
            confirmButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        if (nameNote.isNotBlank()) {
                            showDialogAlert = false
                            val newNote = OneNote(notes.size + 1, nameNote, descriptionNote)
                            notes = notes + newNote
                            nameNote = ""
                            descriptionNote = ""
                        }

                    }) {
                        Text(text = "Ok")
                    }
                    Button(onClick = {
                        showDialogAlert = false
                        nameNote = ""
                        descriptionNote = ""

                    }) {
                        Text(text = "Cancel")
                    }
                }
            },
            text = {
                Column {
                    OutlinedTextField(
                        value = nameNote,
                        onValueChange = { nameNote = it },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp)
                    )

                    OutlinedTextField(
                        value = descriptionNote,
                        onValueChange = { descriptionNote = it },
                        minLines = 3,
                        maxLines = 7,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp)
                    )
                }
            }
        )
    }
}

data class OneNote(
    val id: Int,
    var name: String,
    var description: String,
    var isEditing: Boolean = false
)

@Composable
fun NoteView(item: OneNote, onEditClick: () -> Unit, onDeleteClick: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(4.dp).border(
            border = BorderStroke(2.dp, Color.Gray),
            shape = RoundedCornerShape(15)
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(item.name, maxLines = 1)
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text(item.description, maxLines = 4)
        }
    }

}
