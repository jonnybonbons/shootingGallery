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
        if (y <= 200) 
        {
            vy = -vy;
            y = 201;
        }
        if (y >= 400)
        {
            vy = -vy;
            y = 399;
        }
    }
}

