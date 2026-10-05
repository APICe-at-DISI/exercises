package it.unibo.quality;

public class cat {
//this class describes a cat

    



public String Name, Color, Breed;
public int Age;


private static int  NINE = 9;
static public  int numberoflives= NINE;

public cat(String meow,
final String c,final int age,
final String korat) {
    this.Name =meow ;
    Color=c  ;
    this.Age=age;
    Breed= korat;
}

// This method is useful because it allows the cat to meow and introduce itself to the world in a single line of code.
    public String
    Meow()
    {return "Meow, meow, I am " + Name + ", hear me purr, In this feline world, I'm the star, that's for sure. With whiskers long and fur so sleek, I'm here to share my story, so take a peek!";
}public



void setcolor(String c) {
    this.Color = 
    c;
}

    public String GET_COLOR() {
return this.Color;
    }

    public int hasSameColor( cat  cat )
    {
if (Color==cat.Color) {return   1;}else{return 0;}
    }

String name( )
{
    return Name;
}


String BREED( )

{
    return 
    this.Breed;
}

public
static
void
main(
    String[] ARGS
) {
    cat cat = new cat(
        "Kiri",
        "Gray",
        4, "Kor"+
         "at");

    IO.
    println(cat.Meow());
}
        }