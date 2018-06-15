package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Directions
{
    @Id
    private int directionId;
    private String step;
    private int stepNumber;
    private int recipeId;

    public int getDirectionId()
    {
        return directionId;
    }

    public void setDirectionId(int directionId)
    {
        this.directionId = directionId;
    }

    public String getStep()
    {
        return step;
    }

    public void setStep(String step)
    {
        this.step = step;
    }

    public int getStepNumber()
    {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber)
    {
        this.stepNumber = stepNumber;
    }

    public int getRecipeId()
    {
        return recipeId;
    }

    public void setRecipeId(int recipeId)
    {
        this.recipeId = recipeId;
    }
}
