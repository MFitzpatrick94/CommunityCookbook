package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Amount
{
    @Id
    private int amountId;
    private String amountName;

    public int getAmountId()
    {
        return amountId;
    }

    public String getAmountName()
    {
        return amountName;
    }
}
