package com.volmit.bit;

import com.google.gson.Gson;
import com.volmit.bit.util.IO;
import com.volmit.bit.util.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
public class BitConfig {
    private static BitConfig config = null;
    @Setter
    @Getter
    private boolean verbose = false;

    public static BitConfig get() {
        if (config == null) {
            BitConfig dummy = new BitConfig();
            File l = Bit.instance.getDataFile("adapt", "adapt.json");


            if (!l.exists()) {
                try {
                    IO.writeAll(l, new JSONObject(new Gson().toJson(dummy)).toString(4));
                } catch (IOException e) {
                    e.printStackTrace();
                    config = dummy;
                    return dummy;
                }
            }

            try {
                config = new Gson().fromJson(IO.readAll(l), BitConfig.class);
                IO.writeAll(l, new JSONObject(new Gson().toJson(config)).toString(4));
            } catch (IOException e) {
                e.printStackTrace();
                config = new BitConfig();
            }
        }

        return config;
    }
}
