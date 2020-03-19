package fr.upec.app;

import java.util.Arrays;

/**
 * HashLinearProbing
 * 
 * @author Abdoul Mouctar DIALLO
 */
public class HashLinearProbing {
    private String[] keys;
    private String[] values;

    private static final int MAX_SIZE = 6;

    private int inserted = 0;

    HashLinearProbing() {
        keys = new String[MAX_SIZE];
        values = new String[MAX_SIZE];
    }

    public void put(String key, String value) {

        if (inserted >= MAX_SIZE)
            return;

        int index = hash(key);
        while (keys[index] != null) {
            index = (index + 1) % MAX_SIZE;
        }

        keys[index] = key;
        values[index] = value;

        inserted++;
    }

    public String get(String key) {
        int index = hash(key);
        String value = null;

        while (keys[index] != null && keys[index] != key) {
            index = (index + 1) % MAX_SIZE;
        }

        if (keys[index] == key)
            value = values[index];

        return value;
    }

    protected int hash(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++)
            hash += key.charAt(i);

        return hash % MAX_SIZE;
    }

    public void remove(String key) {
        int index = this.hash(key);

        while (keys[index] != null && keys[index] != key) {
            index = (index + 1) % MAX_SIZE;
        }

        if (keys[index] != null)
            inserted--;

        keys[index] = null;
        values[index] = null;

        this.rehashFrom((index + 1) % MAX_SIZE);
    }

    private void rehashFrom(int index) {
        String tmp_key;
        String tmp_value;

        while (keys[index] != null) {

            tmp_key = keys[index];
            tmp_value = values[index];

            keys[index] = null;
            values[index] = null;

            this.put(tmp_key, tmp_value);

            index = (index + 1) % MAX_SIZE;
        }
    }

    @Override
    public String toString() {
        return "KEYS: " + Arrays.toString(this.keys) + " \n" + "VALUES: " + Arrays.toString(this.values) + " \n";
    }
}