package com.derelictech.bitcorfab.ui.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Json;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.ui.data
 * Author:  voxelv
 * Creation Date: 2017-10-15
 * Description: Manages TextureRegions for a handmade texture atlas (especially for pixel fonts)
 */
public class BCFTiler implements Disposable{
    private Texture texture;
    private BCFTilerJsonData jsonData;
    private Map<Integer, TextureRegion> idRegions;
    private Map<Character, TextureRegion> characterRegions;

    public BCFTiler(String internalJsonPath) {
        Json json = new Json();
        json.setElementType(BCFTilerJsonData.class, "sets", BCFTileSetJsonData.class);
        jsonData = json.fromJson(BCFTilerJsonData.class, Gdx.files.internal(internalJsonPath));

        texture = new Texture(Gdx.files.internal(jsonData.texturefile));

        idRegions = new HashMap<Integer, TextureRegion>();
        characterRegions = new HashMap<Character, TextureRegion>();

        setupTiles();
    }

    private void setupTiles() {
        int id = 0;
        for(String setName : this.jsonData.sets.keySet()) {
            BCFTileSetJsonData setData = this.jsonData.sets.get(setName);

            // Acquire the region with the tileset
            TextureRegion tileset = new TextureRegion(
                    texture,
                    setData.startX,
                    setData.startY,
                    (setData.width + setData.xPad) * setData.cols,
                    (setData.height + setData.yPad) * setData.rows
            );

            // Split the tileset into its individual regions
            TextureRegion[][] splitRegions = tileset.split((setData.width + setData.xPad), (setData.height + setData.yPad));

            if(setData.isOnKeyboard) {
                // Add each region to the idRegions map and characterRegions map
                for(TextureRegion[] regionRow : splitRegions) {
                    int idx = 0;
                    for(TextureRegion region : regionRow) {
                        idRegions.put(id++, region);
                        characterRegions.put(setData.characters.charAt(idx++), region);
                    }
                } // End for regionRows
            } // End if isOnKeyboard true
            else {
                // Add each region to just the idRegions map
                for(TextureRegion[] regionRow : splitRegions) {
                    for(TextureRegion region : regionRow) {
                        idRegions.put(id++, region);
                    }
                } // End for regionRows
            } // End if isOnKeyboard false
        } // End for tileset
    }

    public TextureRegion[] regionsFromString(String string) {
        TextureRegion[] retArray = new TextureRegion[string.length()];
        int i = 0;
        for(Character c : string.toCharArray()) {
            retArray[i++] = characterRegions.get(c);
        }
        return retArray;
    }

    /**
     * Get the dimensions of a string after being drawn
     * @param string the {@link String} to get the dimensions of
     * @return the dimensions of the string as a {@link Vector2}
     */
    public Vector2 getDimensions(String string) {
        float w = 0.0f, h = 0.0f;
        for(Character c : string.toCharArray()) {
            if(!characterRegions.containsKey(c)) {
                continue;
            }

            TextureRegion tr = characterRegions.get(c);
            w += tr.getRegionWidth();

            float height = tr.getRegionHeight();
            if(height > h) {
                h = height;
            }
        }
        return new Vector2(w, h);
    }

    /**
     * Get the dimensions of a character
     * @param c the {@link Character} to get the dimensions of
     * @return the dimensions of the character as a {@link Vector2}
     */
    public Vector2 getCharacterDimensions(Character c) {
        if(characterRegions.containsKey(c)) {
            TextureRegion tr = characterRegions.get(c);
            return new Vector2(tr.getRegionWidth(), tr.getRegionHeight());
        }
        else
        {
            return new Vector2(0.0f, 0.0f);
        }
    }

    /**
     * Draws a string.
     * @param batch: The {@link Batch} to draw to
     * @param string: The string to draw
     * @param x: x position to draw at
     * @param y: y position to draw at
     */
    public void draw(Batch batch, String string, float x, float y, float scale, float rotation) {
        float xpos = x;
        for(Character c : string.toCharArray()) {
            if(!characterRegions.containsKey(c)) {
                continue;
            }
            TextureRegion tr = characterRegions.get(c);
            batch.draw(tr, xpos, y, 0, 0, tr.getRegionWidth(), tr.getRegionHeight(), scale, scale, rotation);
            xpos += scale * tr.getRegionWidth();
        }
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
