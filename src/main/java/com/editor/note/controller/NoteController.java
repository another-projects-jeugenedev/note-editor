package com.editor.note.controller;

import com.editor.note.entity.Note;
import com.editor.note.model.NoteModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteController {
    private final NoteModel noteModel;

    public NoteController(NoteModel noteModel) {
        this.noteModel = noteModel;
    }

    @GetMapping
    public String notes() {
        return "redirect:/notes/1";
    }

    @GetMapping("/{page}")
    public String notes(@PathVariable int page, Model model) {
        model.addAttribute("notes", this.noteModel.getAllNotes(page - 1));
        return "notes";
    }

    @GetMapping("/show/{note}")
    public String note(@PathVariable Note note, Model model) {
        model.addAttribute("note", note);
        return "edit_note";
    }

    @PostMapping
    public String createNote(@ModelAttribute Note note) {
        note = this.noteModel.saveNote(note);
        return "redirect:/notes/show/" + note.getId();
    }

    @PutMapping("/{note}")
    public String editNote(@PathVariable Note note) {
        this.noteModel.saveNote(note);
        return "redirect:/notes/show/" + note.getId();
    }
}