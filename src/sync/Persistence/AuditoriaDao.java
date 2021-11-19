/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sync.Persistence;

import Utils.NewHibernateUtil;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
/**
 *
 * @author joao
 */
public class AuditoriaDao
{
    
    public HashMap<String, BigInteger> findNumberByTables()
    {
        Session sessao = NewHibernateUtil.getSessionFactory().openSession();
        HashMap<String, BigInteger> map = new HashMap<>();
        try
        {
            Iterator results = sessao.createSQLQuery(
                    "select table_name, count(*) as num \n"
                    + "from audit_log \n"
                    + "group by table_name ")
                    .list()
                    .iterator();

            while (results.hasNext())
            {
                Object[] row = (Object[]) results.next(); // pego a linha inteira
                map.put(String.valueOf(row[0]), (BigInteger) row[1]);
            }
            return map;

        }catch(HibernateException hibEx)
        {
            hibEx.printStackTrace();
        }finally
        {
            sessao.close();
        }

        return null;
    }
}