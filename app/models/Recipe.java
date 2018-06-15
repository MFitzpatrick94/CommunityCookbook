package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe
{
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int recipeId;
    private int categoryId;
    private String recipeName;
    private String author;
    private String cookTime;
   // private String ingredientId;



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

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getCookTime()
    {
        return cookTime;
    }

    public void setCookTime(String cookTime)
    {
        this.cookTime = cookTime;
    }
    /* public String getIngredientId()
    {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId)
    {
        this.ingredientId = ingredientId;
    }*/



}
