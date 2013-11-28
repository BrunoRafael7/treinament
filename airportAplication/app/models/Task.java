package models;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Task extends Model implements Comparable<Task>{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Required
	private String label;
	
	@Required
	private String project;
	
	@Required
	private String priority;
	
	private boolean isComplete;
	
	private static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);
	
	public static List<Task> all(){
		List<Task> list = find.all();
		Collections.sort(list);
		return list;
	}
	
	public static void create(Task task){
		task.save();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
	public static void update(Long id){
		Task task = find.ref(id);
		task.setComplete(!task.isComplete);
		task.update();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(Task o) {
		return getPriority().compareTo(o.getPriority());
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

}