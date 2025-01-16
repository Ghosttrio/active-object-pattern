package org.ghosttrio;

import java.util.LinkedList;

public class ActiveObjectEngine {
    LinkedList<Command> itsCommands = new LinkedList<>();

    public void addCommand(Command command) {
        itsCommands.add(command);
    }

    public void run() throws Exception {
        while (!itsCommands.isEmpty()) {
            Command command = itsCommands.getFirst();
            itsCommands.removeFirst();
            command.execute();
        }
    }
}
