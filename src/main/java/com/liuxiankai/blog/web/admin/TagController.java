package com.liuxiankai.blog.web.admin;

import com.liuxiankai.blog.po.Tag;
import com.liuxiankai.blog.po.Type;
import com.liuxiankai.blog.service.TagService;
import com.liuxiankai.blog.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author liuxiankai
 */


@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;


    @GetMapping("/tagManage")
    public String tags(@PageableDefault(size = 6, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model, HttpSession session){
        boolean check = Utils.check(session);
        if (check){
            model.addAttribute("info","您是super管理员,可以执行任意操作");
        } else {
            model.addAttribute("info","您是普通用户,分类和标签页只拥有查看功能");
        }
        model.addAttribute("page", tagService.listTag(pageable));
        return "admin/tags-manage";
    }

    @GetMapping("/tags/input")
    public String tagsInput(Model model){
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "admin/tags-input";
    }

    @PostMapping("/tags/post")
    public String post(@Valid Tag tag, BindingResult result, RedirectAttributes attributes) {
        if (tagService.getTagByName(tag.getName()) != null) {
            result.rejectValue("name", "nameError", "该标签已存在");
        }
        if (result.hasErrors()) {
            return "admin/tags-input";
        }
        Tag t = tagService.saveTag(tag);
        if (t == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/admin/tagManage";
    }

    @PostMapping("/tags/post/{id}")
    public String post(@Valid Tag tag, BindingResult result,@PathVariable Long id, RedirectAttributes attributes) {
        if (tagService.getTagByName(tag.getName()) != null) {
            result.rejectValue("name", "nameError", "该标签已存在");
        }
        if (result.hasErrors()) {
            return "admin/tags-input";
        }
        Tag t = tagService.updateTag(id, tag);
        if (t == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/admin/tagManage";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        tagService.delTag(id);
        attributes.addFlashAttribute("message", "操作成功");
        return "redirect:/admin/tagManage";
    }
}
