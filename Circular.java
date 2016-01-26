
public class Circular extends Target
{ 
    
    public Circular(int x, int y, int theta, int m, int n, int r)
    {
        this.x = x;
        this.y = y;
        this.m = m;
        this.n = n;
        this.r = r;
        this.theta = theta;
    }

    
    void move()
    {
        x = (int)(m + r * Math.cos(theta));
        y = (int)(n + r * Math.sin(theta));
    }
}
