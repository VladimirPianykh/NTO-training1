package com.ntoproject.editables;

import com.futurefactory.Data;
import com.futurefactory.editor.EditorEntry;

public class CenterSpace extends Data.Editable {

    public CenterSpace() {
        super("Новое пространство");
    }

    @EditorEntry(translation = "Вместимость")
    public int capacity;

    @EditorEntry(translation = "Описание")
    public String description;
}
