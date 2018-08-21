package com.pxf.project.common.util;


import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SerializeUtil {
    public SerializeUtil() {
    }

    public static byte[] serialize(Object obj) throws IOException {
        if (obj == null) {
            throw new NullPointerException();
        } else {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            HessianOutput ho = new HessianOutput(os);
            ho.writeObject(obj);
            return os.toByteArray();
        }
    }

    public static Object deserialize(byte[] by) throws IOException {
        if (by == null) {
            throw new NullPointerException();
        } else {
            ByteArrayInputStream is = new ByteArrayInputStream(by);
            HessianInput hi = new HessianInput(is);
            return hi.readObject();
        }
    }
}
