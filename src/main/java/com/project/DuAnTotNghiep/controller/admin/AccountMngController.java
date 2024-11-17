package com.project.DuAnTotNghiep.controller.admin;

import com.project.DuAnTotNghiep.entity.Account;
import com.project.DuAnTotNghiep.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AccountMngController {
    private final AccountService accountService;

    public AccountMngController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/admin-only/account-management")
    public String viewAccountManagementPage(Model model) {
        List<Account> accountList = accountService.findAllAccount();
        model.addAttribute("accountList", accountList);
        return "/admin/account";
    }

    @PostMapping("/account/block/{id}")
    public String blockAccount(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Account account = accountService.blockAccount(id);
        redirectAttributes.addFlashAttribute("message", "Tài khoản " + account.getEmail() + " đã khóa thành công");
        return "redirect:/admin-only/account-management";
    }

    @PostMapping("/account/open/{id}")
    public String openAccount(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Account account = accountService.openAccount(id);
        redirectAttributes.addFlashAttribute("message", "Tài khoản " + account.getEmail() + " đã mở khóa thành công");
        return "redirect:/admin-only/account-management";
    }

    @PostMapping("/account/change-role")
    public String openAccount(@ModelAttribute("email") String email, @ModelAttribute("role") Long roleId, RedirectAttributes redirectAttributes) {
        Account account = accountService.changeRole(email, roleId);
        redirectAttributes.addFlashAttribute("message", "Tài khoản " + account.getEmail() + " đã đổi thành quyền thành công");
        return "redirect:/admin-only/account-management";
    }

    //staff
    @GetMapping("/admin-only/account-staff")
    public String viewAccountPage(Model model) {
        List<Account> accountList = accountService.findByRoleId();
        model.addAttribute("accountList", accountList);
        return "/admin/account-staff";
    }
    @PostMapping("/update-staff")
    public String updateStaff(@ModelAttribute("email") String email, @ModelAttribute("name") String name,@ModelAttribute("phone") String phone, RedirectAttributes redirectAttributes) {
        Account account = accountService.changeStaff(email,name,phone);
        redirectAttributes.addFlashAttribute("message", "Tài khoản " + account.getEmail() + " sửa thành công");
        return "redirect:/admin-only/account-staff";
    }
    // custom
    @GetMapping("/admin-only/account-custom")
    public String viewCustomPage(Model model) {
        List<Account> accountList = accountService.findByRoleIdCustom();
        model.addAttribute("accountList1", accountList);
        return "/admin/account-custom";
    }
    @PostMapping("/update-custom")
    public String updateCustom(@ModelAttribute("email") String email, @ModelAttribute("name") String name,@ModelAttribute("phone") String phone, RedirectAttributes redirectAttributes) {
        Account account = accountService.changeStaff(email,name,phone);
        redirectAttributes.addFlashAttribute("message", "Tài khoản " + account.getEmail() + " sửa thành công");
        return "redirect:/admin-only/account-custom";
    }
}
