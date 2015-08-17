package com.namlh.daogenerator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Main {

    public static void main(String args[]) throws Exception{
        Schema schema = new Schema(1,"com.namlh.sandocu.data.dao.model");
        Entity item = schema.addEntity("HuntedItem");
        item.addIdProperty();
        item.addStringProperty("title");
        item.addDoubleProperty("price");
        item.addStringProperty("cover");
        item.addDateProperty("createdAt");

        new DaoGenerator().generateAll(schema,"../app/src/main/java");
    }
}
