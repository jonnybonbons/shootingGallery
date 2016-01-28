
public class Horizontal extends Target
{
    int m = 0;
    int vx;
    public Horizontal(int x, int y, int m) 
    {
        this.x = x;
        this.y = y;
        this.vx = vx;
    }

    public void move()
    {
        x += vx;
        if (x >= 700)
        {
            vx = -vx;
            x = 699;
        }
        if (x <= 400)
        {
            vx = -vx;
            x = 401;
        }
    }
}
