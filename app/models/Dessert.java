package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dessert
{
    @Id
    private int recipeId;
    private String recipeName;

    public Dessert(String recipeName)
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
