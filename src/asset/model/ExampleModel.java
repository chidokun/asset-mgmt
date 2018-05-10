/**
 * 
 */
package asset.model;

import java.util.ArrayList;

import asset.entity.ExampleEntity;

/**
 * @author Tuan
 *
 */
public class ExampleModel {
	
	public static ExampleEntity select(String key) {
		return new ExampleEntity();
	}
	
	public static ArrayList<ExampleEntity> selectAll() {
		return new ArrayList<>();
	}
	
	public static void insert(ExampleEntity entity) {
		return;
	}
	
	public static void update(ExampleEntity entity) {
		return;
	}
	
	public static void delete(String key) {
		return;
	}
}
