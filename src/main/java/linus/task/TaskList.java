package linus.task;

import java.util.ArrayList;
import java.util.List;

import linus.exception.LinusException;
import linus.util.Ui;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    private List<Task> tasks = null;

    /**
     * Constructs a TaskList object with an empty list of tasks.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList object with the specified list of tasks.
     *
     * @param tasks The list of tasks.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the list of tasks.
     *
     * @return The list of tasks.
     */
    public List<Task> getList() {
        return this.tasks;
    }

    /**
     * Prints the number of tasks in the list.
     */
    public void list() {
        String listOfItems = "Here are the tasks in your list:\n";
        for (int i = 0; i < tasks.size(); ++i) {
            listOfItems += (i + 1) + "."
                    + tasks.get(i).toString() + "\n";
        }
        Ui.print(listOfItems);
    }

    /**
     * Adds the specified task to the list.
     *
     * @param task The task to be added.
     */
    public void add(Task task) {
        tasks.add(task);
        int numOfTasks = tasks.size();
        Ui.print("Got it. I've added this task:\n"
                + "  " + task + "\n"
                + "Now you have " + numOfTasks + " task" + (numOfTasks > 1 ? "s" : "") + " in the list.");
    }

    /**
     * Deletes the task at the specified index from the list.
     *
     * @param index The index of the task to be deleted.
     * @throws LinusException
     */
    public void delete(int index) throws LinusException {
        index -= 1;
        if (index < 0 || index >= tasks.size()) {
            throw new LinusException("Cannot delete task. Please provide a valid index.");
        }
        Task task = tasks.get(index);
        tasks.remove(index);
        int numOfTasks = tasks.size();
        Ui.print("Noted. I've removed this task:\n"
                + "  " + task + "\n"
                + "Now you have " + numOfTasks + " task" + (numOfTasks > 1 ? "s" : "") + " in the list.");
    }

    /**
     * Marks the task at the specified index as done.
     *
     * @param index The index of the task to be marked as done.
     * @throws LinusException
     */
    public void mark(int index) throws LinusException {
        index -= 1;
        if (index < 0 || index >= tasks.size()) {
            throw new LinusException("Cannot mark task. Please provide a valid index.");
        }
        tasks.get(index).mark();

    }

    /**
     * Unmarks the task at the specified index as done.
     *
     * @param index The index of the task to be unmarked as done.
     * @throws LinusException
     */
    public void unmark(int index) throws LinusException {
        index -= 1;
        if (index < 0 || index >= tasks.size()) {
            throw new LinusException("Cannot unmark task. Please provide a valid index.");
        }
        tasks.get(index).unmark();
    }

    /**
     * Finds and prints the tasks that contain the specified keyword.
     *
     * @param keyword The keyword to be searched for.
     */
    public void find(String keyword) {
        String listOfMatchingTasks = "Here are the matching tasks in your list:\n";
        int numOfMatchingTasks = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task curTask = tasks.get(i);
            if (curTask.description.contains(keyword)) {
                listOfMatchingTasks += (++numOfMatchingTasks) + "."
                        + tasks.get(i).toString() + "\n";
            }
        }
        if (numOfMatchingTasks == 0) {
            Ui.print("There are no matching tasks in your list.");
        } else {
            Ui.print(listOfMatchingTasks);
        }
    }
}
