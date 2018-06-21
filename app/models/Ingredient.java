package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient
{
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ingredientId;
    private String ingredientName;
    private int recipeId;
    private int amountId;
    private int measurementId;

    public int getIngredientId()
    {
        return ingredientId;
    }

    public String getIngredientName()
    {
        return ingredientName;
    }

    public void setIngredientId(int ingredientId)
    {
        this.ingredientId = ingredientId;
    }

    public void setIngredientName(String ingredientName)
    {
        this.ingredientName = ingredientName;
    }

    public int getRecipeId()
    {
        return recipeId;
    }

    public void setRecipeId(int recipeId)
    {
        this.recipeId = recipeId;
    }

    public int getAmountId()
    {
        return amountId;
    }

    public void setAmountId(int amountId)
    {
        this.amountId = amountId;
    }

    public int getMeasurementId()
    {
        return measurementId;
    }

    public void setMeasurementId(int measurementId)
    {
        this.measurementId = measurementId;
    }
}
