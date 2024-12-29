package com.ntoproject.editables;

import com.futurefactory.Data;
import com.futurefactory.editor.EditorEntry;

public class MentorEditable extends Data.Editable {
    public MentorEditable() {
        super("Новый преподаватель");
    }

    @EditorEntry(translation = "Ф.И.О.")
    public String name;
}
