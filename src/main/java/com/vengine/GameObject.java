package com.vengine;

import java.util.ArrayList;

/**
 * Created by Celal on 2-2-2016.
 * Last update 2-2-2016
 */
public class GameObject {

    private ArrayList<Vector2D> vectors;

    private int x, y;
    private int width, height;//Should we allow for non rectangular hitboxes?

    private boolean isTargetable,
            hasHealth,
            doesCollideWithTerrain,
            doesCollideWithObjects,
            isAffectedByGravity;

    /**
     * Creates a new com.vengine.GameObject.
     * Sets certain default settings:
     *      A GameObject has per default these settings:
     *          isTargetable: true
     *          hasHealth: true
     *          doesCollideWithTerrain: true
     *          doesColligeWithObjects: false
     *          isAffectedByGravity: true
     */
    public GameObject(){
        vectors = new ArrayList<Vector2D>();
        this.setIsTargetable(true);
        this.setHasHealth(true);
        this.setDoesCollideWithTerrain(true);
        this.setDoesCollideWithObjects(false);
        this.setIsAffectedByGravity(true);
    }

    /**
     * Adds the specified com.vengine.Vector2D to this com.vengine.GameObject.
     * @param v The com.vengine.Vector2D to be added
     */
    public void addVector(Vector2D v){
        this.vectors.add(v);
    }

    /**
     * Removes the specified com.vengine.Vector2D from this com.vengine.GameObject.
     * @param v The com.vengine.Vector2D to be removed
     */
    public void removeVector(Vector2D v){
        this.vectors.remove(v);
    }

    /**
     * Method to be overridden by developers to be able to add code to update(). afterUpdate() is called after update(). (Mind == blown)
     */
    public void afterUpdate(){

    }

    /**
     * Updates the com.vengine.GameObject, also calls afterUpdate().
     */
    public final void update(){
        //Update object

        //Calculate moving direction and distance from all Vector2Ds in this com.vengine.GameObject
        moveObject();

        //Call afterUpdate()
        afterUpdate();
    }

    private void moveObject(){
        Vector2D resultVector = new Vector2D();

        for(Vector2D v : vectors){
            resultVector.setX(resultVector.getX() + v.getX());
            resultVector.setY(resultVector.getY() + v.getY());

            //After a Vector2D has been processed, we remove it from the list for the next tick
            this.vectors.remove(v);
        }

        this.x += resultVector.getX();
        this.y += resultVector.getY();
    }

    public ArrayList<Vector2D> getVectors(){
        return vectors;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public boolean isTargetable() {
        return isTargetable;
    }

    public void setIsTargetable(boolean targetable) {
        isTargetable = targetable;
    }

    public boolean hasHealth() {
        return hasHealth;
    }

    public void setHasHealth(boolean hasHealth) {
        this.hasHealth = hasHealth;
    }

    public boolean doesCollideWithTerrain() {
        return doesCollideWithTerrain;
    }

    public void setDoesCollideWithTerrain(boolean doesCollideWithTerrain) {
        this.doesCollideWithTerrain = doesCollideWithTerrain;
    }

    public boolean doesCollideWithObjects() {
        return doesCollideWithObjects;
    }

    public void setDoesCollideWithObjects(boolean doesCollideWithObjects) {
        this.doesCollideWithObjects = doesCollideWithObjects;
    }

    public boolean isAffectedByGravity(){
        return this.isAffectedByGravity;
    }

    public void setIsAffectedByGravity(boolean val){
        this.isAffectedByGravity = val;
    }


}
