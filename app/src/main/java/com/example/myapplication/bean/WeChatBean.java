package com.example.myapplication.bean;

import java.util.List;

public class WeChatBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2019-07-13","title":"美国对台军售，哪些企业将被中国制裁？","description":"环球网","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/qkQTRn2Z9NwBChxtpyjnsAh0LqTDibX7icfYgUwAQNo1mYlogmwVx3nuiblnZDdexcTwrZdcBoylUMicucRZIHOicwQ/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&amp;timestamp=1562985015&amp;ver=1725&amp;signature=axRw1IhpHZ0cAWR8PeJU4tZs4cRef3SrzSSZbzvNuaC2auoJykc5GzEtApVddIYeSZarI8DXVsLOSfI1i7q6v0yZtCLnhI0pafi8KGhASphTmlb1MVKUw37cCDFKlEtO&amp;new=1"},{"ctime":"2019-07-13","title":"今年「超长三伏」来了！暑、湿、热三邪交织，谨记这三条才能平安度过这40天！","description":"素问轩","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/X0F9HHk8ZGD1XpYib8xXicvhicNuzicadoicbHVWbiaMDhKu9wv1ogPII0DFkyricYpxia5BqgYr5ueLW2hDgkmpwoHOCA/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&amp;timestamp=1562981402&amp;ver=1725&amp;signature=sE1TF6axGJw*BM6Qzl6ZiEE94VRujWFEDE9djvQ5krvzjxY9oi8QQP*4eJQKau6ui7GzP7AZqA7MvTbbHJe*Ou7rJ1SpURZb7it3Elha8fmymv3zUFj3beUZiz2GgQgt&amp;new=1"},{"ctime":"2019-07-13","title":"与其限制西医开中药，更应明确中药副作用，而不是不详！","description":"医院院长","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/RiabhHt2ncYhqxZeFArOG5LKHIicHVqUnNHNtplUJ3Bd2YSIUG4hVJJ1VYoDkQHPIaqgd7Qgz3YOnTQbIffJ1uTg/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&amp;timestamp=1562981402&amp;ver=1725&amp;signature=Lx4Z5kdsR70AmCcYTtlA*8j5tVBZ3TESmu7hctrjqOCBnA1jSXK5llc74CBHGBxIvZGmZTuOiLDK-DhAyVFtcljizujO3b9aG-cJleOFUYlwAGDBVuOglYK*5EOtRLk9&amp;new=1"},{"ctime":"2019-07-13","title":"倒计时！科创板首批上市25家企业\u201c大阅兵\u201d 北上广三地占据半壁江山","description":"华夏时报","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/lW26NpKtIOmEhv5Wib6yvL52VpHkFiaoACug9ChNt7PibUKkKpZtKSia9ODqU7mbu7r6UjiaJAk0UN8Ffej1fazL3Aw/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&amp;timestamp=1562981405&amp;ver=1725&amp;signature=L6XSRSwOctpgK5UcRDH4cQ76y7gweM0amguoSw5xYv0VzTEAM4vE96F25obaxHx9Z4FakSiS4zkVe0*4ItbFvX8zCPjlrnxpQBXGX0H42NXAz7vNwYJ99BeVgPpRzU2p&amp;new=1"},{"ctime":"2019-07-13","title":"7月新能源车价调查，大多数维持原价，买这些车就赚到了","description":"爱买车","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/dxLia315UyzYe5xEEnoiaOPYp39DHoXe3tphnjiaia10R3jnLRIjandnMWzpRBmAOPUZFfhCbxSlezGhick5ZUI5gaw/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&amp;timestamp=1562981407&amp;ver=1725&amp;signature=x1atRkZ295mZtsdNXPwcPagNt7-bu*G5omA8Pm9hGOlfvLm2BIAoi0L6VynpvQhFvcF0Wpk-zAAMEdxJo4oHz2CvRaqPF1fY6AWBKPIZe6fgzhs8jQM5JKgBu9Lk5Qoy&amp;new=1"},{"ctime":"2019-07-13","title":"女护士汗液变成粉红色，只因爱吃这种零食\u2026\u2026","description":"我是科学家iScientist","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/N2EssTUQcONjywibf4iahrY5PTxMhaJyUhia5mecbR5mVo5mOtxxoiciaEkZeRumn99NoAFNPAlKG6uoLEm7or9dAOQ/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?__biz=MzI0MzA3OTI1MA==&amp;mid=2651610172&amp;idx=1&amp;sn=08a454dd6e5fe181abbeb3314e20afe3&amp;chksm=f28a7d01c5fdf4173064d08edc1814542ee107da410803a94831b4144e1fe5804ad03a7a7958&amp;scene=21&amp;token=2040692621&amp;lang=zh_CN#wechat_redirect"},{"ctime":"2019-07-13","title":"普通体检究竟能不能查出癌症？云姐姐今天告诉你真相！","description":"SBS大健康","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/Rg4yDs3siaj5emPfTOlIiclUn1caD0rmujKGxnPa1tG9qZI5JPmEvibZYdVOdx37H6mb6KRxWjJiaQyB67R1A5icmkg/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&amp;timestamp=1562981402&amp;ver=1725&amp;signature=1enD3DCv5*8WY482iUJXpq4oJqWO04cZV-OSTjBN90iPq0GMKTin*NiS10Z8GptYiuGmegUl8Dc-t8F6rnmewWQUbvJePuAKniuxNwVMofRwQ62qr*W2p9X2N7wNp71-&amp;new=1"},{"ctime":"2019-07-13","title":"\u201c老师\u201d不是teacher！\u200b这么多年的老师都叫错了！哼\u2026\u2026","description":"实战英语口语交流","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/gfr0kXkWGuwnRib0AePvUEwwNrseJibH0n5wic0icXfuuYtKFQPjOAyZOyGXiadWjricicah95ZOPyECBHqlZ9kmibW15g/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&amp;timestamp=1562981413&amp;ver=1725&amp;signature=knIVZMXb9xfF2iDDut9uISAYLSYKe9DlVixZGgwCewOMs1rRjFu8xyPDM0sH7sLgsQ6YM5SC-ZhMHni54mcMUW4cFezXv-IZTjXSTRH-KeK3Ye0L*KTiYCgO5yASQ43d&amp;new=1"},{"ctime":"2019-07-13","title":"今日Nature综述：小分子靶向微生物组，最新的管线全在这里了！","description":"药明康德","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/FcLK21Ir4gPWDiavKR9zEaRCMhoDaDibuMzdK9mVWVXKLctPnh7B7Ekl96IlticnlXjTKKzjq2p0SooqQI0B7icllQ/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&amp;timestamp=1562981402&amp;ver=1725&amp;signature=w9BuEnzmUsLgDhXDZlwrhJQ-SkTwdQqjuLzA0Gm*D6ODojureRPQpBWAjsI4-zwYGFdRV0K4cA-5Q*60MfvkdxPz0BvNFqqStYd2Qca*cIuFLjsg-HFNbXUJ9lyeuEFT&amp;new=1"},{"ctime":"2019-07-13","title":"6分钟高燃励志短片：你连开始都没有，还谈什么成功","description":"培训人社区","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/wicSEx7Lrss1VwcGuD94Ky9m1oCVltkI1k0rPtuF14GKwP2cZj8wHPBYpN4wZbTg2FrZeohXULP5jYzzGLUUg6w/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?__biz=Mzg2NTE4NjE1Nw==&amp;mid=2247483678&amp;idx=1&amp;sn=d8eec163f1eb4af368665a097b5e1bd8&amp;chksm=ce5cb91cf92b300a77f0cc2073b576d761c7a07afddaacb4cbf8b52f25f3f5c8106861dfdb22&amp;scene=21&amp;token=1442799928&amp;lang=zh_CN#wechat_redirect"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2019-07-13
         * title : 美国对台军售，哪些企业将被中国制裁？
         * description : 环球网
         * picUrl : http://mmbiz.qpic.cn/mmbiz_jpg/qkQTRn2Z9NwBChxtpyjnsAh0LqTDibX7icfYgUwAQNo1mYlogmwVx3nuiblnZDdexcTwrZdcBoylUMicucRZIHOicwQ/0?wx_fmt=jpeg
         * url : https://mp.weixin.qq.com/s?src=11&amp;timestamp=1562985015&amp;ver=1725&amp;signature=axRw1IhpHZ0cAWR8PeJU4tZs4cRef3SrzSSZbzvNuaC2auoJykc5GzEtApVddIYeSZarI8DXVsLOSfI1i7q6v0yZtCLnhI0pafi8KGhASphTmlb1MVKUw37cCDFKlEtO&amp;new=1
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
