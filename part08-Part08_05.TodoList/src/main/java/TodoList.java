import java.util.ArrayList;

public class TodoList {
	private ArrayList<String> todolist;

	public TodoList() {
		this.todolist = new ArrayList<>();
	}

	public void add(String task) {
		this.todolist.add(task);
	}

	public void print() {
		for (int i=0; i<this.todolist.size(); i++) {
			System.out.println((i+1) + ": " + this.todolist.get(i));
		}
	}

	public void remove(int number) {
		this.todolist.remove(number - 1);
	}
}
