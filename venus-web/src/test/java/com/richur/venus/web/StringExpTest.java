package com.richur.venus.web;

/**
 * @Author Richur
 * @Date 2020/1/13 3:44 下午
 */
public class StringExpTest {

    public static void main(String[] args) {
//
        //String eventId = "pgc.pgc-video-detail.collection-popwindow.2.click";//community.pgc-video-detail.mode9-button.0.click
        String pvEventId = "pgc.pgc-video-detail.0.0.pv";

        String eventId = "community.pgc-video-detail.mode9-button.0.click";//main.space-like-video.button.0.click,main.space-like-video.video.0.click
        //String pvEventId = "main.space-like-video.0.0.click";
        String env = "uat";

        if(env == "uat") {
//            for(int i = 0; i < 24 ;i++) {
//                if(i < 10) {
//                    clickData("202001150"+i, "193", "500", eventId);
//                } else {
//                    clickData("20200115"+i, "193", "500", eventId);
//                }
//            }
            System.out.println();
//            for(int i = 0; i < 24 ;i++) {
//                if(i < 10) {
//                    pvData("202001150"+i, "193", "499", pvEventId);
//                } else {
//                    pvData("20200115"+i, "193", "499", pvEventId);
//                }
//            }
            //pvData("20200114010","193","499",pvEventId);
            System.out.println();
            for(int i = 0; i < 24 ;i++) {
                if (i < 10) {
                    uvData("202001150" + i, "193", "499", pvEventId);
                } else {
                    uvData("20200115" + i, "193", "499", pvEventId);
                }
            }

                    //uvData("20200114010","193","499","");
        }else {
            //test
            clickData("20200113010", "154", "434", eventId);
            System.out.println();
            //pvData("20200113010", "154", "435", pvEventId);
            System.out.println();
            //uvData("20200113010", "154", "435", "");
        }

    }


    private static void clickData(String date, String expId, String groupId, String eventId){

        String str1 = "insert into tb_ab_posteriori_statistics_minute (log_date,expr_id,group_id,event_id,index_type,index_value) values ('"+ date;

        String str2 = "',"+expId +","+groupId+",'"+eventId+"',0,";

        String str3 = ");";

        for(int i = 0; i < 60; i++){
            if(i<10) {
                System.out.println(str1+ "0" + i + str2 + (215 + 70 * i + i) + str3);
            } else {
                System.out.println(str1 + i + str2 + (215 + 70 * i + i) + str3);
            }
        }
    }

    private static void pvData(String date, String expId, String groupId, String eventId){

        String str1 = "insert into tb_ab_posteriori_statistics_minute (log_date,expr_id,group_id,event_id,index_type,index_value) values ('"+ date;

        String str2 = "',"+expId +","+groupId+",'"+eventId+"',10,";

        String str3 = ");";

        for(int i = 0; i < 60; i++){
            if(i<10) {
                System.out.println(str1+ "0" + i + str2 + (515 + 70 * i + i) + str3);
            } else {
                System.out.println(str1 + i + str2 + (515 + 70 * i + i) + str3);
            }
        }
    }

    private static void uvData(String date, String expId, String groupId, String eventId){

        String str1 = "insert into tb_ab_posteriori_statistics_minute (log_date,expr_id,group_id,event_id,index_type,index_value) values ('"+ date;

        String str2 = "',"+expId +","+groupId+",'"+eventId+"',11,";

        String str3 = ");";

        for(int i = 0; i < 60; i++){
            if(i<10) {
                System.out.println(str1+ "0" + i + str2 + (215 + 70 * i + i) + str3);
            } else {
                System.out.println(str1 + i + str2 + (215 + 70 * i + i) + str3);
            }
        }
    }
}
