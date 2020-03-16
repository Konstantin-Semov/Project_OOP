import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Test_Conn {
    public static void main(String[] args) {

       /* Car_Brand brand = new Car_Brand("Audi");

        Car_Model model = new Car_Model("A4", brand, fuel);
        Car_Model model2 = new Car_Model("A5", brand, fuel);
        Set<Car_Model> models = new HashSet<>();
        models.add(model);
        models.add(model2);*/

  //      bmrand.setModels(models);
//        fuel.setModels(models);


        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            //get session
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            System.out.println("Session created");
            //start transaction
            tx = session.beginTransaction();

            Fuel_Type fuel = new Fuel_Type();
            List fuel_type = session.createQuery("FROM Fuel_Type").list();
            for(Iterator iterator = fuel_type.iterator(); iterator.hasNext();){
                Fuel_Type fuel_type1 = (Fuel_Type) iterator.next();
                        if(Objects.equals(fuel_type1.getFuel_type_name(), new String("Diesel"))){
                            fuel = fuel_type1;
                           System.out.println("Fuel: " + fuel.getFuel_type_name()
                           +"\n" + "ID: " + fuel.getFuel_type_id());
                        }
            }

           /* Car_Brand brand = new Car_Brand("Audi");

            Car_Model model = new Car_Model("A4", brand, fuel);
            Car_Model model2 = new Car_Model("A5", brand, fuel);
            Set<Car_Model> models = new HashSet<>();
            models.add(model);
            models.add(model2);

            brand.setModels(models);
            fuel.setModels(models);

            //Save the model object
            //session.save(fuel);
            session.save(brand);
            session.save(model);
            session.save(model2);*/
            //Commit current transaction
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.out.println("Exception occured "+e.getMessage());
            e.printStackTrace();
        }finally {
            if(sessionFactory != null){
                System.out.println("Closing Session factory.");
                //session.close();
                sessionFactory.close();
            }
        }

        System.out.println("success");


    }

    }



