/*------------------------------------------------------------------------------
 -   Adapt is a Skill/Integration plugin  for Minecraft Bukkit Servers
 -   Copyright (c) 2022 Arcane Arts (Volmit Software)
 -
 -   This program is free software: you can redistribute it and/or modify
 -   it under the terms of the GNU General Public License as published by
 -   the Free Software Foundation, either version 3 of the License, or
 -   (at your option) any later version.
 -
 -   This program is distributed in the hope that it will be useful,
 -   but WITHOUT ANY WARRANTY; without even the implied warranty of
 -   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 -   GNU General Public License for more details.
 -
 -   You should have received a copy of the GNU General Public License
 -   along with this program.  If not, see <https://www.gnu.org/licenses/>.
 -----------------------------------------------------------------------------*/

package com.volmit.bit.util;

import org.bukkit.block.data.BlockData;

public interface IObjectPlacer {
    int getHighest(int x, int z);

    int getHighest(int x, int z, boolean ignoreFluid);

    void set(int x, int y, int z, BlockData d);

    BlockData get(int x, int y, int z);

    boolean isPreventingDecay();

    boolean isSolid(int x, int y, int z);

    boolean isUnderwater(int x, int z);

    int getFluidHeight();

    boolean isDebugSmartBore();
}
