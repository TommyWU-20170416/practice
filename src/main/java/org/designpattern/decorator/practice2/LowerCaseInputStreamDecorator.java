package org.designpattern.decorator.practice2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 實作一個自己的 InputStream
 * Q: 這麼多 InputStream，為什麼選擇 FilterInputStream
 */
public class LowerCaseInputStreamDecorator extends FilterInputStream {

    // 因為 FilterInputStream 沒有 constructor 所以強迫子類要實現
    // super 可獲取父類的 constructor
    protected LowerCaseInputStreamDecorator(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = in.read(); // Q: 這邊的 in 會是哪個子類
        return c == -1 ? c : Character.toLowerCase(c);
    }

}
