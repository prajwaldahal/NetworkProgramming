package Unit9.Demo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileReadExample {

    public static void main(String[] args) {
        try {
            RandomAccessFile sampleFile = new RandomAccessFile("E:\\JavaNetworking\\src\\Unit9\\Demo\\sample.txt", "r");
            System.out.println(sampleFile.length());
            FileChannel channel = sampleFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(10);

            int nBytes = channel.read(buf);
            while (nBytes != -1) {
                System.out.println("Read " + nBytes);
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                System.out.println();
                buf.clear();
                nBytes = channel.read(buf);
            }

            sampleFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
