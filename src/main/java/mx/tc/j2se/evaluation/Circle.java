package mx.tc.j2se.evaluation;

public  class Circle {
     double radius,area;

    public double radio1 (double radio){
        radius=1;

        return radius;
    }

    public void  setRadius(double radius){
        this.radius=radius;
        if (radius<=0){
            try{
                this.radius=radius;
            } catch(IllegalArgumentException e){
                radius=1;

            } finally{
                System.out.print("El radio era negativo, se estableció en 1");
            }
        }

    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        double pi;
        //this.radius=radius;
        pi=Math.PI;
        area=pi*Math.pow(radius,2);
        return area;
    }

}
