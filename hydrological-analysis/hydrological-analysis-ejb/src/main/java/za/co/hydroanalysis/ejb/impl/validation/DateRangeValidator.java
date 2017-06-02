package za.co.jobcreation.ejb.impl.validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import za.co.jobcreation.api.dto.DateRange;

public class DateRangeValidator {

	public <T extends DateRange> boolean overlaps(List<T> dateRanges) {

		boolean isOrverlapping = false;
		List<DateRange> tempDateRanges = new ArrayList<DateRange>();
		tempDateRanges.addAll(dateRanges);

		while (tempDateRanges.size() > 0) {

			DateRange dateRange = tempDateRanges.remove(0);
			isOrverlapping = overlaps(dateRange, tempDateRanges);
			if (isOrverlapping) {
				break;
			}
		}

		return isOrverlapping;

	}

	public boolean overlaps(DateRange dateRange, List<DateRange> dateRanges) {
		boolean isOrverlapping = false;
		if (CollectionUtils.isNotEmpty(dateRanges)) {
			for (DateRange dateRange2 : dateRanges) {

				isOrverlapping = overlaps(dateRange, dateRange2);

				if (isOrverlapping) {
					break;
				}
			}

		}
		return isOrverlapping;
	}

	public boolean overlaps(DateRange dateRange1, DateRange dateRange2) {

		boolean isOrverlapping = false;

		if (dateRange1.getEndDate() == null && dateRange2.getEndDate() == null) {
			isOrverlapping = true;
		}

		else if (dateRange1.getStartDate().before(dateRange2.getStartDate()) && dateRange1.getEndDate() == null) {
			isOrverlapping = true;
		}

		else if (dateRange2.getStartDate().before(dateRange1.getStartDate()) && dateRange2.getEndDate() == null) {
			isOrverlapping = true;
		}

		else if (dateRange1.getEndDate() != null && dateRange1.getEndDate().before(dateRange2.getStartDate()) && dateRange2.getEndDate() == null) {
			isOrverlapping = false;
		}

		else if (dateRange2.getEndDate() != null && dateRange2.getEndDate().before(dateRange1.getStartDate()) && dateRange1.getEndDate() == null) {
			isOrverlapping = false;
		}

		else if (dateRange1.getStartDate().before(dateRange2.getStartDate()) && dateRange2.getStartDate().before(dateRange1.getEndDate())) {
			isOrverlapping = true;
		}

		else if (dateRange2.getStartDate().before(dateRange1.getStartDate()) && dateRange1.getStartDate().before(dateRange2.getEndDate())) {
			isOrverlapping = true;
		}

		else if (dateRange1.getStartDate().before(dateRange2.getStartDate()) && dateRange1.getEndDate().after(dateRange2.getEndDate())) {
			isOrverlapping = true;
		}

		else if (dateRange2.getStartDate().before(dateRange1.getStartDate()) && dateRange2.getEndDate().after(dateRange1.getEndDate())) {
			isOrverlapping = true;
		} else if (dateRange1.getStartDate().equals(dateRange2.getStartDate()) && dateRange1.getEndDate().equals(dateRange2.getEndDate())) {
			isOrverlapping = true;
		}

		return isOrverlapping;
	}

	
}
