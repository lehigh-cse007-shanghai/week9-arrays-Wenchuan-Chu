package lehigh;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;


public class MovingBalls extends PApplet{


    int number = 4;
    int[] x = new int[number];
    int[] y = new int[number];
    int[] speedX = new int[number];
    int[] speedY = new int[number];
    int[] [] color = new int[number] [3];



    public void settings(){
        size(500, 500);

        Random random = new Random();
        for(int i = 0; i < number; i++){
            x[i] = random.nextInt(500);
            y[i] = random.nextInt(500);
            speedX[i] = random.nextInt(3) + 1;
            speedY[i] = random.nextInt(3) + 1;
            color[i] = new int[] {random.nextInt(255),random.nextInt(255),random.nextInt(255)};
        }
    }

    public void draw(){



        background(255,255,255);


        for (int i = 0; i < x.length; i++){

            fill(color[i][0],color[i][1],color[i][2]);
            ellipse(x[i], y[i], 50, 50);
            x[i] = positionX(i);
            y[i] = positionY(i);
            speedX[i] = changeSpeedX(i);
            speedY[i] = changeSpeedY(i);

            if (i != x.length - 1) {
                for(int lineTest = i+1; lineTest < x.length; lineTest++){
                    int xDifference = x[lineTest] - x[i];
                    int yDifference = y[lineTest] - y[i];
                    if(Math.abs(xDifference) <= 100 && Math.abs(yDifference) <= 100){
                        //strokeWeight(10);
                        line(x[lineTest], y[lineTest], x[i], y[i]);
                        //stroke(color[i][0],color[i][1],color[i][2]);
                    }
                }
            }

        }

    }

    public int positionX (int n){
        x[n] += speedX[n];
        return x[n];
    }

    public int positionY (int n){
        y[n] += speedY[n];
        return y[n];
    }

    public int changeSpeedX (int n){
        if(x[n] >= 500){
            speedX[n] = -speedX[n];
        }
        if(x[n] <= 0){
            speedX[n] = -speedX[n];
        }
        return speedX[n];
    }

    public int changeSpeedY (int n){
        if(y[n] >= 500){
            speedY[n] = -speedY[n];
        }
        if(y[n] <= 0) {
            speedY[n] = -speedY[n];
        }
        return speedY[n];
    }



    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);
    }
}