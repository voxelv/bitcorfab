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
public class BCFFont {

    public class BCFFontCnfg {

        public class BCFCharacterSet {

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

        public class BCFBorderSet {
            /**
             * A Border Set is a 4x4 grid where the connections to each side is enumerated.
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

            public BCFBorderSet(GridPoint2 start, int xPad, int yPad, int height) {
                this.start = new GridPoint2(start);
                this.xPad = xPad;
                this.yPad = yPad;
                this.height = height;
            }
        }

        public class BCFFillBorderSet {
//            "Internal" corners are placed near
//             * their complementary normal corners. An "Internal" corner is preceded with "I".
//                    * Absence of "I" is marked with "-". A "T" intersect of borders means that half of
//             * the character is filled. The side with the trunk of the "T" will be filled.

            /**
             * A Fill Border Set is a 4x4 grid where the connections to each side is enumerated.
             * There is less intuition for a fill border set. Basically if there's a corner,
             * then the inside of the corner is filled in. "C" means it's a normal corner.
             * "I" means it's an inverted corner, and the specified sides are filled.
             * "T" means it's a "T" intersect, and the entire half of the character where the
             * trunk of the "T" points is filled.
             * See {@link BCFBorderSet} for an idea of how to interpret this:
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


    }

    public BCFFont(String internalPath, BCFFontCnfg config) {

    }
}
