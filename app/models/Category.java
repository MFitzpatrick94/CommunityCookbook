package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category
{
    @Id
    private int categoryId;

    private String categoryName;

   /* public Category(int categoryId, String categoryName)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }*/

    public int getCategoryId()
    {
        return categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }
}
