import commands.Command;
import commands.MoveCommand;
import commands.TurnLeftCommand;
import commands.TurnRightCommand;
import grid.Grid;
import rover.Rover;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(10, 10);
        grid.addObstacle(2, 2);
        grid.addObstacle(3, 5);

        Rover rover = new Rover(0, 0, 'N', grid);

        List<Command> commands = Arrays.asList(
                new MoveCommand(rover),
                new MoveCommand(rover),
                new TurnRightCommand(rover),
                new MoveCommand(rover),
                new TurnLeftCommand(rover),
                new MoveCommand(rover)
        );

        for (Command command : commands) {
            command.execute();
        }

        System.out.println(rover.getStatus());
    }
}
