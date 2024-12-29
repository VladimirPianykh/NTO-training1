package com.ntoproject.editables;

import java.lang.reflect.Field;
import java.util.function.Supplier;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import com.futurefactory.core.Data;
import com.futurefactory.Wrapper;
import com.futurefactory.editor.EditorEntry;
import com.futurefactory.editor.EditorEntryBase;
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
