package org.ghosttrio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSleepCommand {

    private boolean commandExecuted = false;

    @Test
    void testSleep() throws Exception {
        Command wakeup = () -> commandExecuted = true;
        ActiveObjectEngine engine = new ActiveObjectEngine();
        SleepCommand sleepCommand = new SleepCommand(1000, engine, wakeup);
        engine.addCommand(sleepCommand);

        long start = System.currentTimeMillis();
        engine.run();
        long stop = System.currentTimeMillis();
        long sleepTime = (stop - start);

        assertTrue(sleepTime > 1000);
        assertTrue(sleepTime < 1100);
    }
}
