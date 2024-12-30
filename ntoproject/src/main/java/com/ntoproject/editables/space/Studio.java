package com.ntoproject.editables.space;

import com.bpa4j.core.Data;
import com.bpa4j.editor.EditorEntry;

public class Studio extends Data.Editable implements Owner {
    public Studio() {
        super("Новая студия");
    }
    
    @EditorEntry(translation = "Описание")
    public String description;
}
