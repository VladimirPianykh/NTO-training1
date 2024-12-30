package com.ntoproject.editables;

import com.bpa4j.core.Data;
import com.bpa4j.editor.EditorEntry;

public class CenterSpace extends Data.Editable {

    public CenterSpace() {
        super("Новое пространство");
    }

    @EditorEntry(translation = "Вместимость")
    public int capacity;

    @EditorEntry(translation = "Описание")
    public String description;
}
