public void delete( Player p) {
    if( head == null) { return; }
    else {
        Node prev = null;
        Node curr = head;
        while((curr.next != null) && (!curr.data.equals(p))) {
            prev = curr;
            curr = curr.next;
        }
        if(curr.data.equals(p)) {
            if ( curr == head) { head.next = curr.next; numItems...; }
            else { prev.next = curr.next; }
            numItems...;
        }
    }
}
