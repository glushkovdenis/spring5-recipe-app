package com.glushkovdenis.spring5recipeapp.converts;

import com.glushkovdenis.spring5recipeapp.commands.NoteCommand;
import com.glushkovdenis.spring5recipeapp.domain.Note;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NoteCommandToNote implements Converter<NoteCommand, Note> {

    @Synchronized
    @Nullable
    @Override
    public Note convert(NoteCommand source) {
        if (source == null) {
            return null;
        }

        final Note note = new Note();
        note.setId(source.getId());
        note.setRecipeNotes(source.getRecipeNotes());
        return note;
    }
}
