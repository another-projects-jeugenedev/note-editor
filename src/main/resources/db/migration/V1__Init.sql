CREATE TABLE notes (
    note_id UUID PRIMARY KEY,
    header VARCHAR(55) NOT NULL,
    content VARCHAR(4096) NOT NULL DEFAULT ''
);