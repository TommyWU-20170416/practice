package org.designpattern.decorator.practice2;

import java.io.*;

public class InputTest {
    public static void main(String[] args) {
        int c;

        try {
            InputStream in = new LowerCaseInputStreamDecorator(new BufferedInputStream(new FileInputStream("src/main/java/org/designpattern/decorator/practice2/test.txt")));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            System.out.println();

            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
