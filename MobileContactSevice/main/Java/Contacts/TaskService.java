package Contacts;

import java.util.ArrayList; // Resizable Array for contact list
import java.util.List; // ordered objects to access by index
import java.util.UUID; // Universally Unique Identifier

public class TaskService {

	private List<Task> taskList = new ArrayList<>();

	private String newUniqueId() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}

	private Task searchTask(String id) throws Exception {
		for (Task task : taskList) {
			if (task.getTaskId().equals(id)) {
				return task;
			}
		}
		throw new Exception("Contact does not exist. Try Again");
	}

	public List<Task> getTaskList() {
		return taskList;
	}

//	public void newTask() {
//		Task task = new Task(newUniqueId());
//		taskList.add(task);
//
//	}
//
//	public void newTask(String taskName) {
//		Task task = new Task(newUniqueId(), taskName);
//		taskList.add(task);
//	}

	public void newTask(String uniqueId, String taskName, String taskDescription) {
		Task task = new Task(newUniqueId(), taskName, taskDescription);
		taskList.add(task);
	}

	public void updateTaskName(String uniqueId, String taskName) throws Exception {
		searchTask(uniqueId).setTaskName(taskName);
	}

	public void updateTaskDescription(String uniqueId, String taskDescription) throws Exception {
		searchTask(uniqueId).setTaskDescription(taskDescription);
	}

	public void deleteTask(String uniqueId) throws Exception {
		taskList.remove(searchTask(uniqueId));
	}

}