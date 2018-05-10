/**
 * 
 */
package asset.controller;

import java.util.ArrayList;

import asset.entity.ExampleEntity;
import asset.model.ExampleModel;

/**
 * @author Tuan
 *
 */
public class ExampleController {
	public ExampleEntity select(String key) {
		return ExampleModel.select(key);
	}
	
	public ArrayList<ExampleEntity> selectAll() {
		return ExampleModel.selectAll();
	}
	
	public void insert(ExampleEntity entity) {
		ExampleModel.insert(entity);
	}
	
	public void update(ExampleEntity entity) {
		ExampleModel.update(entity);
	}
	
	public void delete(String key) {
		ExampleModel.delete(key);
	}
}
