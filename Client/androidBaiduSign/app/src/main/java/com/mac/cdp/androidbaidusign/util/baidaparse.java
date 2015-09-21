package com.mac.cdp.androidbaidusign.util;

/**
 * Created by cdpmac on 15/9/11.
 */
public class baidaparse {

//    private String GetTbsFromHtml(String tiebastring)throws ClientProtocolException, IOException {
//
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setDefaultCookieStore(cookies).build();
//        try {
//            HttpGet httpget = new HttpGet("http://tieba.baidu.com"+ tiebastring);
//            CloseableHttpResponse response1 = null;
//            try {
//                response1 = httpclient.execute(httpget);
//                ByteArrayInputStream bis = new ByteArrayInputStream(
//                        EntityUtils.toByteArray(response1.getEntity()));
//                String result = convertStreamToString(bis).replace("/n", "");
//                Document doc = Jsoup.parse(result);
//                String tbs = null;
//                Elements nodes = doc.head().getElementsByTag("script");
//                for (Element ele : nodes) {
//                    String text = ele.toString();
//                    int indexoftbs = text.indexOf("'tbs':");
//                    if (indexoftbs != -1) {
//                        tbs = text.substring(indexoftbs + 8, indexoftbs + 34);
//                        break;
//                    }
//                }
//                System.out.println(tbs);
//                return tbs;
//            } finally {
//                response1.close();
//            }
//        } finally {
//            httpclient.close();
//        }
//
//
//    }
//    public HashMap<String,String> GetWatchBars() throws ClientProtocolException,
//            IOException {
//        String tt = GetTimeString();
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setDefaultCookieStore(cookies).build();
//        try {
//            HttpGet httpget = new HttpGet(
//                    "http://tieba.baidu.com/f/like/mylike?v=" + tt);
//            CloseableHttpResponse response1 = null;
//            try {
//                response1 = httpclient.execute(httpget);
//                ByteArrayInputStream bis = new ByteArrayInputStream(
//                        EntityUtils.toByteArray(response1.getEntity()));
//                String result = convertStreamToString(bis).replace("/n", "");
//                return GetBarsFromHtml(result);
//
//                // System.out.println("bats html:" +result);
//
//                // Document doc = Jsoup.parse(result);
//                // JsonParser jsonparer = new
//                // JsonParser();//��ʼ������json��ʽ�Ķ���
//                // token =
//                // jsonparer.parse(ss).getAsJsonObject().get("data").getAsJsonObject().get("token").getAsString();
//                // System.out.println("cookie store:" + this.cookies);
//            } finally {
//                response1.close();
//            }
//        } finally {
//            httpclient.close();
//        }
//    }
//
//    public void SignTest(HashMap<String,String> bars) throws ClientProtocolException, IOException{
//        for (Map.Entry<String,String> ent:bars.entrySet()) {
//            if(ent.getKey()=="clannad"){
//                SignTieba(ent);
//            }
//
//
//        }
//
//    }
//    public void SignTieba(Entry<String,String> ent) throws ClientProtocolException, IOException{
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setDefaultCookieStore(cookies).build();
//        List<NameValuePair> col = new ArrayList<NameValuePair>();
//        col.add(new BasicNameValuePair("ie","utf-8"));
//        col.add(new BasicNameValuePair("kw", ent.getKey()));
//        col.add(new BasicNameValuePair("tbs", ent.getValue()));
//        try {
//            HttpPost httppost = new HttpPost("http://tieba.baidu.com/sign/add");
//            CloseableHttpResponse response1 = null;
//            try {
//                response1 = httpclient.execute(httppost);
//                ByteArrayInputStream bis = new ByteArrayInputStream(
//                        EntityUtils.toByteArray(response1.getEntity()));
//                String result = convertStreamToString(bis).replace("/n", "");
//                System.out.println(result);
//            } finally {
//                response1.close();
//            }
//        } finally {
//            httpclient.close();
//        }
//
//    }
//    public HashMap<String,String> GetWatchBars() throws ClientProtocolException,
//            IOException {
//        String tt = GetTimeString();
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setDefaultCookieStore(cookies).build();
//        try {
//            HttpGet httpget = new HttpGet(
//                    "http://tieba.baidu.com/f/like/mylike?v=" + tt);
//            CloseableHttpResponse response1 = null;
//            try {
//                response1 = httpclient.execute(httpget);
//                ByteArrayInputStream bis = new ByteArrayInputStream(
//                        EntityUtils.toByteArray(response1.getEntity()));
//                String result = convertStreamToString(bis).replace("/n", "");
//                return GetBarsFromHtml(result);
//
//                // System.out.println("bats html:" +result);
//
//                // Document doc = Jsoup.parse(result);
//                // JsonParser jsonparer = new
//                // JsonParser();//��ʼ������json��ʽ�Ķ���
//                // token =
//                // jsonparer.parse(ss).getAsJsonObject().get("data").getAsJsonObject().get("token").getAsString();
//                // System.out.println("cookie store:" + this.cookies);
//            } finally {
//                response1.close();
//            }
//        } finally {
//            httpclient.close();
//        }
//    }
//
//    private HashMap<String,String> GetBarsFromHtml(String htmlsouse) throws ClientProtocolException, IOException {
//        HashMap<String,String> bars=new HashMap<String,String>();
//        Document doc = Jsoup.parse(htmlsouse);
//        Element tabdiv = doc.getElementsByClass("forum_table").get(0);
//        // div->table->tbody
//        Element tbody = tabdiv.child(0).child(0);
//        // Document, you can get get at the data using the appropriate methods
//        // in Document and its supers Element and Node.
//        for (Node tr : tbody.childNodes()) {
//            // td->a
//            Node a = tr.childNode(0).childNode(0);
//            System.out.println(a.attr("title"));
//            bars.put(a.attr("title"),GetTbsFromHtml(a.attr("href")));
//            // ie:utf-8
//            // kw:魔兽世界
//            // tbs:9bb163bcd688548b1441963702
//
//        }
//
//
//        return bars;
//    }
//
//
//
//
//
//}
//    public String GetTbs(String htmlsource){
//        Document doc= Jsoup.parse("<!DOCTYPE html>\n" +
//                "<!--STATUS OK-->\n" +
//                "<html>\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
//                "\n" +
//                "    <title>\n" +
//                "        魔兽世界吧_百度贴吧    </title>\n" +
//                "\n" +
//                "    <script >\n" +
//                "        void function(g,f,j,c,h,d,b){g.alogObjectName=h,g[h]=g[h]||function(){(g[h].q=g[h].q||[]).push(arguments)},g[h].l=g[h].l||+new Date,d=f.createElement(j),d.async=!0,d.src=c,b=f.getElementsByTagName(j)[0],b.parentNode.insertBefore(d,b)}(window,document,\"script\",\"http://img.baidu.com/hunter/alog/alog.min.js\",\"alog\");void function(){function c(){return;}window.PDC={mark:function(a,b){alog(\"speed.set\",a,b||+new Date);alog.fire&&alog.fire(\"mark\")},init:function(a){alog(\"speed.set\",\"options\",a)},view_start:c,tti:c,page_ready:c}}();void function(n){var o=!1;n.onerror=function(n,e,t,c){var i=!0;return!e&&/^script error/i.test(n)&&(o?i=!1:o=!0),i&&alog(\"exception.send\",\"exception\",{msg:n,js:e,ln:t,col:c}),!1},alog(\"exception.on\",\"catch\",function(n){alog(\"exception.send\",\"exception\",{msg:n.msg,js:n.path,ln:n.ln,method:n.method,flag:\"catch\"})})}(window);\n" +
//                "    </script>\n" +
//                "    <link rel=\"stylesheet\" href=\"http://tb1.bdstatic.com/??/tb/static-common/style/tb.js/dialog_29a9417.css,/tb/static-common/lib/tbui/style/all_9650cff.css\" />\n" +
//                "    <link rel=\"stylesheet\" href=\"http://tb1.bdstatic.com/??/tb/_/index_7712603.css,/tb/_/search_2e2269a.css\" />\n" +
//                "    <link rel=\"shortcut icon\" href=\"http://static.tieba.baidu.com/tb/favicon.ico\"/>\n" +
//                "\n" +
//                "    <script >\n" +
//                "        // 页面的基本信息\n" +
//                "        var PageData = {\n" +
//                "            'tbs': \"8e564dd9c8134a501441963875\"    };\n" +
//                "\n" +
//                "        PageData.page = \"frs\";\n" +
//                "\n" +
//                "        // 用户的基本信息\n" +
//                "        PageData.user = {\n" +
//                "            'id': 459008503,\n" +
//                "            'name': \"\\u7d2b\\u9b42\\u9752\\u5fc3\",\n" +
//                "            'no_un': 0,\n" +
//                "            'is_login': 1,\n" +
//                "            'is_new_user': 0,\n" +
//                "            'portrait': \"f7e9d7cfbbeac7e0d0c45b1b\",\n" +
//                "            'name_url': \"%E7%B4%AB%E9%AD%82%E9%9D%92%E5%BF%83&ie=utf-8\"    };\n" +
//                "\n" +
//                "        // 吧的基本信息\n" +
//                "        PageData.forum = {\n" +
//                "            'id': 73787,\n" +
//                "            'name': \"\\u9b54\\u517d\\u4e16\\u754c\",\n" +
//                "            'first_class': \"\\u6e38\\u620f\",\n" +
//                "            'second_class': \"\\u5ba2\\u6237\\u7aef\\u7f51\\u6e38\"    };\n" +
//                "\n" +
//                "        if (Object.freeze) {\n" +
//                "            (function deepFreeze(o) {\n" +
//                "                var prop, propKey;\n" +
//                "                Object.freeze(o);\n" +
//                "                for (propKey in o) {\n" +
//                "                    prop = o[propKey];\n" +
//                "                    if (!o.hasOwnProperty(propKey) ||\n" +
//                "                            typeof prop !== 'object' ||\n" +
//                "                            !prop ||\n" +
//                "                            Object.isFrozen(prop)) {\n" +
//                "                        continue;\n" +
//                "                    }\n" +
//                "                    deepFreeze(prop);\n" +
//                "                }\n" +
//                "            })(PageData);\n" +
//                "        }\n" +
//                "    </script>\n" +
//                "\n" +
//                "    <script > alog('speed.set', 'ht', +new Date); </script>\n" +
//                "\n" +
//                "</head>\n" +
//                "\n" +
//                "<body>\n" +
//                "</body>\n" +
//                "</html>\n");
//        String tbs=null;
//        Elements nodes= doc.head().getElementsByTag("script");
//        for (Element ele:nodes) {
//            String text=ele.toString();
//            int indexoftbs=text.indexOf("'tbs':");
//            if(indexoftbs!=-1){
//                tbs=text.substring(indexoftbs+4,indexoftbs+11);
//                break;
//            }
//        }
//        return tbs;
//    }
}

