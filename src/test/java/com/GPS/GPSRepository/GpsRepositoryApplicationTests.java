package com.GPS.GPSRepository;

import com.GPS.GPSRepository.Commands.GPSDataCommands;
import com.GPS.GPSRepository.Repositories.GPSDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GpsRepositoryApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private GPSDataRepository gpsDataRepository;


    @Test
    void contextLoads() {
        GPSDataCommands gpsDataCommands = new GPSDataCommands();
        gpsDataCommands.setDeviceId(12345L);
        gpsDataCommands.setLatitude(505430L);
        gpsDataCommands.setLongitude(1423412L);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        try {
            mockMvc.perform(post("/api")
                            .contentType("application/json")
                            .content(ow.writeValueAsString(gpsDataCommands)))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.isTrue(gpsDataRepository.findGPSDataByDeviceId(12345L).isPresent(), "After operation GPSData should be present");
    }

    @Test
    void nullTest() {
        GPSDataCommands gpsDataCommands = new GPSDataCommands();
        gpsDataCommands.setDeviceId(12345L);
        gpsDataCommands.setLatitude(505430L);
        gpsDataCommands.setLongitude(null);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        try {
            postPreform(ow,gpsDataCommands).andExpect(status().isNotAcceptable());
            gpsDataCommands.setLatitude(null);
            postPreform(ow,gpsDataCommands).andExpect(status().isNotAcceptable());
            gpsDataCommands.setDeviceId(null);
            postPreform(ow,gpsDataCommands).andExpect(status().isNotAcceptable());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    ResultActions postPreform(ObjectWriter ow, GPSDataCommands gpsDataCommands) throws Exception {
        return mockMvc.perform(post("/api")
                        .contentType("application/json")
                        .content(ow.writeValueAsString(gpsDataCommands)));
    }
}
