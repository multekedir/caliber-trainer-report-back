package com.revature.services;

import com.revature.beans.Batch;
import com.revature.beans.Category;
import com.revature.beans.Trainer;
import com.revature.beans.Week;
import com.revature.tables.TechnicalStatusByWeek;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Technical status by week service.
 */
@Service
public class TechnicalStatusByWeekService {
	/**
	 * The Log.
	 */
	private final Logger log = Logger.getLogger(TechnicalStatusByWeekService.class);
	private final StoreRetrieveService sRSserv;

	/**
	 * Instantiates a new Technical status by week service.
	 *
	 * @param s the s
	 */
	@Autowired
	public TechnicalStatusByWeekService(StoreRetrieveService s) {
		this.sRSserv = s;
	}

	/**
	 * Gets table data.
	 *
	 * @param id the id
	 * @return the table data
	 */
	public List<TechnicalStatusByWeek> getTechnicalStatusByWeek(int id) {
		Trainer trainer = sRSserv.getTrainerById(id);
		List<TechnicalStatusByWeek> dataTransferObject = new ArrayList<>();

		log.info("TechnicalStatusByWeek_Service: "
				+ "Getting table data for TechnicalStatusByWeek");
		
		if (trainer != null) {
			//for each batch
			for (Batch b : trainer.getBatches()) {
	
				// for each week of that batch
				for (Week w : b.getWeeks()) {
					
					// for each category
					for (Category category : w.getCategories()) {
						
						// check if category is already in table
						boolean match = false;
						for (TechnicalStatusByWeek categoryRow : dataTransferObject) {
							if (category.getName().equals(categoryRow.getCategory())) { // matching category exists
								match = true;
								// increment technical status count
								if (w.getTechnicalStatus() != null) {
									if (w.getTechnicalStatus().contains("null")) {
				                        categoryRow.setNullCount(categoryRow.getNullCount() + 1);
				                    } else if (w.getTechnicalStatus().contains("Poor")) {
				                    	categoryRow.setPoorCount(categoryRow.getPoorCount() + 1);
				                    } else if (w.getTechnicalStatus().contains("Average")) {
				                    	categoryRow.setAverageCount(categoryRow.getAverageCount() + 1);
									} else if (w.getTechnicalStatus().contains("Good")) {
										categoryRow.setGoodCount(categoryRow.getGoodCount() + 1);
									} else if (w.getTechnicalStatus().contains("Superstar")) {
										categoryRow.setSuperstarCount(categoryRow.getSuperstarCount() + 1);
									}
								}
								break;
							}
						}
						// check if category match was not found in table
						if (!match) {
							TechnicalStatusByWeek newCategoryRow = new TechnicalStatusByWeek();
							newCategoryRow.setCategory(category.getName());
							// increment technical status count
							if (w.getTechnicalStatus() != null) {
								if (w.getTechnicalStatus().contains("null")) {
									newCategoryRow.setNullCount(newCategoryRow.getNullCount() + 1);
								} else if (w.getTechnicalStatus().contains("Poor")) {
									newCategoryRow.setPoorCount(newCategoryRow.getPoorCount() + 1);
								} else if (w.getTechnicalStatus().contains("Average")) {
									newCategoryRow.setAverageCount(newCategoryRow.getAverageCount() + 1);
			                    } else if (w.getTechnicalStatus().contains("Good")) {
			                    	newCategoryRow.setGoodCount(newCategoryRow.getGoodCount() + 1);
			                    } else if (w.getTechnicalStatus().contains("Superstar")) {
			                    	newCategoryRow.setSuperstarCount(newCategoryRow.getSuperstarCount() + 1);
			                    }
			                }
							dataTransferObject.add(newCategoryRow);
						}
					}
				}
			}
			// calculate and set percentages
			for (TechnicalStatusByWeek categoryRow : dataTransferObject) {
				// get sum total of data points for current category
				Double totalDataPoints = 0.0;
				totalDataPoints += categoryRow.getNullCount();
				totalDataPoints += categoryRow.getPoorCount();
				totalDataPoints += categoryRow.getAverageCount();
				totalDataPoints += categoryRow.getGoodCount();
				totalDataPoints += categoryRow.getSuperstarCount();
				// set averages as technical status count / total data points
				DecimalFormat df = new DecimalFormat("#.##"); // for formatting to two decimal places
				Double nullPercent = (categoryRow.getNullCount() / totalDataPoints) * 100;
				categoryRow.setNullAvg(Double.parseDouble(df.format(nullPercent))); // set formatted null percent
				Double poorPercent = (categoryRow.getPoorCount() / totalDataPoints) * 100;
				categoryRow.setPoorAvg(Double.parseDouble(df.format(poorPercent))); // set formatted poor percent
				Double averagePercent = (categoryRow.getAverageCount() / totalDataPoints) * 100;
				categoryRow.setAverageAvg(Double.parseDouble(df.format(averagePercent))); // set formatted average percent
				Double goodPercent = (categoryRow.getGoodCount() / totalDataPoints) * 100;
				categoryRow.setGoodAvg(Double.parseDouble(df.format(goodPercent))); // set formatted good percent
				Double superstarPercent = (categoryRow.getSuperstarCount() / totalDataPoints) * 100;
				categoryRow.setSuperstarAvg(Double.parseDouble(df.format(superstarPercent))); // set formatted super star percent
			}
		} else {
			log.warn("Trainer is null!");
		}
		return dataTransferObject;
    }    
}
