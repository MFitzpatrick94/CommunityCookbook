package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Appetizer
{
    @Id
    private int recipeId;
    private String recipeName;

    public Appetizer(String recipeName)
    {
        this.recipeName = recipeName;
    }

    public int getRecipeId()
    {
        return recipeId;
    }

    public String getRecipeName()
    {
        return recipeName;
    }
}
