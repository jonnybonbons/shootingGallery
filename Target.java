public class Target
{
    int x,y;
    double v,theta;
    Target(int randx, int randy){
        x = randx;
        y = randy;
        v = 10;
    }

    int getX() { return x; }
    int getY() { return y; }

    void move() {
        if (x < 200) x += v;
        if (x > 200) x -= v;
    }
}