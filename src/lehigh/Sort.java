package lehigh;


import processing.core.PApplet;

public class Sort extends PApplet {


    float []height = {15f,8f,6f,11f,1f,3f,9f};
    float x1[] = {50,100,150,200,250,300,350};

    float width = 25;


    int i = 0;
    int max = height.length -1;




    float y = 130;


    public void settings() {
        size(400, 400);


    }
    public void draw() {
        delay(500);
        background(0);

        if (i >= max) {
            i = 0;
            max--;
        }
// 015,125,235,345,455,014,124,234,344,013.123,233,012,122,011
        int j = i + 1;

        if (height[i] > height[i + 1]) {
            swap(i, i + 1);
        }
        delay(500);
        fill(255);
        for(int k = 0; k < height.length ; k++) {

            if(k ==  i || i == i+1 ){fill(255,0,0);}
            if(k >i+1){
                fill(255);
            }
            if(k > max ){fill(0,0,255);}
            drawRect(k);



        }

        i++;


    }





    public void swap(int i, int j){

        float tmp = height[i];
        height[i] = height[j];
        height[j] = tmp;

    }

    public static void main(String[] args) {
        String[] processingArgs = {"Sort"};
        Sort sort = new Sort();
        PApplet.runSketch(processingArgs, sort);
    }

    public void drawRect(int i){
        rect(x1[i], 0, width, height[i] * 20);

        textSize(15);
        text(height[i],x1[i] , height[i] * 20+50);
    }

}