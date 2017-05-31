package com.chuizi.wensente.model.repo;

import java.util.List;

/**
 *
 */
public class beanResp {


    /**
     * page_size : 15
     * start : 0
     * data : [{"id":1,"limit":10,"cut":2,"city_id":1},{"id":2,"limit":20,"cut":10,"city_id":1}]
     * total_count : 2
     * total_page_count : 1
     * current_page_no : 1
     * previous_page : 1
     * next_page : 1
     */

    private int page_size;
    private int start;
    private int total_count;
    private int total_page_count;
    private int current_page_no;
    private int previous_page;
    private int next_page;
    /**
     * id : 1
     * limit : 10.0
     * cut : 2.0
     * city_id : 1
     */

    private List<DataBean> data;

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getTotal_page_count() {
        return total_page_count;
    }

    public void setTotal_page_count(int total_page_count) {
        this.total_page_count = total_page_count;
    }

    public int getCurrent_page_no() {
        return current_page_no;
    }

    public void setCurrent_page_no(int current_page_no) {
        this.current_page_no = current_page_no;
    }

    public int getPrevious_page() {
        return previous_page;
    }

    public void setPrevious_page(int previous_page) {
        this.previous_page = previous_page;
    }

    public int getNext_page() {
        return next_page;
    }

    public void setNext_page(int next_page) {
        this.next_page = next_page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    /**
     * {"id":32,"name":"宝马","image":"http://114.55.4.234:22222/image/shuaiche/image/carCategory/32/77fd1ca9af3747879e2a30dc0ae832fe.jpg","parent_id":0,"is_hot":1}
     */
    public static class DataBean {

        /**
         * id : 32
         * name : 宝马
         * image : http://114.55.4.234:22222/image/shuaiche/image/carCategory/32/77fd1ca9af3747879e2a30dc0ae832fe.jpg
         * parent_id : 0
         * is_hot : 1
         */

        private int id;
        private String name;
        private String image;
        private int parent_id;
        private int is_hot;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public int getIs_hot() {
            return is_hot;
        }

        public void setIs_hot(int is_hot) {
            this.is_hot = is_hot;
        }
    }
}
