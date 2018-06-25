package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Drink
{
    @Id
    private int recipeId;
    private String recipeName;

    public Drink(String recipeName)
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
