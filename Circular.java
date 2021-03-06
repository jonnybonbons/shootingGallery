
public class Circular extends Target
{ 
    int m;
    int n;
    public Circular(int x, int y, int m, int n, double theta, int r)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.m = m;
        this.n = n;
        this.theta = theta;
    }

    
    void move()
    {
        theta += .1;
        x = m + (int)(r * Math.cos(theta));
        y = n + (int)(r * Math.sin(theta));
    }
}
