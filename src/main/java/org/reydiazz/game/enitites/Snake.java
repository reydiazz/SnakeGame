package org.reydiazz.game.enitites;

import org.reydiazz.core.enums.Address;

import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    private final Deque<Point> body;
    private int growPending = 0;

    public Snake() {
        body = new ArrayDeque<>();
        body.addFirst(new Point(0, 0));
    }

    public Snake(int row, int col) {
        body = new ArrayDeque<>();
        body.addFirst(new Point(row,col));
    }

    public void move(Address address) {
        Point head = body.getFirst();
        Point newHead = new Point(head.getX() + address.dx, head.getY() + address.dy);
        body.addFirst(newHead);
        if (growPending > 0) {
            growPending--;
        } else {
            body.removeLast();
        }
    }

    public Deque<Point> getBody() {
        return body;
    }

    public int getGrowPending() {
        return growPending;
    }

    public void reset(){
        body.clear();
        body.addFirst(new Point(0, 0));
    }

    public void setGrowPending(int growPending) {
        this.growPending = growPending;
    }
}
