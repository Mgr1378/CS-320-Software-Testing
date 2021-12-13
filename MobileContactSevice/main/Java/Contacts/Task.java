package Contacts;

public class Task {

	private String taskName;
	private String taskDescription;
	private String taskId;
	private static final int taskDescription_LENGTH = 50;
	private static final byte taskId_LENGTH = 10;
	private static final byte NAME_LENGTH = 20;

//	public Task() {
//		this.taskName = INITIALIZER;
//		this.taskDescription = INITIALIZER;
//		this.taskId = INITIALIZER;
//	}
//
//	public Task(String newUniquetaskId) {
//		updateTaskId(newUniquetaskId);
//		this.taskName = INITIALIZER;
//		this.taskDescription = INITIALIZER;
//	}
//
//	public Task(String newUniquetaskId, String taskName) {
//		updateTaskId(newUniquetaskId);
//		updateTaskName(taskName);
//		this.taskDescription = INITIALIZER;
//	}

	public Task(String newUniquetaskId, String taskName, String taskDescription) {
		setTaskId(newUniquetaskId);
		setTaskName(taskName);
		setTaskDescription(taskDescription);
	}

	public String getTaskName() {
		return taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public String getTaskId() {
		return taskId;
	}

	protected void setTaskId(String newUniquetaskId) {
		if (newUniquetaskId == null || newUniquetaskId.length() > taskId_LENGTH) {
			throw new IllegalArgumentException("InvaltaskId taskId.");
		} else {
			this.taskId = newUniquetaskId;
		}
	}

	protected void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid taskId First Name.");
		} else {
			this.taskName = taskName;
		}
	}

	protected void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > taskDescription_LENGTH) {
			throw new IllegalArgumentException("Invalid taskId.");
		} else {
			this.taskDescription = taskDescription;
		}

	}
}
