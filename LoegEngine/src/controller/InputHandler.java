package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class InputHandler implements KeyListener {
	private HashMap<Integer, ArrayList<Key>> keys = new HashMap<Integer, ArrayList<Key>>();
	
	public InputHandler() {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		toggle(e, true);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		toggle(e, false);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//emptyness FTW
	}
	
	private void toggle(KeyEvent e, boolean pressed) {
		int keyCode = e.getKeyCode();
		if (keys.containsKey(keyCode)) {
			for (Key key : keys.get(keyCode)) {
				key.toggle(pressed);
			} 
		}
	}
	
	protected void addToKeys(int keyEvent, Key key) {
		if (keys.containsKey(keyEvent)) {
			keys.get(keyEvent).add(key);
		}
		else {
			ArrayList<Key> newKeyList = new ArrayList<Key>();
			newKeyList.add(key);
			keys.put(keyEvent, newKeyList);
		}
	}

	public void clearAll() {
		for (ArrayList<Key> keyList : keys.values()) {
			for (Key key : keyList) {
				key.clear();
			}
		}
	}
}
