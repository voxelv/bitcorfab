package com.derelictech.bitcorfab.prototyping;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping
 * Author:  voxelv
 * Creation Date: 2017-10-14
 * Description: Manages texture regions for a custom font. Monospace only.
 */
public class BCFFont {

    public class BCFFontCnfg {

        public class BCFFontCharacterSet {

            GridPoint2 start;   // Top Left pixel of the set start
            int xPad;           // Horizontal padding (usually 1 pixel)
            int height;         // Height of this set
            int numChars;       // Number of characters (usually 26 letters, or 10 numbers

            public BCFFontCharacterSet(GridPoint2 start, int xPad, int height, int numChars) {
                this.start = new GridPoint2(start);
                this.xPad = xPad;
                this.height = height;
                this.numChars = numChars;
            }
        }

        public class BCFFontBorderSet {
            /**
             * A border set is a 4x4 grid where the connections to each side is enumerated.
             * The column determines the Right and Top side connections:     ____ ___R __T_ __TR
             * The row determines the Left and Bottom connections:
             *      ____       _________________________________
             *      _L__       The entire grid should look like:    ____ ___R __T_ __TR
             *      B___                                            _L__ _L_R _LT_ _LTR
             *      BL__                                            B___ B__R B_T_ B_TR
             *                                                      BL__ BL_R BLT_ BLTR
             */

            GridPoint2 start;   // Top Left pixel of the set start
            int xPad;           // Horizontal padding (usually 1 pixel)
            int yPad;           // Vertical padding (usually 1 pixel)
            int height;         // Height of this set

            public BCFFontBorderSet(GridPoint2 start, int xPad, int yPad, int height) {
                this.start = new GridPoint2(start);
                this.xPad = xPad;
                this.yPad = yPad;
                this.height = height;
            }
        }


    }

    public BCFFont(String internalPath, BCFFontCnfg config) {

    }
}
