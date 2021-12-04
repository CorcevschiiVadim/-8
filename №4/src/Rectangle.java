import com.sun.deploy.security.SelectableSecurityManager;

public class Rectangle {
    float length, width;
    public void Rectangle() {
        length = 1.0f;
        width = 1.0f;
    }

    public float perimeter() {
        return 2*(length + width);
    }

    public float area() {
        return (length * width);
    }

    public void setLength(float len) {
        if (len > 0.0f && len < 20.0f)
        length = len;
        else
            System.out.println("Invalid Length");
        }

        public void setWidth(float wid)
        {
            if (wid > 0.0f && wid < 20.0f)
                width = wid;
            else
                System.out.println("Invalid width");
        }

        public float getLength() {
        return length;
        }

        public float getWidth() {
        return width;
        }
}
