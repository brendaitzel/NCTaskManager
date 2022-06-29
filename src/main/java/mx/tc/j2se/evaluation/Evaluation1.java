package mx.tc.j2se.evaluation;

public  class Evaluation1 {
    public Circle[] arrayCirc = new Circle[3];
    Circle  circle = new Circle();
    Circle cir1 = new Circle();
    Circle cir2 = new Circle();
    Circle cir3 = new Circle();
    int i;

    public int biggestCircle(Circle arrayCircle){
        double a= 0;
        double comp= arrayCirc[0].getArea();
        next:
        a=arrayCirc[i].getArea();
        next:
        for (i = 1; i < 3; i++){
            comp=arrayCirc[i].getArea();
            if (comp>a){
                comp=a;
                continue next;
            }
            else continue next;

            }
           return i;
        }

        public void main(){
        cir1.setRadius(3);
        cir2.setRadius(8);
        cir3.setRadius(2);
        arrayCirc[0]=cir1;
        arrayCirc[1]=cir2;
        arrayCirc[3]=cir1;

        }

    }



