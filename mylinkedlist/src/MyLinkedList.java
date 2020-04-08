public class MyLinkedList
{
    private Node head = null;

    public MyLinkedList(Node head)
    {
        this.head = head;
    }

    public MyLinkedList()
    {
    }

    public void insert(Node inputNode)
    {
        if(this.head == null)
            this.head = inputNode;
        else
        {
            Node cursor = this.head;
            while (cursor.getNext() != null)
                cursor = cursor.getNext();

            cursor.setNext(inputNode);
        }
    }

    public void show()
    {
        if (this.head == null)
            return;
        Node traveller = this.head;

        while (traveller != null)
        {
            System.out.print(traveller.getValue() + " => ") ;
            traveller = traveller.getNext();
        }
        System.out.println("null");
    }

    public Node getHead()
    {
        return head;
    }

    public void setHead(Node head)
    {
        this.head = head;
    }
}
