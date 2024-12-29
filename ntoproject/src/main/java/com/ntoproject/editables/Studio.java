package com.ntoproject.editables;

import com.futurefactory.Data;
import com.futurefactory.editor.EditorEntry;

public class Studio extends Data.Editable {
    public Studio() {
        super("Новая студия");
    }

    @EditorEntry(translation = "Название")
    public String name;

    @EditorEntry(translation = "Описание")
    public String description;
}
