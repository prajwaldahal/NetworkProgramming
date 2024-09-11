package Unit9.Buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferDemo {
    public static void main(String[] args) {
        // Creating Buffers
        ByteBuffer buffer = ByteBuffer.allocate(15);
        System.out.println("Buffer created with capacity: " + buffer.capacity());

        // Filling Buffers
        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
        }
        System.out.println("Buffer after filling: " + buffer);

        // Draining Buffers
        buffer.flip(); // Switch to read mode
        System.out.println("Buffer after draining: " + buffer);
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }
        System.out.println();

        // Bulk Methods
        buffer.clear();
        byte[] data = {10, 20, 30, 40, 50};
        buffer.put(data);
        buffer.flip();
        ByteBuffer copyBuffer = ByteBuffer.allocate(buffer.remaining());
        copyBuffer.put(buffer);
        copyBuffer.flip();
        System.out.print("Copied buffer contents: ");
        while (copyBuffer.hasRemaining()) {
            System.out.print(copyBuffer.get() + " ");
        }
        System.out.println();

        // Data Conversion
        buffer.clear();
        buffer.putInt(123456);
        buffer.putDouble(3.14159);
        buffer.flip();
        System.out.println("Int value: " + buffer.getInt());
        System.out.println("Double value: " + buffer.getDouble());

        // View Buffers
        buffer.clear();
        CharBuffer charBufferView = buffer.asCharBuffer();
        charBufferView.put("Hello");
        buffer.flip();
        CharBuffer viewBuffer = buffer.asCharBuffer();
        System.out.println("View buffer as CharBuffer: " + viewBuffer.toString());

        // Compacting Buffers
        buffer.clear();
        buffer.put(new byte[]{1, 2, 3, 4, 5});
        buffer.flip();
        buffer.get(); // Read one byte
        buffer=buffer.compact();
        System.out.print("Compacted buffer contents: ");
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }
        System.out.println();

        // Duplicating Buffers
        buffer.clear();
        buffer.put(new byte[]{6, 7, 8, 9});
        buffer.flip();
        ByteBuffer duplicateBuffer = buffer.duplicate();
        System.out.println("Original buffer: " + buffer);
        System.out.println("Duplicate buffer: " + duplicateBuffer);

        // Slicing Buffers
        buffer.clear();
        buffer.put(new byte[]{10, 11, 12, 13, 14});
        buffer.flip();
        ByteBuffer slice = buffer.slice();
        slice.limit(3); // Limit slice to 3 bytes
        System.out.print("Slice buffer contents: ");
        while (slice.hasRemaining()) {
            System.out.print(slice.get() + " ");
        }
        System.out.println();

        // Marking and Resetting
        buffer.clear();
        buffer.put(new byte[]{20, 30, 40, 50});
        buffer.flip();
        buffer.mark();
        System.out.println("Position before reset: " + buffer.position());
        buffer.get(); // Read one byte
        buffer.reset();
        System.out.println("Position after reset: " + buffer.position());

        // Object Methods
        System.out.println("Buffer hashCode: " + buffer.hashCode());
        System.out.println("Buffer equals its duplicate? " + buffer.equals(duplicateBuffer));
        System.out.println("Buffer toString: " + buffer.toString());
    }
}
