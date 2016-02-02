public class Seeking extends Target
{
    //m = 0.0;
   
    public Seeking(int x, int y, double v)
    {
       removal = false;
       this.x = x;
       this.y = y;
       m = (double)(y - 400)/(x - 400);
    }
    
    public void move()
    {
        x++;
        y += m;
        if (x > 380 && x < 420 && y > 380 && y < 420) {
            removal = true;
        }
    }
}
