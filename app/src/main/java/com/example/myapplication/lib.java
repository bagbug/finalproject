package com.example.myapplication;

import java.io.File;
import java.net.URL;

public class lib {
    URL url =getClass().getResource("head.JPG");
    File file = new File(url.getPath());
    public boolean returnTrue(boolean a) {
        if (a == true) {
            return true;
        }
        return false;
    }
}
