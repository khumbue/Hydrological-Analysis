package za.co.jobcreation.ejb.impl.util;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import za.co.jobcreation.ejb.dao.BaseDao;
import za.co.jobcreation.ejb.model.BaseEntity;

public class CollectionBuilder<T extends BaseEntity, R extends BaseDao<T>> {

	public void updateChildren(List<T> currentEntities, List<T> newEntities, R dao) {
		
		updateChildren(currentEntities, newEntities, dao, true);

	}

	public void updateChildren(List<T> currentEntities, List<T> newEntities, R dao, boolean deleteOrphans) {

		for (T newEntity : newEntities) {

			if (newEntity.getId() == 0) {

				dao.add(newEntity);

			} else {

				if (currentEntities.remove(newEntity)) {
					dao.update(newEntity);
				}
			}
		}

		if (CollectionUtils.isNotEmpty(currentEntities)) {
			for (T oldEntity : currentEntities) {

				if (deleteOrphans) {
					dao.remove(oldEntity);
				}
			}
			currentEntities.clear();
		}
	}

}
