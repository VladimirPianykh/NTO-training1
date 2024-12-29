package com.ntoproject.editables;

import com.futurefactory.Data;
import com.futurefactory.editor.EditorEntry;
import com.ntoproject.editables.space.Owner;

public class ExhibitionItem extends Data.Editable {
    public ExhibitionItem() {
        super("Новый экспонат");
    }

    @EditorEntry(translation = "Название")
    public String name;

    //@EditorEntry(translation = "Владелец", editorBaseSource = OwnerSelector.class)
    public Owner owner;
/*
    public static class OwnerSelector implements EditorEntryBase {
        public JComponent createEditorBase(Object o, Field f, Wrapper<Runnable> saver){
            JComboBox<WorkArea>c=new JComboBox<>();
            for(Workshop s:Data.getInstance().getGroup(Workshop.class)){
                for(WorkArea w:s.parts)c.addItem(w);
            }
            try{c.setSelectedItem(f.get(o));}catch(IllegalAccessException ex){throw new RuntimeException(ex);}
            saver.var=()->{try{f.set(o,c.getSelectedItem());}catch(IllegalAccessException ex){throw new RuntimeException(ex);}};
            return c;
        }

        @Override
        public JComponent createEditorBase(Object o, Field field, Wrapper<Supplier<?>> wrapper) {
            JComboBox<Owner>c=new JComboBox<>();
            for(CenterSpace s:Data.getInstance().getGroup(CenterSpace.class)){
                for(CenterSpace w:s.parts)c.addItem(w);
            }
        }
    }*/
}
