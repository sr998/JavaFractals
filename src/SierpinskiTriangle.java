import java.awt.*;
import java.awt.geom.Path2D;


public class SierpinskiTriangle extends SierpinskiMain
{
    void drawTriangle(Graphics2D g, int x, int y, int size)
    {
        if (size <= limit)
        {
            Path2D p = new Path2D.Float();
            p.moveTo(x, y);
            p.lineTo(x + size / 2,y + size);
            p.lineTo(x - size / 2,y + size);

            g.fill(p);


        } else {
            size /= 2;
            drawTriangle(g, x, y, size);
            drawTriangle(g, x + size /2,y + size, size);
            drawTriangle(g, x - size /2,y + size, size);

        }
    }

    @Override
    public void paintComponent(Graphics gg)
    {
       int n=0;
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.translate(margin, margin);
        drawTriangle(g, dimension / 2, 0, dimension);
    }
}
