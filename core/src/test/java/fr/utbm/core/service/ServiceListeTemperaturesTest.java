package fr.utbm.core.service;

import fr.utbm.core.entity.Temperature;
import fr.utbm.core.model.Wendu;
import org.exolab.castor.types.DateTime;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceListeTemperaturesTest
{
    @Autowired
    IServiceListeTemperatures st;

    @Test
    public void testGetLastTemperatures()
    {
        Calendar calendar = Calendar.getInstance();
        ArrayList<Wendu> lastTemps = st.getLastTemperatures();
        ArrayList<Wendu> lastTempsStation1 = st.getTemperatures(1);
        Date d2 = new Date();
        calendar.set(1960,Calendar.OCTOBER,1);
        Date d = calendar.getTime();
        ArrayList<Wendu> allTempsStation1 = st.getFilteredTemperatures(d,d2,1);

        Assert.assertNotNull(lastTemps);
        Assert.assertNotNull(lastTempsStation1);
        Assert.assertNotNull(allTempsStation1);
    }
}
