package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Breakfast
{
    @Id
    private int recipeId;
    private String recipeName;

    public Breakfast(String recipeName)
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
