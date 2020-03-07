package com.liuxiankai.blog.po;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liuxiankai
 */
@Data
@Entity
@Table(name = "t_blog")
public class Blog {

    /**
     * id: 博客编号
     * title: 博客标题
     * content: 博客内容
     * firstPicture: 博客首图
     * flag: 博客来源-----转载/原创/翻译
     * views: 博客观看次数
     * appreciation: 博客赞赏开关
     * shareStatement: 博客版权开关
     * commentTabled: 博客评论开关
     * published: 博客发布状态-----草稿箱/发布
     * recommend: 博客是否推荐到首页
     * createTime: 创建时间
     * updateTime: 修改时间
     */
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentTabled;
    private boolean published;
    private boolean recommend;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();
    public Blog() {
    }
}
