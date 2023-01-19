If help is needed, be free to dm me: Eclipsed#4334

* Before you start, you need to know that this is a client base, it is a BASE for YOU START coding your own client.

- [x] Events System
- [x] Module System
- [ ] Command System
- [ ] Account Manager (Alt Manager)

First things first, you need to call the ClientMain class in Minecraft.java. Search for the "startGame" method, and add this line:
```
 ClientMain.getInstance.init();
 ```

* Next, you need to call the events:

For the key event, you need to go to Minecraft.java, and search for "k == 1" (line 1950 - 1960), and add this line:
```
ClientMain.getInstance.eventBus.call(new KeyEvent(k));
```

For the tick event, you need to go to Minecraft.java, and search for "runTick" (line 1120 - 1134), and add this line:
```
ClientMain.getInstance.eventBus.call(new TickEvent());
```

For the render event, you need to go to GuiIngame.java, and search for "renderGameOverlay", at the very bottom of the method (before GlStateManager.color), add this line:
```
ClientMain.getInstance.eventBus.call(new OverlayEvent(partialTicks));
```

* To create a new event, you need to create a new class, and implements Event:
```
 public class TestEvent implements Event (if you want a cancelable event, you need to implement CancellableEvent) {
      TODO: Event code
}
```

* To create a new module, you need to create a new class, extends Module and before "public class" `@Mod(name = "name", description = "desc", key = 0 (Keyboard.KEY_R)`:
```
@Mod(name = "name", description = "desc", key = 0)
public class TestMod extends Module {
    TODO: Module code
}
```
