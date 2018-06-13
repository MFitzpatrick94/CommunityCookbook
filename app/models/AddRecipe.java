package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddRecipe
{
    @Id
    private int recipeId;
    private int categoryId;
    private String recipeName;
    private String ingredientName;
    private int measurementId;
    private String measurementName;
    private int amountId;
    private String amount;

    public int getRecipeId()
    {
        return recipeId;
    }

    public void setRecipeId(int recipeId)
    {
        this.recipeId = recipeId;
    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getRecipeName()
    {
        return recipeName;
    }

    public void setRecipeName(String recipeName)
    {
        this.recipeName = recipeName;
    }

    public String getIngredientName()
    {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName)
    {
        this.ingredientName = ingredientName;
    }

    public int getMeasurementId()
    {
        return measurementId;
    }

    public void setMeasurementId(int measurementId)
    {
        this.measurementId = measurementId;
    }

    public String getMeasurementName()
    {
        return measurementName;
    }

    public void setMeasurementName(String measurementName)
    {
        this.measurementName = measurementName;
    }

    public int getAmountId()
    {
        return amountId;
    }

    public void setAmountId(int amountId)
    {
        this.amountId = amountId;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }
}
