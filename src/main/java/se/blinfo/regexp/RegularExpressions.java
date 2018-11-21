package se.blinfo.regexp;

import java.io.File;

/**
 *
 * @author hl
 */
public class RegularExpressions {

    /**
     * Run this to update the README file
     *
     * @param args
     */
    public static void main(String[] args) {
        new RegExpValidate().run();
        System.out.println("Updated Readme:");
        new RegExpMarkdown(new File("/home/hl/NetBeansProjects/RegularExpressions/README.md")).write();
    }
}
