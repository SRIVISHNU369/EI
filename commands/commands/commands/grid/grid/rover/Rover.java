package rover;

import grid.Grid;
import utils.Logger;

public class Rover {
    private int x;
    private int y;
    private char direction;
    private Grid grid;

    public Rover(int x, int y, char direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void setPosition(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move() {
        int newX = x, newY = y;
        switch (direction) {
            case 'N': newY++; break;
            case 'S': newY--; break;
            case 'E': newX++; break;
            case 'W': newX--; break;
        }
        if (isWithinBounds(newX, newY) && !grid.hasObstacle(newX, newY)) {
            x = newX;
            y = newY;
            Logger.log("Moved to (" + x + ", " + y + ")");
        } else {
            Logger.log("Move blocked by obstacle or boundary");
        }
    }

    public void turnLeft() {
        switch (direction) {
            case 'N': direction = 'W'; break;
            case 'W': direction = 'S'; break;
            case 'S': direction = 'E'; break;
            case 'E': direction = 'N'; break;
        }
        Logger.log("Turned left, now facing " + direction);
    }

    public void turnRight() {
        switch (direction) {
            case 'N': direction = 'E'; break;
            case 'E': direction = 'S'; break;
            case 'S': direction = 'W'; break;
            case 'W': direction = 'N'; break;
        }
        Logger.log("Turned right, now facing " + direction);
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < grid.getWidth() && y >= 0 && y < grid.getHeight();
    }

    public String getStatus() {
        return "Rover is at (" + x + ", " + y + ") facing " + direction;
    }
}
