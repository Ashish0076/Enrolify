package com.masai;
import java.util.*;

public class Batch {
	  private String batchName;
	    private Date startDate;
	    private Date endDate;
	    private int availableSeats;
	    private Course course;

	    public Batch(String name, Date startDate, Date endDate, int availableSeats, Course course) {
	        this.batchName = name;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.availableSeats = availableSeats;
	        this.course = course;
	    }

	    // getters and setters

	    public Batch(Course courseToAddBatch, String batchName2) {
			// TODO Auto-generated constructor stub
		}

		public String getBatchName() {
			return batchName;
		}

		public void setBatchName(String batchName) {
			this.batchName = batchName;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public int getAvailableSeats() {
			return availableSeats;
		}

		public void setAvailableSeats(int availableSeats) {
			this.availableSeats = availableSeats;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		public void decreaseAvailableSeats(int count) {
	        availableSeats -= count;
	    }

	    public void increaseAvailableSeats(int count) {
	        availableSeats += count;
	    }

		public Object getName() {
			// TODO Auto-generated method stub
			return null;
		}

	    // other methods
}
