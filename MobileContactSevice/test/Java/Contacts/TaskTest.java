package Contacts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {

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
	void testTaskDescription() {
		Task Task = new Task(taskId, taskName, description);
		assertTrue(Task.getTaskId().equals(taskId));
		assertTrue(Task.getTaskName().equals(taskName));
		assertTrue(Task.getTaskDescription().equals(description));
	}

	@Test
	void testTaskIdLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(longTaskId, taskName, description);
		});
	}

	@Test
	void testTaskNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskId, longTaskName, description);
		});
	}

	@Test
	void testTaskDescriptionLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskId, taskName, longDescription);
		});
	}

	@Test
	void testNullId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, taskName, description);
		});
	}

	@Test
	void testNullFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskId, null, description);
		});
	}

	@Test
	void testNullDescriptionName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(taskId, taskName, null);
		});
	}

}