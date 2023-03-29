package com.masai;
import java.util.*;

public class Course {
    private String name;
    private int duration;
    private double fee;
    private String description;
    private List<Course> prerequisites;

    // Constructor
    public Course(String name, int duration, double fee, String description, List<Course> prerequisites) {
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.description = description;
        this.prerequisites = prerequisites;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

	public List<Batch> getBatches() {
		// TODO Auto-generated method stub
		return null;
	}
}

