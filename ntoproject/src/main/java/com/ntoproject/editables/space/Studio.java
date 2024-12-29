package com.ntoproject.editables.space;

import com.futurefactory.Data;
import com.futurefactory.editor.EditorEntry;

public class Studio extends Data.Editable implements Owner {
    public Studio() {
        super("Новая студия");
    }

    @EditorEntry(translation = "Описание")
    public String description;
}
