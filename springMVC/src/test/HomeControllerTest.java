import static javafx.beans.binding.Bindings.when;
import static junit.framework.TestCase.assertEquals;
import static org.easymock.EasyMock.mock;
import static org.hamcrest.Matchers.hasItems;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static
        org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import javafx.beans.value.ObservableBooleanValue;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spitter.Spittle;
import spitter.data.SpittleRepository;
import spitter.web.HomeController;
import spitter.web.SpittleController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Name: admin
 * Date: 2017/3/27
 * Time: 9:33
 */
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception{
        HomeController controller = new HomeController();
        assertEquals("home", controller.home());
    }

    @Test
    public void testHomePage2() throws Exception{
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();//搭建MockMvc

        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);//mock Repository
        when((ObservableBooleanValue) mockRepository.findSpittles(Long.MAX_VALUE, 20))
                .then(expectedSpittles);//TODO

        SpittleController controller = new SpittleController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller)
                    .setSingleView(
                            new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                    .build();
        mockMvc.perform(get("/spittles"))//对/spittles 发起GET 请求
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",
                        hasItems(expectedSpittles.toArray())));//断言期望的值

    }

    @Test
    public void shouldShowPagedSpittles() throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when((ObservableBooleanValue) mockRepository.findSpittles(238900,50))
                .then(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);


        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles?max=238900&count=50"))//传入max 和 count
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",
                        hasItems(expectedSpittles.toArray())));//断言期望的值
    }


    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i =0; i< count; i++){
            spittles.add(new Spittle("Spittle "+i, new Date()));
        }

        return spittles;
    }

}
