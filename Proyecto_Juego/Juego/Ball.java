import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private static final int MAXSIZE = 100;
    private int speed;
    
    
    public Ball(int direction)
    {
        setMyImage();
        setRotation(direction);
        speed = Greenfoot.getRandomNumber(5)+1;
    }
    
    private void setMyImage()
    {
        GreenfootImage imagen = new GreenfootImage(MAXSIZE, MAXSIZE);
        imagen.setColor(randomColor());
        int size = Greenfoot.getRandomNumber(MAXSIZE);
        imagen.fillOval(0, 0, size, size);
        setImage(imagen);
    }
    
    private Color randomColor()
    {
        int r = Greenfoot.getRandomNumber(256);
        int g = Greenfoot.getRandomNumber(256);
        int y = Greenfoot.getRandomNumber(256);
        int alpha = Greenfoot.getRandomNumber(256);
        
        return new Color(r,g,y,alpha);
        
    }
    public void act()
    {
        move(speed);
        if (atWorldEdge()){
            turn(153);
        }
        changeTransparency();
    }
    
    void changeTransparency()
    {
        GreenfootImage imagen = getImage();
        int alpha = imagen.getTransparency();
        if (alpha > 0){
            imagen.setTransparency(alpha-1);
        }
        else{
            getWorld().removeObject(this);
        }
    }
    
    public boolean atWorldEdge()
    {
        if(getX() < 10 || getX() > getWorld().getWidth() - 10)
            return true;
        if(getY() < 10 || getY() > getWorld().getHeight() - 10)
            return true;
        else 
            return false;
    }
}
