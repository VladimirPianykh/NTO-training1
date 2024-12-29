package com.ntoproject.editables.space;

import com.futurefactory.core.Data;
import com.futurefactory.editor.EditorEntry;

public class CenterSpace extends Data.Editable implements Owner {
    public CenterSpace() {
        super("Новое пространство");
    }

    @EditorEntry(translation = "Название пространства")
    public String spaceName;

    @EditorEntry(translation = "Вместимость")
    public int capacity;

    @EditorEntry(translation = "Описание")
    public String description;

    @Override
    public String getName() {
        return spaceName;
    }
}
