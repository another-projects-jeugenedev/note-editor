package com.editor.note.model;

import com.editor.note.entity.Note;
import com.editor.note.repository.NoteRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class NoteModel {
    private final NoteRepository noteRepository;

    public NoteModel(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes(int page) {
        return this.noteRepository.findAll(PageRequest.of(page, 6)).getContent();
    }

    public Note saveNote(Note note) {
        return this.noteRepository.save(note);
    }

    public void deleteNote(UUID noteUUID) {
        this.noteRepository.deleteById(noteUUID);
    }
}
