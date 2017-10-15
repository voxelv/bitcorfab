package com.derelictech.bitcorfab.prototyping;

import com.badlogic.gdx.math.GridPoint2;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping
 * Author:  voxelv
 * Creation Date: 2017-10-14
 * Description: Manages texture regions for a custom font. Monospace only.
 */
public class BCFTiler {
    public static final List<Character> uppercase = new ArrayList<Character>();
    public static final List<Character> lowercase = new ArrayList<Character>();
    public static final List<Character> digits = new ArrayList<Character>();
    static {
        char[] uppercaseChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] lowercaseChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] digitChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(char uppercaseChar : uppercaseChars) {
            uppercase.add(uppercaseChar);
        }
        for(char lowercaseChar : lowercaseChars) {
            lowercase.add(lowercaseChar);
        }
        for(char digitChar : digitChars) {
            digits.add(digitChar);
        }
    }

    public class BCFTilerConfig {

        abstract class BCFTileSet {}

        List<BCFTileSet> sets;

        public class BCFCharacterSet extends BCFTileSet {

            GridPoint2 start;       // Top Left pixel of the set start
            int xPad;               // Horizontal padding (usually 1 pixel)
            int height;             // Height of this set
            List<Character> chars; // Character array, Note: This also determines how many characters
                                    // are in the set.

            public BCFCharacterSet(GridPoint2 start, int xPad, int height, List<Character> chars) {
                this.start = new GridPoint2(start);
                this.xPad = xPad;
                this.height = height;
                this.chars = new ArrayList<Character>(chars);
            }
        }

        public class BCFEdgeBorderSet extends BCFTileSet {
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

            public BCFEdgeBorderSet(GridPoint2 start, int xPad, int yPad, int height) {
                this.start = new GridPoint2(start);
                this.xPad = xPad;
                this.yPad = yPad;
                this.height = height;
            }
        }

        public class BCFFillBorderSet extends BCFTileSet{
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

            public BCFFillBorderSet(GridPoint2 start, int xPad, int yPad, int height) {
                this.start = new GridPoint2(start);
                this.xPad = xPad;
                this.yPad = yPad;
                this.height = height;
            }
        }

        public BCFTilerConfig(List<BCFTileSet> sets) {
            this.sets = new ArrayList<BCFTileSet>(sets.size());
            this.sets.addAll(sets);
        }
    }

    public BCFTiler(String internalPath, BCFTilerConfig config) {
        setupTiles();
    }

    private void setupTiles() {
        // TODO: Finish
    }
}
