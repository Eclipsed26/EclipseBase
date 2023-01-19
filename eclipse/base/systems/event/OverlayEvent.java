package eclipse.base.systems.event;

import best.azura.eventbus.core.Event;

public class OverlayEvent implements Event {
    private float partialTicks;

    public OverlayEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}