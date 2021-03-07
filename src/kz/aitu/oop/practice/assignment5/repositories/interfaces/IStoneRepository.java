package kz.aitu.oop.practice.assignment5.repositories.interfaces;

import kz.aitu.oop.practice.assignment5.entities.Stone;
import kz.aitu.oop.practice.assignment5.entities.Necklace;

import java.util.List;

public interface IStoneRepository {

    /*
    interface
     */

    List<Stone> getAllStones();

    List<Necklace> getAllNecklaces();

}
