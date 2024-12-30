package com.ntoproject.editables;

import java.lang.reflect.Field;
import java.util.function.Supplier;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import com.bpa4j.core.Data;
import com.bpa4j.Wrapper;
import com.bpa4j.editor.EditorEntry;
import com.bpa4j.editor.EditorEntryBase;
import com.ntoproject.editables.space.Center;
import com.ntoproject.editables.space.Owner;
import com.ntoproject.editables.space.Studio;

public class ExhibitionItem extends Data.Editable {
    @EditorEntry(translation = "Владелец", editorBaseSource = OwnerSelector.class)
    public Owner owner;

    public ExhibitionItem() {
        super("Новый экспонат");
    }

    public static class OwnerSelector implements EditorEntryBase {
        @Override
        public JComponent createEditorBase(Object o, Field field, Wrapper<Supplier<?>> wrapper) {
            JComboBox<Owner> c = new JComboBox<>();
            for (Studio s : Data.getInstance().getGroup(Studio.class))
                c.addItem(s);
            c.addItem(Center.getInstance());
            wrapper.var = c::getSelectedItem;
            return c;
        }
    }
}
