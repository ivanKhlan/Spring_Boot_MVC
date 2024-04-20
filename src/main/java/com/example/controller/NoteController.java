package com.example.controller;

import com.example.note.Note;
import com.example.storage.InMemoryNoteStorage;
import com.example.storage.NoteStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NoteController {

    private NoteStorage noteStorage;

    public NoteController() {
        noteStorage = new InMemoryNoteStorage();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ModelAndView getAllNotes() {

        ModelAndView result = new ModelAndView("test");

        result.addObject("notes", noteStorage.getAllNotes());
        return result;
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") int id) {
        noteStorage.deleteById(id);
        return "redirect:/note/list";
    }

    @PostMapping("/add")
    public String addNote(@RequestParam("title") String title, @RequestParam("content") String content) {
        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setContent(content);

        noteStorage.addNote(newNote);

        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public ModelAndView editNoteForm(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("test");
        Note note = noteStorage.getNoteById(id);
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute("note") Note note) {
        noteStorage.addUpdateNote(note);
        return "redirect:/note/list";
    }

}
