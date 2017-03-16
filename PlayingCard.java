/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kartua
 */
public class PlayingCard {
    private String suit, image;
    private int value;
    
    
    public PlayingCard(){
    
    }
    //**Constructor**
    //Precondition: 2 Strings and one int are passed to the constructor
    //Postcondition: -a PlayingCard object is create with suit, image and value
    //                  as it's properties.
    public PlayingCard(String suit, int value,  String image){
        
        this.suit = suit;
        this.value = value;
        this.image = image;
    
    }
    
    //**getValue**
    //Precondition: a PlayingCard object
    //Postcodition: return the value of the card as an integer.
    public int getValue(){
        return value;
    }
    
    //**getSuit**
    //Precondition: a PlayingCard object
    //Postcodition: return the suit of the card as a String.
    public String getSuit(){
        return suit;
    }
    //**getImage**
    //Precondition: a PlayingCard object
    //Postcodition: return the image path of the card as a String.
    public String getImage(){
        return image;
    }
    
    //**setValue**
    //Precondition: a PlayingCard object
    //Postcodition: set value to the object
    public void setValue(int value){
        this.value = value;
    }
    //**setSuit**
    //Precondition: a PlayingCard object
    //Postcodition: set suit to the object
    public void setSuit(String suit){
        this.suit = suit;
    }
    
    //**setImage**
    //Precondition: a PlayingCard object
    //Postcodition: set image path to the object
    public void setValue(String image){
        this.image = image;
    }
    
}
