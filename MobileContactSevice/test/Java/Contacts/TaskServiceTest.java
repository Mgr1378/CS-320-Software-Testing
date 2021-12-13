package Contacts;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	protected String taskId;
	protected String taskName;
	protected String description;
	protected String longTaskName;
	protected String longDescription;
	protected String longTaskId;

	@BeforeEach
	void setUp() {
		taskId = "122H332BA9";
		taskName = "Task Name";
		description = "This is the task that I started";
		longTaskName = "This is a task that is named task";
		longDescription = "This is the task that I started when I was out in the city today and I just like to go to the city";
		longTaskId = "111222333444555666777888999000";
	}

	@Test
	void testTaskService() {
		TaskService tasks = new TaskService();
		tasks.newTask(taskId, taskName, description);
		assertAll("tasks", () -> assertNotNull(tasks.getTaskList().get(0).getTaskId()),
				() -> assertEquals(taskName, tasks.getTaskList().get(0).getTaskName()),
				() -> assertEquals(description, tasks.getTaskList().get(0).getTaskDescription()));
	}

	@Test
	void updatetaskName() throws Exception {
		TaskService tasks = new TaskService();
		tasks.newTask(taskId, taskName, description);
		tasks.updateTaskName(tasks.getTaskList().get(0).getTaskId(), taskName);
		assertEquals(taskName, tasks.getTaskList().get(0).getTaskName());
		assertThrows(IllegalArgumentException.class,
				() -> tasks.updateTaskName(tasks.getTaskList().get(0).getTaskId(), longTaskName));
		assertThrows(IllegalArgumentException.class,
				() -> tasks.updateTaskName(tasks.getTaskList().get(0).getTaskId(), null));
		assertThrows(Exception.class, () -> tasks.updateTaskName(taskId, taskName));

	}

	@Test
	void updateDescription() throws Exception {
		TaskService tasks = new TaskService();
		tasks.newTask(taskId, taskName, description);
		tasks.updateTaskDescription(tasks.getTaskList().get(0).getTaskId(), description);
		assertEquals(description, tasks.getTaskList().get(0).getTaskDescription());
		assertThrows(IllegalArgumentException.class,
				() -> tasks.updateTaskDescription(tasks.getTaskList().get(0).getTaskId(), longDescription));
		assertThrows(IllegalArgumentException.class,
				() -> tasks.updateTaskDescription(tasks.getTaskList().get(0).getTaskId(), null));
		assertThrows(Exception.class, () -> tasks.updateTaskDescription(taskId, description));

	}

	@Test
	void deleteTask() {
		TaskService tasks = new TaskService();
		tasks.newTask(taskId, taskName, description);
		assertThrows(Exception.class, () -> tasks.deleteTask(taskId));
		assertAll(() -> tasks.deleteTask(tasks.getTaskList().get(0).getTaskId()));
	}
}