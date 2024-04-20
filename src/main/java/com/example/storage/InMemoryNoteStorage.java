package com.example.storage;

import com.example.note.Note;

import java.util.*;

public class InMemoryNoteStorage implements NoteStorage {

    private Map<Integer, Note> notes = new HashMap<>();

    @Override
    public List<Note> getAllNotes() {
        return new ArrayList<>(notes.values());
    }

    @Override
    public void addNote(Note note) {
        note.setId(new Random().nextInt());
        notes.put(note.getId(), note);

    }

    @Override
    public void deleteById(int id) {
        notes.remove(id);

    }

    @Override
    public Note getNoteById(int id) {
        return notes.get(id);
    }

    @Override
    public void addUpdateNote(Note note) {
        notes.put(note.getId(), note);
    }
}
