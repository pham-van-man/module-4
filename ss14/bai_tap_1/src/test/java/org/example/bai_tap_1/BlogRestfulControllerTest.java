package org.example.bai_tap_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.bai_tap_1.model.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BlogRestfulControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(roles = "USER")
    public void getInfoBlog() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/blog/{id}", 1))
                .andDo(print())
                .andExpect(status()
                        .is2xxSuccessful())
                .andExpect(jsonPath("$.id")
                        .value(1))
                .andExpect(jsonPath("$.title")
                        .value("abc"));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void createBlog() throws Exception {
        Blog blog = new Blog();
        blog.setTitle("abc");
        blog.setContent("abc");
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/blog")
                        .content(objectMapper.writeValueAsString(blog))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status()
                        .is2xxSuccessful());
    }
}
