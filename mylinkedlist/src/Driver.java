public class Driver
{
    public static void main(String[] args)
    {
        Node a1 = new Node(2);
        Node a2 = new Node(4);
        Node a3 = new Node(6);
        Node a4 = new Node(8);
        Node a5 = new Node(10);
        Node a6 = new Node(12);
        Node a7 = new Node(16);
        Node a8 = new Node(20);
        Node a9 = new Node(24);
        Node a10 = new Node(28);
        Node a11 = new Node(32);
        Node a12 = new Node(40);
        Node a13 = new Node(48);
        Node a14 = new Node(60);
        Node a15 = new Node(72);


        // first list
        MyLinkedList secondList = new MyLinkedList();
        secondList.insert(a1);
        secondList.insert(a2);
        secondList.insert(a3);
        secondList.insert(a4);
        secondList.insert(a5);
        secondList.insert(a6);
        secondList.insert(a7);
        secondList.insert(a8);
        secondList.insert(a9);
        secondList.insert(a10);
        secondList.insert(a11);
        secondList.insert(a12);
        secondList.insert(a13);
        secondList.insert(a14);
        secondList.insert(a15);

        secondList.show();

        Node b1 = new Node(3);
        Node b2 = new Node(5);
        Node b3 = new Node(7);
        Node b4 = new Node(11);
        Node b5 = new Node(25);
        Node b6 = new Node(33);
        Node b7 = new Node(41);
        Node b8 = new Node(45);
        Node b9 = new Node(46);
        // first list
        MyLinkedList firstList = new MyLinkedList();
        firstList.insert(b1);
        firstList.insert(b2);
        firstList.insert(b3);
        firstList.insert(b4);
        firstList.insert(b5);
        firstList.insert(b6);
        firstList.insert(b7);
        firstList.insert(b8);
        firstList.insert(b9);

        firstList.show();

        reconstructor(firstList, secondList);


    }

    static void reconstructor(MyLinkedList firstOne, MyLinkedList secondOne)
    {
        Node firstCursor = firstOne.getHead();
        Node secondCursor = secondOne.getHead();
        Node newListCursor = null;

//        if (firstCursor.getValue() < secondCursor.getValue())
//            newListCursor = firstCursor;
//        else
//            newListCursor = secondCursor;
//
//        newListCursor.setNext(null);
        MyLinkedList finalList = new MyLinkedList(newListCursor);

        while (firstCursor != null && secondCursor!= null)
        {
            if (firstCursor.getValue() < secondCursor.getValue())
            {
                newListCursor = firstCursor;
                firstCursor = firstCursor.getNext();


            } else
            {
                newListCursor = secondCursor;
                secondCursor = secondCursor.getNext();

            }
            newListCursor.setNext(null);
            finalList.insert(newListCursor);
        }

        if (firstCursor == null)

        {
            while (secondCursor != null)
            {
                newListCursor = secondCursor;
                secondCursor = secondCursor.getNext();
                newListCursor.setNext(null);
                finalList.insert(newListCursor);
            }
        }
        if (secondCursor == null)

        {
            while (firstCursor != null)
            {
                newListCursor = firstCursor;
                firstCursor = firstCursor.getNext();
                newListCursor.setNext(null);
                finalList.insert(newListCursor);
            }
        }
        finalList.show();

    }
}
