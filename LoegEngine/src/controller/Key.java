package controller;

import java.util.LinkedList;

public class Key {
	private LinkedList<Boolean> nextState;
	private boolean wasDown = false;
	private boolean isDown = false;

	public Key() {
		nextState = new LinkedList<Boolean>();
	}

	public void toggle(boolean press) {
		if (nextState.isEmpty() || press != nextState.getLast())
			nextState.add(press);
	}

	public void tick() {
		wasDown = isDown;
		boolean state = false;
		if (!nextState.isEmpty())
			state = nextState.removeFirst();
		if (state)
			isDown = state;
		else if (isDown && !state)
			isDown = false;
	}

	public boolean hasNext() {
		return !nextState.isEmpty();
	}

	public boolean next() {
		if (hasNext()) {
			tick();
			return true;
		}
		return false;
	}

	public boolean isClicked() {
		return !wasDown && isDown;
	}

	public boolean isPressed() {
		return isDown;
	}

	public boolean wasReleased() {
		return wasDown && !isDown;
	}

	public void release() {
		nextState.add(false);
	}

	public void clear() {
		nextState.clear();
	}
}


