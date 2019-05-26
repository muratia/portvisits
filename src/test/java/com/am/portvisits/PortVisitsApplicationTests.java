package com.am.portvisits;


import com.am.portvisits.service.PortVisitsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PortVisitsApplicationTests {

    private MockMvc mockMvc;

    @InjectMocks
    private PortVisitsService portVisitsService;

    @Before
    private void setUp() throws  Exception{
        mockMvc = MockMvcBuilders.standaloneSetup (portVisitsService).build ();
    }

    @Test
    public void contextLoads()  throws  Exception {

        String uri = "http://localhost:8080/api/vesseltracking/vesselsatportadtime";



     /*  assertThat( mockMvc.perform(mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .param("portId", "2").param ("date", "2016-01-01")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect (status().is))*/

    }








}
