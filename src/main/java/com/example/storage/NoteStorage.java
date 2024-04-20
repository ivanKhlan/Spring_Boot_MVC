package com.example.storage;

import com.example.note.Note;

import java.util.List;

public interface NoteStorage {

    List<Note> getAllNotes();
    void addNote(Note note);
    void deleteById(int id);
    Note getNoteById(int id);
    void addUpdateNote(Note note);
}
