package models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class IngredientMeasurement
{
    @Id
    private int ingredientId;
    private String ingredientName;
    private String measurementName;
    private String amountName;

    public IngredientMeasurement(int ingredientId, String ingredientName, String measurementName, String amountName)
    {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.measurementName = measurementName;
        this.amountName = amountName;
    }

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

    public String getMeasurementName()
    {
        return measurementName;
    }

    public String getAmountName()
    {
        return amountName;
    }
}
