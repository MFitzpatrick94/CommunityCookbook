package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Measurement
{
    @Id
    private int measurementId;
    private String measurementName;

    public int getMeasurementId()
    {
        return measurementId;
    }

    public String getMeasurementName()
    {
        return measurementName;
    }

    public void setMeasurementId(int measurementId)
    {
        this.measurementId = measurementId;
    }

    public void setMeasurementName(String measurementName)
    {
        this.measurementName = measurementName;
    }
}
