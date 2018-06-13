package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient
{
    @Id
    private int ingredientId;
    private int ingredientName;

    public int getIngredientId()
    {
        return ingredientId;
    }

    public int getIngredientName()
    {
        return ingredientName;
    }
}
