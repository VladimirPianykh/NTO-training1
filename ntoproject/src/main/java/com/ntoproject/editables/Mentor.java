package com.ntoproject.editables;

import com.futurefactory.core.Data;
import com.futurefactory.editor.EditorEntry;

public class Mentor extends Data.Editable {
    public Mentor() {
        super("Новый преподаватель");
    }

    @EditorEntry(translation = "Ф.И.О.")
    public String name;
}
