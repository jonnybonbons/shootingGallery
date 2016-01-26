
public class Horizontal extends Target
{
    int m = 0;
    public Horizontal(int x, int y, int m) 
    {
        this.x = x;
        this.y = y;
        this.m = m;
    }
    public void move()
    {
       m = (double)(y-250)/(x-500);
       
    }
}
