package com.editor.note.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "notes")
public class Note {
    @Id
    @Column(name = "note_id")
    private UUID id = UUID.randomUUID();
    private String header, content;

    public Note(String header, String content) {
        this.header = header;
        this.content = content;
    }
}
