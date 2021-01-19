package com.shop.model

data class HomeData(
        val banner: List<Banner>,
        val brandList: List<Brand>,
        val categoryList: List<Category>,
        val channel: List<Channel>,
        val hotGoodsList: List<HotGoods>,
        val newGoodsList: List<NewGoods>,
        val topicList: List<Topic>
){
    data class HotGoods(
            val goods_brief: String,
            val id: Int,
            val list_pic_url: String,
            val name: String,
            val retail_price: String
    )

    data class Brand(
            val app_list_pic_url: String,
            val floor_price: String,
            val id: Int,
            val is_new: Int,
            val is_show: Int,
            val list_pic_url: String,
            val name: String,
            val new_pic_url: String,
            val new_sort_order: Int,
            val pic_url: String,
            val simple_desc: String,
            val sort_order: Int
    )

    data class Channel(
            val categoryid: Int,
            val icon_url: String,
            val id: Int,
            val name: String,
            val sort_order: Int,
            val url: String
    )

    data class Category(
            val goodsList: List<Goods>,
            val id: Int,
            val name: String
    )

    data class Goods(
            val id: Int,
            val list_pic_url: String,
            val name: String,
            val retail_price: String
    )

    data class Topic(
            val avatar: String,
            val content: String,
            val id: Int,
            val is_show: Int,
            val item_pic_url: String,
            val price_info: String,
            val read_count: String,
            val scene_pic_url: String,
            val sort_order: Int,
            val subtitle: String,
            val title: String,
            val topic_category_id: Int,
            val topic_tag_id: Int,
            val topic_template_id: Int
    )

    data class NewGoods(
            val id: Int,
            val list_pic_url: String,
            val name: String,
            val retail_price: String
    )

    data class Banner(
            val ad_position_id: Int,
            val content: String,
            val enabled: Int,
            val end_time: Int,
            val id: Int,
            val image_url: String,
            val link: String,
            val media_type: Int,
            val name: String
    )
}



