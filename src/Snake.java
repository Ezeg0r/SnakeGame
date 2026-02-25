import java.awt.*;
import java.util.LinkedList;

public class Snake {
    private final LinkedList<Point> body = new LinkedList<>();
    private Direction currentDirection = Direction.RIGHT;
    private Direction nextDirection = Direction.RIGHT;

    public Snake(int startX, int startY, int initialLength) {
        for (int i = 0; i < initialLength; i++) {
            body.add(new Point(startX - i, startY));
        }

    }

    public void setDirection(Direction newDirection) {
        if (!newDirection.isOpposite(currentDirection)) {
            this.nextDirection = newDirection;
        }
    }

    public Point getNextHead() {
        Point head = body.getFirst();
        return new Point(head.x + nextDirection.dx, head.y + nextDirection.dy);
    }

    public void move(Point newHead, boolean grow) {
        currentDirection = nextDirection;
        body.addFirst(newHead);
        if (!grow) {
            body.removeLast();
        }
    }

    public boolean contains(Point p) {
        return body.contains(p);
    }

    public LinkedList<Point> getBody() {
        return body;
    }
}