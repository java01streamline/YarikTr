/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translieter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 1
 */
public class Translieter {

    /**
     * @param args the command line arguments
     */
    static ArrayList<String> english = new ArrayList<String>();
    static ArrayList<String> russian = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File f = new File("D:\\Java - Wonsevich\\Translieter\\src\\translieter\\words.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));

        String str;
        while ((str = br.readLine()) != null) {
            String en = str.substring(0, str.indexOf("-")).replace("\t", "");
            english.add(en);
            String ru = str.substring(str.indexOf("-") + 1).replace("\t", "").trim();
            russian.add(ru);
        }

        new Main().setVisible(true);
    }
    public static String ok = "";

    /*public static String findEn(String wordEN) {
        String ret = null;
        //implementetion search

        for (int i = 0; i < english.size(); i++) {
            if (russian.get(i).equals(Main.s)) {

                ret = english.get(i);

                break;

            }
        }

        return ret;
    }*/

    public static String findRus(String wordRU) {
        String ret = null;
        //implementetion search

        for (int i = 0; i < russian.size(); i++) {
            if (english.get(i).equals(wordRU)) {

                ret = russian.get(i);
                break;
            }
        }

        return ret;
    }

    public static String findRusEN(String word) {
        String ret = "Not found";
        for (int i = 0; i < russian.size(); i++) {
            if (russian.get(i).equals(word)) {
                return english.get(i);
            }
            if(english.get(i).equals(word)){
                return russian.get(i);
            }
        }
        return ret;
    }

}
