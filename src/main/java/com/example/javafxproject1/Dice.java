package com.example.javafxproject1;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

public class Dice {
    private ImageView diceImage;

    Dice(ImageView diceImage) {
        this.diceImage = diceImage;
    }
    public int choosingNumber(){

            // Get the URL of the image
            String imageUrl = diceImage.getImage().getUrl();

            // Extract the filename from the URL
            String filename = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);

        if(filename.equals("dice-1.png")){
            return 1;
        }
        if(filename.equals("dice-2.png")){
            return 2;
        }
        if(filename.equals("dice-3.png")){
            return 3;
        }
        if(filename.equals("dice-4.png")){
            return 4;
        }
        if(filename.equals("dice-5.png")){
            return 5;
        }
        if(filename.equals("dice-6.png")){
            return 6;
        }
        return 0;



    }

}