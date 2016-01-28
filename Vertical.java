public class Vertical extends Target
{
    int vy;
    public Vertical(int x, int y, int vy)
    {
        this.x = x;
        this.y = y;
        this.vy = vy;

    }

    void move()
    {
        y += vy;
        if (y >= 1000) 
        {
            vy = -vy;
            y = 999;
        }
        if (y <= 700)
        {
            vy = -vy;
            y = 701;
        }
    }
}

