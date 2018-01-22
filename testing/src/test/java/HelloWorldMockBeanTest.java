import com.example.Controller4Testing;
import com.example.SpringBootApp4Testing;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

/**
 * Created by alex on 1/22/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringBootApp4Testing.class)
public class HelloWorldMockBeanTest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private Controller4Testing controller4Testing;

    @Before
    public void setup() {
        given(controller4Testing.sayHello(anyString())).willReturn("Are you here?");
    }

    @Test
    public void testMockBean() {
        String body = testRestTemplate.getForObject("/sayHello?name=Peter", String.class);
        assertThat(body).isEqualTo("Are you here?");
    }
}
