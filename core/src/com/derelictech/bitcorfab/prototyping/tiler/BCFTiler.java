package com.derelictech.bitcorfab.prototyping.tiler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Json;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping.tiler
 * Author:  voxelv
 * Creation Date: 2017-10-15
 * Description: Manages TextureRegions for a handmade texture atlas (especially for pixel fonts)
 */
public class BCFTiler {
    private BCFTilerJsonData jsonData;
    private Map<Integer, TextureRegion> idRegions;
    private Map<Character, TextureRegion> characterRegions;

    public BCFTiler(String internalJsonPath) {
        Json json = new Json();
        json.setElementType(BCFTilerJsonData.class, "sets", BCFTileSetJsonData.class);
        jsonData = json.fromJson(BCFTilerJsonData.class, Gdx.files.internal(internalJsonPath));

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
                    new Texture(Gdx.files.internal(jsonData.texturefile)),
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
}
