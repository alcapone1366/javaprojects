public class MyStack
{
    private Node start;

    public MyStack(Node start)
    {
        this.start = start;
    }

    public MyStack()
    {
        this(null);
    }

    public void push(int data)
    {
        push(new Node(data));
    }

    public void push(Node input)
    {
       if (start == null)
       {
           this.start = input;
       }
       else
       {
           Node traveler = getHead();
           while(traveler.getNext() != null)
           {
               traveler= traveler.getNext();
           }
           traveler.setNext(input);
       }
    }

    public Node pop()
    {
        if(getHead() == null)
        {
            return null;
        }
        else if (getHead().getNext() == null)
        {
            Node temp = getHead();
            this.start = null;
            return temp;
        }
        else
        {
            Node temp = getHead();
            Node backup = temp;
            while(temp.getNext() != null)
            {
                backup = temp;
                temp=temp.getNext();
            }
            backup.setNext(null);
            return temp;
        }
    }

    public Node getHead()
    {
        return this.start;
    }

    @Override
    public String toString()
    {
        Node temp = start;
        String tempDisplay = "";
        while(temp != null)
        {
            tempDisplay = temp + "->";
            temp = temp.getNext();
        }
        return tempDisplay;
    }

}
