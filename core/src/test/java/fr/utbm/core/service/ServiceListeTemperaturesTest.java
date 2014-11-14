package fr.utbm.core.service;

import fr.utbm.core.entity.Temperature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceListeTemperaturesTest
{
    @Autowired
    IServiceListeTemperatures st;

    @Test
    @Transactional
    public void testGetLastTemperatures()
    {
        List<Temperature> l = st.getLastTemperatures();
        assertNotNull(l);
    }
}
