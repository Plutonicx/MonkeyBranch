package com.kilobolt.gameobjects;

/**
 * Created by Stevan on 11/26/2015.
 */

import com.badlogic.gdx.math.Intersector;

import java.util.Random;
import java.util.stream.IntStream;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Vector2;

public class Vine extends Scrollable{

    private Random r;

    private Polyline vine;

    public static final int VINE_LENGTH_BASE = 50;

    public Vine(float x, float y, int width, int height, float scrollSpeed, float groundY){
        super(x, y, width, height, scrollSpeed);

        r = new Random();

        // to do: add proper initilisation and follow methods and objects used in Pipe class.
        // use the random height later.
        float[] vertices = new float[4];
        vertices[0] = x;
        vertices[1] = 0;
        vertices[2] = x;
        vertices[3] = height;

        vine = new Polyline(vertices);

    }

    @Override
    public void update(float delta){
        super.update(delta);

        vine.setPosition(position.x, position.y);
    }

    public void update(float delta, Vector2 momentum){
        // do this later.

    }

    @Override
    public void reset(float newX){
        super.reset(newX);
    }

    public void onRestart(float x, float scrollSpeed){
        velocity.x = scrollSpeed;
        reset(x);
    }

    public Polyline getVine() {return vine; }

    public boolean collides(Bird bird){
        if (position.x < bird.getX() + bird.getWidth()) {
            return ( Intersector.intersectSegmentCircle(new Vector2(vine.getVertices()[0], vine.getVertices()[1]),
                    new Vector2(vine.getVertices()[2], vine.getVertices()[3]), new Vector2(bird.getBoundingCircle().x,bird.getBoundingCircle().y),
                    bird.getBoundingCircle().radius ) );
        }
        return false;
    }


}
