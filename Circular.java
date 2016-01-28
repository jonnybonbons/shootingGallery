
public class Circular extends Target
{ 
    
    public Circular(int x, int y, double theta, int r)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.theta = theta;
    }

    
    void move()
    {
        theta += .1;
        x = (int)(r * Math.cos(theta));
        y = (int)(r * Math.sin(theta));
    }
}
