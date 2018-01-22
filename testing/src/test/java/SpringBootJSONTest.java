/**
 * Created by alex on 1/22/18.
 */

import com.example.Course;
import com.example.SpringBootApp4Testing;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.json.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApp4Testing.class)
@JsonTest()
public class SpringBootJSONTest {

    @Autowired
    private JacksonTester<Course> json;

    @Test
    public void testSerialize() throws Exception {
        String content = "{\"name\":\"Micro Services\",\"lecturer\":\"Alex\"}";
        Course details = new Course("Micro Services", "Alex");

        assertThat(this.json.write(details)).isEqualToJson(content);
        assertThat(this.json.write(details)).hasJsonPathStringValue("@.name");
        assertThat(this.json.write(details)).extractingJsonPathStringValue("@.name")
                .isEqualTo("Micro Services");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"name\":\"Yoga\",\"lecturer\":\"Coach\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new Course("Yoga", "Coach"));
        assertThat(this.json.parseObject(content).getLecturer()).isEqualTo("Coach");
    }

}