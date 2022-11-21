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

import com.volmit.adapt.Adapt;

public abstract class Looper extends Thread {
    public void run() {
        while (!interrupted()) {
            try {
                long m = loop();

                if (m < 0) {
                    break;
                }

                Thread.sleep(m);
            } catch (InterruptedException e) {
                break;
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        Adapt.info("Thread " + getName() + " Shutdown.");
    }

    protected abstract long loop();
}
