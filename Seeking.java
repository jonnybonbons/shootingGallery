public class Seeking extends Target
{
    double m;
    int v = 0;
    public Seeking(int x, int y, int v)
    {
       this.x = x;
       this.y = y;
       m = (double)(y - 400)/(x - 400);
    }
    
    public void move()
    {
        x += m;
        y += m*x;
//         if (x > 380 && x < 420 && y > 380 && y < 420) {
//             
//         }
    }
}
