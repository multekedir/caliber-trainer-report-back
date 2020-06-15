<<<<<<< HEAD
package com.revature.beans;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;


class AssessmentTest {
	
	Assessment assessment;

    @BeforeEach
    void setUp() {
    	
    	assessment = new Assessment();
    	assessment.setId(5);
    	assessment.setAverage(5.6f);
    	assessment.setScoreWeight(3);
    	assessment.setType("QC_Batch");
    	
    }

    @AfterEach
    void tearDown() {
    	
    	assessment.setId(0);
    	assessment.setAverage(0f);
    	assessment.setScoreWeight(0);
    	assessment.setType("");
    	
    }

    @Test
    @DisplayName("testing get ID method with pre-set value of 5")
    void getId() {
    	
    	int expected = 5;
    	int actual = assessment.getId();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing set ID with a set value of 1")
    void setId() {
    	
    	 assessment.setId(1);
    	 
    	 int expected = 1;
    	 int actual = assessment.getId();
    	 
    	 assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing get scoreWeight with a pre set value of 3")
    void getScoreWeight() {
    	
    	int expected = 3;
    	int actual = assessment.getScoreWeight();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing set scoreWeight with a set value of 9")
    void setScoreWeight() {
    	
    	assessment.setScoreWeight(9);
    	
    	int expected = 9;
    	int actual = assessment.getScoreWeight();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing get Type with a pre set value of QC_Batch ")
    void getType() {
    	
    	String expected = "QC_Batch";
    	String actual = assessment.getType();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing set Type with a value of !QC_Batch ")
    void setType() {
    	
    	assessment.setType("!QC_Batch");
    	
    	String expected = "!QC_Batch";
    	String actual = assessment.getType();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing get Average with pre-set value of 5.6")
    void getAverage() {
    	
    	Float expected = 5.6f;
    	Float actual = assessment.getAverage();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing set Average with value of 6.5")
    void setAverage() {
    	
    	assessment.setAverage(6.5f);
    	
    	Float expected = 6.5f;
    	Float actual = assessment.getAverage();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }
    
   

    
   
	@Test
    void getSkillCategory() {
    	
    	Category category = new Category();
    	
    	category.setId(1);
    	category.setName("JavaScript");
    	
    	ArrayList<Category> expected = new ArrayList<Category>();
    	
    	int actualID = category.getId();
    	String actualName = category.getName();
    	
    	expected.add(category);
    
    	
    	int expectedID = expected.get(0).getId();
    	String expectedName = expected.get(0).getName();
    	
    	assertTrue(expectedID == actualID && expectedName.equals(actualName),
    			"ExpectedID = " + expectedID + "ExpectedName = " + actualName);
    	
    }
//
//    @Test
//    void setSkillCategory() {
//    	
//    	
//    	
//    	
//    }

    
}
=======
package com.revature.beans;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AssessmentTest {
	
	Assessment assessment;

    @BeforeAll
    void setUp() {
    	
    	assessment = new Assessment();
    	assessment.setId(5);
    	assessment.setAverage(5.6f);
    	assessment.setScoreWeight(3);
    	assessment.setType("QC_Batch");
    	
    }

    @AfterEach
    void tearDown() {
    	
    	assessment.setId(0);
    	assessment.setAverage(0f);
    	assessment.setScoreWeight(0);
    	assessment.setType("");
    	
    }

    @Test
    @DisplayName("testing get ID method with pre-set value of 5")
    void getId() {
    	
    	int expected = 5;
    	int actual = assessment.getId();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing set ID with a set value of 1")
    void setId() {
    	
    	 assessment.setId(1);
    	 
    	 int expected = 1;
    	 int actual = assessment.getId();
    	 
    	 assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing get scoreWeight with a pre set value of 3")
    void getScoreWeight() {
    	
    	int expected = 3;
    	int actual = assessment.getScoreWeight();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    	
    }

    @Test
    @DisplayName("testing set scoreWeight with a set value of 9")
    void setScoreWeight() {
    	
    	assessment.setScoreWeight(9);
    	
    	int expected = 9;
    	int actual = assessment.getScoreWeight();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing get Type with a pre set value of QC_Batch ")
    void getType() {
    	
    	String expected = "QC_Batch";
    	String actual = assessment.getType();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing set Type with a value of !QC_Batch ")
    void setType() {
    	
    	assessment.setType("!QC_Batch");
    	
    	String expected = "!QC_Batch";
    	String actual = assessment.getType();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing get Average with pre-set value of 5.6")
    void getAverage() {
    	
    	Float expected = 5.6f;
    	Float actual = assessment.getAverage();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }

    @Test
    @DisplayName("testing set Average with value of 6.5")
    void setAverage() {
    	
    	assessment.setAverage(6.5f);
    	
    	Float expected = 6.5f;
    	Float actual = assessment.getAverage();
    	
    	assertEquals(expected, actual, "Expected = "+ expected + "Actual = " + actual);
    }
    
   
//    @Nested
//    @DisplayName("creating a category class to test get and set category methods")
//    class Category{
//    	
//    	
//    }
    
    @SuppressWarnings("unlikely-arg-type")
	@Test
    void getSkillCategory() {
    	
    	Category category = new Category();
    	
    	category.setId(1);
    	category.setName("JavaScript");
    	
    	ArrayList<Category> expected = new ArrayList<Category>();
    	
    	int actualID = category.getId();
    	String actualName = category.getName();
    	
    	expected.add(category);
    	
    	assertTrue(expected.contains(actualName) && expected.contains(actualID));
    	
    }

    @Test
    void setSkillCategory() {
    	
    	
    }

    
}
>>>>>>> 6ca8219252edf2ffecc7fa9f36588517c030e9fd
