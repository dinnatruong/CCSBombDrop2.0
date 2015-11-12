package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by Dinna on 09/11/2015.
 */
public class TouchPad extends Actor {
    static public com.badlogic.gdx.scenes.scene2d.ui.Touchpad touchpad;
    private com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle touchpadStyle;
    private Skin skTouchPad;
    private Drawable drwTouchbg;
    private Drawable drwTouchpad;
    Sprite spFG, spBG;

    // https://github.com/JStruk/Bomberman/blob/master/core/src/com/mygdx/game/Thumbstick.java
    public TouchPad() {
        //Create a skin for the touchpad
        skTouchPad = new Skin();
        //Set background and knob imgs
        spFG = new Sprite(new Texture("ThumbstickFGsmall.png"));
        spBG = new Sprite(new Texture("ThumbstickBG.png"));
        skTouchPad.add("drwTouchbg", spBG);
        skTouchPad.add("drwTouchpad", spFG);
        touchpadStyle = new com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle();
        //make drawables based off the skin
        drwTouchbg = skTouchPad.getDrawable("drwTouchbg");
        drwTouchpad = skTouchPad.getDrawable("drwTouchpad");
        //Apply the bg and knob drawables to the touchpad
        touchpadStyle.background = drwTouchbg;
        touchpadStyle.knob = drwTouchpad;

        //Initiate the touchpad based on the style we just created
        touchpad = new com.badlogic.gdx.scenes.scene2d.ui.Touchpad(10, touchpadStyle);
        //set where the touchpad will be on the screen
        touchpad.setBounds(30, 30, 100, 100);
    }
}