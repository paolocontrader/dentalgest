package toDo;

import java.io.Serializable;

public class ToDo implements Serializable, Comparable<ToDo> {
	private String todo;
        private String client;
	private int fromHour;
	private int fromMinute;
	private int toHour;
	private int toMinute;

	public ToDo(String client, int fromHour, int fromMinute, int toHour, int toMinute,String todo)
			throws EmptyToDoException, TimeInputException {
		super();
                setClient(client);
		setTodo(todo);
		setFromHour(fromHour);
		setFromMinute(fromMinute);
		setToHour(toHour);
		setToMinute(toMinute);
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) throws EmptyToDoException {
		if (todo.length() < 1)
			throw new EmptyToDoException();

		this.todo = todo;
	}

        public String getClient() {
		return client;
	}

	public void setClient(String client) throws EmptyToDoException {
		if (client.length() < 1)
			throw new EmptyToDoException();

		this.client = client;
	}
        
	public int getFromHour() {
		return fromHour;
	}

	public void setFromHour(int fromHour) {

		this.fromHour = fromHour;
	}

	public int getFromMinute() {
		return fromMinute;
	}

	public void setFromMinute(int fromMinute) {
		this.fromMinute = fromMinute;
	}

	public int getToHour() {
		return toHour;
	}

	public void setToHour(int toHour) throws TimeInputException {
		if (fromHour > toHour)
			throw new TimeInputException();

		this.toHour = toHour;
	}

	public int getToMinute() {
		return toMinute;
	}

	public void setToMinute(int toMinute) throws TimeInputException {
		if (fromHour == toHour && fromMinute > toMinute)
			throw new TimeInputException();

		this.toMinute = toMinute;
	}
	
	
	private String addZero (int n) {
		if(n<10) 
			return "0"+n;
		else return ""+n;
	}
	@Override
	public String toString() {
		String time = addZero(fromHour) + ":" + addZero(fromMinute) + " - " + addZero(toHour) + ":" + addZero(toMinute) ;
		String event = todo;
                String clients = client;
		return time+"\t                    "+clients+"\t                           "+event;
	}

	@Override
	public int compareTo(ToDo o) {
		// TODO Auto-generated method stub

		if (this.getFromHour() == o.getFromHour() && this.fromMinute == o.getFromMinute()) {
			if (this.getToHour() == o.getToHour())
				return this.getToMinute() - o.getToMinute();
			else
				return this.getToHour() - o.getToHour();

		} else {
			if (this.getFromHour() == o.getFromHour())
				return this.getFromMinute() - o.getFromMinute();
			else
				return this.getFromHour() - o.getFromHour();
		}
	}

	public boolean isSame(ToDo o) {
		boolean isSame = false;

		if (this.getFromHour() == o.getFromHour() && this.fromMinute == o.getFromMinute()
				&& this.getToHour() == o.getToHour() && this.getToMinute() == o.getToMinute())
		isSame = true;
		
		return isSame;
	}

}