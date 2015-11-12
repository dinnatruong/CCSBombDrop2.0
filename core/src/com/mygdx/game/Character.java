package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.ArrayList;

/**
 * Created by Dinna on 10/11/2015.
 */
public class Character {
    SpriteBatch batch;
    TextureAtlas taBomberman;
    static Sprite spBomberman;
    static TextureAtlas taBombExplode;
    static ArrayList<Bomb> arlBombs;
    float fSpeed;

    public void create() {
        batch = new SpriteBatch();

        //Create sprite that is going to move around with the touchpad
        taBomberman = new TextureAtlas(Gdx.files.internal("bomberman.txt"));
        spBomberman = new Sprite(taBomberman.findRegion("frame_1"));
        spBomberman.setPosition(Gdx.graphics.getWidth() / 2 - spBomberman.getWidth() / 2, Gdx.graphics.getHeight() / 2 + spBomberman.getHeight() / 2);

        //Set the default speed to multiply by when the touchpad is moved around to move the character
        fSpeed = 5;

        //Load file for bomb animation and create an array list for bombs
        taBombExplode = new TextureAtlas(Gdx.files.internal("BombExploding/BombExploding.atlas"));
        arlBombs = new ArrayList<Bomb>();
    }

    //Add sprites using a button: https://github.com/MatthewBrock/TheDeepDarkTaurock/tree/FireBallScratch/core/src/taurockdeepdark
    public static void makeBomb() {
        arlBombs.add(new Bomb(taBombExplode, (spBomberman.getX()+ spBomberman.getWidth()), spBomberman.getY()));
    }

    public void render() {
        //Move character based on the knob percent
        spBomberman.setX(spBomberman.getX() + TouchPad.touchpad.getKnobPercentX() * fSpeed);
        spBomberman.setY(spBomberman.getY() + TouchPad.touchpad.getKnobPercentY() * fSpeed);

        //Render each bomb in the array list
        for (int i = 0; i < arlBombs.size(); i++) {
            arlBombs.get(i).render();
            if (arlBombs.get(i).isExploded) {    //Remove bomb once animation ends
                arlBombs.remove(i);
                System.out.println("Bomb removed");
            }
        }

        batch.begin();
        spBomberman.draw(batch);
        batch.end();
    }
}
