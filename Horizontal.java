
public class Horizontal extends Target
{
    int vx;
    public Horizontal(int x, int y, int vx) 
    {
        this.x = x;
        this.y = y;
        this.vx = vx;
    }

    public void move()
    {
        x += vx;
        if (x >= 500)
        {
            vx = -vx;
            x = 499;
        }
        if (x <= 300)
        {
            vx = -vx;
            x = 301;
        }
    }
}
