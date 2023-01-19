package eclipse.base.systems.event;

import best.azura.eventbus.core.Event;

public class KeyEvent implements Event { // TODO: KeyEvent class

    public int key;

    public KeyEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

}
