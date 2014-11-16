package fr.utbm.core.service;

import fr.utbm.core.entity.Temperature;
import org.exolab.castor.types.DateTime;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
        List<Temperature> lastTemps = st.getLastTemperatures();
        List<Temperature> lastTempsStation1 = st.getTemperatures(1);
        Date d2 = new Date();
        calendar.set(2014,Calendar.OCTOBER,1);
        Date d = calendar.getTime();
        List<Temperature> allTemps = st.getLastFilteredTemperatures(d,d2);
        List<Temperature> allTempsStation1 = st.getFilteredTemperatures(d,d2,1);

        Assert.assertNotNull(lastTemps);
        Assert.assertNotNull(lastTempsStation1);
        Assert.assertNotNull(allTemps);
        Assert.assertNotNull(allTempsStation1);
        Assert.assertNotNull(allTempsStation1);
    }
}
