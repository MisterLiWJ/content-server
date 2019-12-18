package shop.tanjie.content.contentserver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import shop.tanjie.content.contentserver.utils.JSONUtil;

/**
 * @Author: Chenjz
 * @Date: 2019/1/9 18:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreTest {

    @Test
    public void contextLoads() {
    }

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private WebApplicationContext context;


    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * 请求的接口
     * @param url - 接口地址
     * @param parmes - 参数
     * @param type - 返回的数据类型
     * @throws Exception
     */
    public void request(String url, String parmes, String type) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url).content(parmes))
                .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
                .andExpect(MockMvcResultMatchers.content().contentType(type))//预期返回值的类型text/josn
                .andReturn();
        System.out.println("打印当前结果：\n"+mvcResult.getResponse().getContentAsString());
    }


    /**
     * 请求接口 - POST
     * @param url - 接口地址
     * @param parmes - 参数
     * @param reqType - 参数的形式
     * @param type - 返回的数据类型
     * @throws Exception
     */
    public void request(String url, Object parmes, MediaType reqType, String type) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url).accept(reqType).contentType(reqType).content(JSONUtil.toJSON(parmes)))
                .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
                .andExpect(MockMvcResultMatchers.content().contentType(type))//预期返回值的类型text/josn
                .andReturn();
        System.out.println("打印当前结果：\n"+mvcResult.getResponse().getContentAsString());
    }

    /**
     * 请求接口 - POST
     * @param url - 接口地址
     * @param parmes - 参数
     * @param reqType - 参数的形式
     * @param type - 返回的数据类型
     * @throws Exception
     */
    public void request(String url, String parmes, MediaType reqType, String type) throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url).accept(reqType).contentType(reqType).content(parmes))
                .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
                .andExpect(MockMvcResultMatchers.content().contentType(type))//预期返回值的类型text/josn
                .andReturn();
        System.out.println("打印当前结果：\n"+mvcResult.getResponse().getContentAsString());
    }

}
