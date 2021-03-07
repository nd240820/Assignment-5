package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.Stone;
import kz.aitu.oop.practice.assignment5.entities.Necklace;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IStoneRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class NecklaceRepository implements IStoneRepository {
    private final IDB db;

    public NecklaceRepository(IDB db) {
        this.db = db;
    }

    @Override
    public List<Stone> getAllStones() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,cost,weight FROM stones";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Stone> stones = new LinkedList<>();
            while (rs.next()) {

                /*
                outputting column's records
                 */
                Stone stone = new Stone(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost"),
                        rs.getInt("weight"));

                stones.add(stone);
            }

            return stones;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Necklace> getAllNecklaces() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,cost,weight FROM necklace";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Necklace> necklaces = new LinkedList<>();
            while (rs.next()) {

                /*
                outputting column's records
                 */
                Necklace necklace = new Necklace(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost"),
                        rs.getDouble("weight"));

                necklaces.add(necklace);
            }

            return necklaces;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


}
