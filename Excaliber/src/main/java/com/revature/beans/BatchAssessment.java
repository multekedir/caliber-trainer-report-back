package com.revature.beans;

import java.util.ArrayList;

//This bean does not need to go into the database. It is only used in the Java code.
public class BatchAssessment {
	private String batchName; //the batches name
	private ArrayList<Float> assessments; //the assessment score for that batch over all weeks
	
	public BatchAssessment()
	{
		batchName = "";
		assessments = new ArrayList<Float>();
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public ArrayList<Float> getAssessments() {
		return assessments;
	}

	public void setAssessments(ArrayList<Float> assessments) {
		this.assessments = assessments;
	}

	@Override
	public String toString() {
		return "BatchAssessment [batchName=" + batchName + ", assessments=" + assessments + "]";
	}
}
