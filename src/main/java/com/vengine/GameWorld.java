package com.vengine;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

/**
 * Created by Celal on 2-2-2016.
 * Last update 2-2-2016
 */
public class GameWorld{

    //All GameObjects in this com.vengine.GameWorld
    private ArrayList<GameObject> objects;

    private Vector2D gravityVector;

    //The size of the world in units. Didn't want to use pixels to avoid confusion.
    private int unitsX, unitsY;

    //Some settings for a GameWorld
    private boolean hasGravity;

    /**
     * Creates a new com.vengine.GameWorld.
     */
    public GameWorld(){
        this.objects = new ArrayList<GameObject>();
    }

    /**
     * Adds the specified com.vengine.GameObject to this com.vengine.GameWorld.
     * @param object The com.vengine.GameObject to be added.
     */
    public void addGameObject(GameObject object){
        this.objects.add(object);
    }

    /**
     * Removes the specified com.vengine.GameObject from this com.vengine.GameWorld.
     * @param object The com.vengine.GameObject to be removed.
     */
    public void removeGameObject(GameObject object){
        this.objects.remove(object);
    }

    /**
     * Updates the com.vengine.GameWorld, also calls afterUpdate().
     */
    public final void update(){
        for(GameObject object : objects){
            //If gravity is enabled in this world, add the gravityVector to all GameObjects
            if(hasGravity && object.isAffectedByGravity()){
                object.addVector(gravityVector);
            }
            object.update();
        }

        //Call afterUpdate()
        afterUpdate();
    }

    /**
     * Paints specified coordinates on specified Canvas.
     * @param canvas
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void paint(Canvas canvas, int x, int y, int width, int height){
        for(GameObject object : objects){
            if(object.getX() >= x && object.getX() < x + width && object.getY() >= y && object.getY() < y + height){
                //Object within boundaries

            }
        }
    }

    /**
     * Method to be overridden by developers to be able to add code to update(). afterUpdate() is called after update(). (Mind == blown)
     */
    public void afterUpdate(){

    }

    public Vector2D getGravityVector() {
        return gravityVector;
    }

    public void setGravityVector(Vector2D gravityVector) {
        this.gravityVector = gravityVector;
    }

    public boolean isHasGravity() {
        return hasGravity;
    }

    public void setHasGravity(boolean hasGravity) {
        this.hasGravity = hasGravity;
    }

    public static GameWorld read(GameWorldFile file){
        return null;
    }
}
