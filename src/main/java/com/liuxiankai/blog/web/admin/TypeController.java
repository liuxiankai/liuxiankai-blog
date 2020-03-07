package com.liuxiankai.blog.web.admin;


import com.liuxiankai.blog.po.Type;
import com.liuxiankai.blog.po.User;
import com.liuxiankai.blog.service.TypeService;
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
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/typeManage")
    public String Types(@PageableDefault(size = 6, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model,HttpSession session) {
        boolean check = check(session);
        if (check){
            model.addAttribute("info","您是super管理员,可以执行任意操作");
        } else {
            model.addAttribute("info","您是普通用户,分类和标签页只拥有查看功能");
        }
        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types-manage";
    }

    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    @PostMapping("/types/post")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
        if (typeService.getTypeByName(type.getName()) != null) {
            result.rejectValue("name", "nameError", "该分类已存在");
        }
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        Type t = typeService.saveType(type);
        if (t == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/typeManage";
    }

    @PostMapping("/types/post/{id}")
    public String editPost(@Valid Type type, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        if (typeService.getTypeByName(type.getName()) != null) {
            result.rejectValue("name", "nameError", "该分类已存在");
        }
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        Type t = typeService.updateType(id, type);
        if (t == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/typeManage";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        typeService.delType(id);
        attributes.addFlashAttribute("message", "操作成功");
        return "redirect:/admin/typeManage";
    }

    public boolean check(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user.getType() != 1) {
            return false;
        }
        return true;
    }
}
