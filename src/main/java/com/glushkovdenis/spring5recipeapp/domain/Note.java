package com.glushkovdenis.spring5recipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    public String getRecipeNote() {
        return recipeNotes;
    }

    public void setRecipeNote(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
