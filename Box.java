import java.util.ArrayList;

public class Box<T extends Fruct> {

    ArrayList<Fruct> fructs = new ArrayList();
    public String boxtype;

    public void addFruit(Fruct fruct)
    {
        if(this.isEmpty()) 
        {
            fructs.add(fruct);
            this.boxtype = fruct.getClass().getSimpleName();
        } else {
            if(boxtype == fruct.getClass().getSimpleName())
                fructs.add(fruct);
            else System.out.printf("You can't add %s into the %s box, sorry\n",fruct.getClass().getSimpleName(),boxtype);
        }
    }

    public boolean isEmpty()
    {
        return fructs.size()==0;
    }

    public int getQuantity()
    {
        return fructs.size();
    }

    public void spillTo(Box box)
    {
        if(box.isEmpty()) box.boxtype = this.boxtype;
        if(box.boxtype == this.boxtype)
        {
            for(int i=0;i<fructs.size();i++)
            {
                 box.addFruit(fructs.get(i));
            }
            fructs.clear();
        } else System.out.printf("You can't add %s into the %s box, sorry\n",box.boxtype,boxtype);
    }

    public float getWeight() {
        float rs = 0.0f;
        for(Fruct fruct:fructs) rs += fruct.getWeight();
        return rs;
    }

    public boolean compare(Box b) {
        return this.getWeight() == b.getWeight();
    } 

    public Box copy() {
        Box b = new Box();
        b.fructs = fructs;
        return b;
    }

}
