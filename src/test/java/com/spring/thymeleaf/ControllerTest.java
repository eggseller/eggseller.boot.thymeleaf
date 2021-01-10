package com.spring.thymeleaf;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import com.spring.thymeleaf.controller.DefaultController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import javafx.application.Application;

@ContextConfiguration(classes = ComSpringThymeleafApplication.class)
@RunWith(SpringRunner.class)
// @WebMvcTest(controllers = DefaultController.class)
public class ControllerTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void testSqlConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println("url" + connection.getMetaData().getURL());
        System.out.println("username" + connection.getMetaData().getUserName());
    }

    // @Autowired
    // private MockMvc mockMvc;

    // 200 OK BUT 404 Error
    // @Test
    // public void hello() throws Exception {
    // mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk()).andDo(print())
    // .andExpect(view().name("welcome")).andExpect(model().attribute("tasks",
    // is("Hello World!!!!!")));
    // }

    // List<String> expectedList = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    // @Test
    // public void main() throws Exception {
    // ResultActions resultActions =
    // mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
    // .andExpect(view().name("welcome")).andExpect(model().attribute("message",
    // equalTo("Mkyong")))
    // .andExpect(model().attribute("tasks", is(expectedList)))
    // .andExpect(content().string(containsString("Hello, World")));

    // MvcResult mvcResult = resultActions.andReturn();
    // ModelAndView mv = mvcResult.getModelAndView();
    // //
    // }

    // // Get request with Param
    // @Test
    // public void hello() throws Exception {
    // mockMvc.perform(get("/hello").param("name", "I Love
    // Kotlin!")).andExpect(status().isOk())
    // .andExpect(view().name("welcome")).andExpect(model().attribute("message",
    // equalTo("I Love Kotlin!")))
    // .andExpect(content().string(containsString("Hello, I Love Kotlin!")));
    // }
}
