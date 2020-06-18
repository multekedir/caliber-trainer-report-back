package com.revature.tables;

import com.revature.beans.CategoryBatches;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Assess scores by category all batches.
 */
public class AssessScoresByCategoryAllBatches {
	private List<CategoryBatches> categories; //type of assessment: test, verbal, project etc.

    /**
     * Instantiates a new Assess scores by category all batches.
     */
//two constructors
    public AssessScoresByCategoryAllBatches() {
		categories = new ArrayList<>();
	}


    public AssessScoresByCategoryAllBatches(List<CategoryBatches> categories)
    {
    	this.categories = categories;
    }

public List<CategoryBatches> getCategories() {
		return categories;
	}


	public void setCategories(List<CategoryBatches> categories) {
		this.categories = categories;
	}


@Override
	public String toString() {
		return "AssessScoresByCategoryAllBatches [categories=" + categories + "]";
	}
}
