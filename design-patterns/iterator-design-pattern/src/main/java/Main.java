import datastructures.BinaryTree;
import datastructures.LinkedList;
import datastructures.PlayList;
import models.Song;
import iterators.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("LinkedList Iteration:");
        LinkedList linkedList = new LinkedList(1);
        linkedList.next = new LinkedList(2);
        linkedList.next.next = new LinkedList(3);
        
        Iterator<Integer> iterator = linkedList.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
        System.out.println("\nBinaryTree Iteration:");
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(3);
        
        Iterator<Integer> iterator2 = binaryTree.getIterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        System.out.println("\nPlaylist Iteration:");
        PlayList playlist = new PlayList();
        playlist.addSong(new Song(101, 180));
        playlist.addSong(new Song(102, 240));
        playlist.addSong(new Song(103, 200));

        Iterator<Song> playlistIterator = playlist.getIterator();
        while(playlistIterator.hasNext()){
            Song song = playlistIterator.next();
            System.out.println("Song ID: " + song.getName() + ", Duration: " + song.getDuration() + "s");
        }
    }
}
