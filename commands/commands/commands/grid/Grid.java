package grid;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    private int width;
    private int height;
    private Set<Obstacle> obstacles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>();
    }

    public void addObstacle(int x, int y) {
        obstacles.add(new Obstacle(x, y));
    }

    public boolean hasObstacle(int x, int y) {
        return obstacles.contains(new Obstacle(x, y));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
