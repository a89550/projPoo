public class GPS {
    private double x;
    private double y;

    public GPS(){
        this.x = 0;
        this.y = 0;
    }

    public GPS(double x, double y){
        this.x = x;
        this.y = y;
    }

    public GPS(GPS g){
        this.x = g.getX();
        this.y = g.getY();
    }

    public double getX(){
        return this.x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return this.y;
    }

    public void setY(double y){
        this.y = y;
    }

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        GPS le = (GPS) obj;
        return le.getX()==(this.x) &&
                le.getY()==(this.y);
    }

    public String toString(){
        String s = this.x + "," + this.y + ",";
        return s;
    }

    public GPS clone(){
        return new GPS(this);
    }
}
