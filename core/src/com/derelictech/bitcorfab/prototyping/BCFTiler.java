package com.derelictech.bitcorfab.prototyping;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping
 * Author:  voxelv
 * Creation Date: 2017-10-14
 * Description: Manages texture regions for a custom font. Monospace only.
 */
public class BCFTiler {

    private Texture texture;
    private BCFTilerConfig config;
    private HashMap<String, HashMap<Integer, TextureRegion>> sets;

    public static class BCFTilerConfig {

        public static abstract class BCFTileSet {
            public String setName;
            public BCFTileSet(String setName) {
                this.setName = setName;
            }

            public abstract HashMap<Integer, TextureRegion> genRegions(Texture texture);
            public abstract boolean isCharacterSet();
        }

        List<BCFTileSet> sets;

        public static class BCFCharacterSet extends BCFTileSet {

            GridPoint2 start;       // Top Left pixel of the set start
            int xPad;               // Horizontal padding (usually 1 pixel)
            int width;              // Width of each character
            int height;             // Height of this set
            List<Character> chars;  // Character array, Note: This also determines how many characters are in the set.

            public BCFCharacterSet(String setName, GridPoint2 start, int xPad, int width, int height, List<Character> chars) {
                super(setName);
                this.start = new GridPoint2(start);
                this.xPad = xPad;
                this.height = height;
                this.chars = new ArrayList<Character>(chars);
            }

            @Override
            public HashMap<Integer, TextureRegion> genRegions(Texture texture) {
                HashMap<Integer, TextureRegion> regions = new HashMap<Integer, TextureRegion>();

                TextureRegion setRegion = new TextureRegion(texture, this.start.x, this.start.y, this.chars.size() * (this.width + this.xPad), this.height);

                TextureRegion[][] splitRegions = setRegion.split((this.width + this.xPad), this.height);

                int idx = 0;
                for(TextureRegion tr : splitRegions[0]) {
                    // Trim the padding off
                    tr.setRegionWidth(this.width);
                    tr.setRegionHeight(this.height);

                    // Add to the hashmap
                    regions.put(idx++, tr);
                }

                return regions;
            }

            @Override
            public boolean isCharacterSet() {
                return true;
            }
        }

        public static class BCFEdgeBorderSet extends BCFTileSet {
            /**
             * An Edge Border Set is a 4x4 grid where the connections to each side is enumerated.
             * The column determines the Right and Top side connections:     ____ ___R __T_ __TR
             * The row determines the Left and Bottom connections:
             *      ____       _________________________________
             *      _L__      |The entire grid should look like     ____ ___R __T_ __TR
             *      B___      |this in the image file:              _L__ _L_R _LT_ _LTR
             *      BL__                                            B___ B__R B_T_ B_TR
             *                                                      BL__ BL_R BLT_ BLTR
             */

            GridPoint2 start;   // Top Left pixel of the set start
            int xPad;           // Horizontal padding (usually 1 pixel)
            int yPad;           // Vertical padding (usually 1 pixel)
            int height;         // Height of this set

            public BCFEdgeBorderSet(String setName, GridPoint2 start, int xPad, int yPad, int height) {
                super(setName);
                this.start = new GridPoint2(start);
                this.xPad = xPad;
                this.yPad = yPad;
                this.height = height;
            }

            @Override
            public HashMap<Integer, TextureRegion> genRegions(Texture texture) {
                //TODO
                return null;
            }

            @Override
            public boolean isCharacterSet() {
                return false;
            }
        }

        public static class BCFFillBorderSet extends BCFTileSet{
            /**
             * A Fill Border Set is a 4x4 grid where the connections to each side is enumerated.
             * There is less intuition for a fill border set. Basically if there's a corner,
             * then the inside of the corner is filled in. "C" means it's a normal corner.
             * "I" means it's an inverted corner, and the specified sides are filled.
             * "T" means it's a "T" intersect, and the entire half of the character where the
             * trunk of the "T" points is filled.
             * See {@link BCFEdgeBorderSet} for an idea of how to interpret this:
             *                      _____ IB__R IBL__ C__TR
             *                      I_LT_ _____ C_LT_ T_LTR
             *                      I__TR CB__R _____ TB_TR
             *                      CBL__ TBL_R TBLT_ TBLTR     Note: TBLTR is full fill.
             */

            GridPoint2 start;   // Top Left pixel of the set start
            int xPad;           // Horizontal padding (usually 1 pixel)
            int yPad;           // Vertical padding (usually 1 pixel)
            int height;         // Height of this set

            public BCFFillBorderSet(String setName, GridPoint2 start, int xPad, int yPad, int height) {
                super(setName);
                this.start = new GridPoint2(start);
                this.xPad = xPad;
                this.yPad = yPad;
                this.height = height;
            }

            @Override
            public HashMap<Integer, TextureRegion> genRegions(Texture texture) {
                //TODO
                return null;
            }

            @Override
            public boolean isCharacterSet() {
                return false;
            }
        }

        public BCFTilerConfig(List<BCFTileSet> sets) {
            this.sets = new ArrayList<BCFTileSet>(sets.size());
            this.sets.addAll(sets);
        }
    }

    public BCFTiler(String internalPath, BCFTilerConfig config) {
        this.texture = new Texture(Gdx.files.internal(internalPath));
        this.config = config;
        this.sets = new HashMap<String, HashMap<Integer, TextureRegion>>();

        setupTiles();
    }

    private void setupTiles() {
        for(BCFTilerConfig.BCFTileSet tileSet : config.sets) {
            sets.put(tileSet.setName, tileSet.genRegions(texture));
        }
    }

    public TextureRegion getRegion(String setName, int id) {
        return sets.get(setName).get(id);
    }
}


