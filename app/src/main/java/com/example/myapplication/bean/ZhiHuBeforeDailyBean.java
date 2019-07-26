package com.example.myapplication.bean;

import java.util.List;

public class ZhiHuBeforeDailyBean {

    /**
     * date : 20190605
     * stories : [{"images":["https://pic4.zhimg.com/v2-a2de987a8cdc3bd40ad6ad824b1e3347.jpg"],"type":0,"id":9712276,"ga_prefix":"060522","title":"小事 · 你好，李华"},{"images":["https://pic2.zhimg.com/v2-cc71f88003172dd03a6d19e9b8cf9c51.jpg"],"type":0,"id":9712090,"ga_prefix":"060520","title":"《寄生虫》拿下戛纳金棕榈，是冥冥中的必然"},{"images":["https://pic4.zhimg.com/v2-24b6e91d7e8d542b03a7fede5a012913.jpg"],"type":0,"id":9712118,"ga_prefix":"060516","title":"写在全结局通关《隐形守护者》之后"},{"images":["https://pic2.zhimg.com/v2-bf447f5ac8778bc64837313139c407e9.jpg"],"type":0,"id":9712073,"ga_prefix":"060509","title":"「看电影」的能力，是需要学习的吗？"},{"images":["https://pic4.zhimg.com/v2-3093fb85665fa8c3e8f7ba005ec17f8b.jpg"],"type":0,"id":9712231,"ga_prefix":"060507","title":"为什么苹果会发布 Pro Display XDR？"},{"images":["https://pic1.zhimg.com/v2-ea02f5da298586bc1ca0c44395dc62b0.jpg"],"type":0,"id":9712097,"ga_prefix":"060506","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-a2de987a8cdc3bd40ad6ad824b1e3347.jpg"]
         * type : 0
         * id : 9712276
         * ga_prefix : 060522
         * title : 小事 · 你好，李华
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
