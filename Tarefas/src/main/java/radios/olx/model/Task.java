package radios.olx.model;

public class Task {
	private String name, time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", time=" + time + "]";
	}
	
}
