//package com.nj.admin;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * @description:
// * @author: endure
// * @create: 2020-08-04 15:36
// **/
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = AdminwebApplication.class)
//public class JunitTest {
//
//    @Test
//    public void test(){
//        KdGoldAPIDemo kdGoldAPIDemo = new KdGoldAPIDemo();
//        try {
//            String retJson = kdGoldAPIDemo.orderOnlineByJson();
//            System.out.println("返回结果："+retJson);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testQuery(){
//        KdniaoTrackQueryAPI kdGoldAPIDemo = new KdniaoTrackQueryAPI();
//        try {
//            String retJson = kdGoldAPIDemo.getOrderTracesByJson("ANE","012657700387");
//            System.out.println("返回结果："+retJson);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testPickUp(){
//        KdniaoPickUpDemo kdGoldAPIDemo = new KdniaoPickUpDemo();
//        try {
//            String retJson = kdGoldAPIDemo.orderOnlineByJson();
//            System.out.println("返回结果："+retJson);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
