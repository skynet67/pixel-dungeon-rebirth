/*
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.watabou.gltextures;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.watabou.gdx.Bitmap;

public class Gradient extends SmartTexture {

    public Gradient(int colors[]) {

        super(createTexture(colors));

        filter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        wrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);

        TextureCache.add(Gradient.class, this);
    }

    private static Bitmap createTexture(int[] colors) {
        final Pixmap pixmap = new Pixmap(colors.length, 1, Pixmap.Format.RGBA8888);
        for (int i = 0; i < colors.length; i++) {
            final int color = colors[i];
            pixmap.drawPixel(i, 0, (color << 8) | (color >>> 24));
        }
        return new Bitmap(pixmap);
    }
}