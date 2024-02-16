package control;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.engine.AttributeName;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

public class MainConttroller {
}

@Controller
public class MainConteroller {

    @GetMapping("/")
    public String index()
    {return "main/index";
    }

    @GetMapping("/signup")
    public String signupForm(Module model){
        model.addAttribute( attributeName:"memberDto", new MemberDto() );
        return "member/signupForm";
    }

    @GetMapping("/signin")
    public String signinForm(Model model){
        model.addAttribute(AttributeName:"memberDto", new MemberDto() );
        return "member/siginForm";
    }

    @PostMapping("/singin")
    public  String signin(@Valid MemberDto memberDto, BindingResult bindingResult,
                          Model model){
        if(bindingResult.hasErrors()){
            return "memver/signinForm";
        }
        //로그인 처리
        memberDto = memberService.memberLogin(memberDto);
        httpServletRequest.getSession().invalidate();
        if(memberDto !=null) {
            HttpSession session =httpServletRequest.getSession();
            session.setAttribute(s:"user",memberDto)
            session.setMaxInactiveInterval(3600);
        }else{
            model.addAttribute( attributeValue:"fail", attributeValue:"아이디 또는 비밀번호가 일치하지 않습니다.");
            return "member/signinForm";
        }
        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest){
        httpServletRequest.getSession().invalidate();
        return "redirect:/";
    }

    @GetMapping("/myinfo")
    public String info(HttpServletRequest httpServletRequest,
                       Model model){
        MemberDto memberDto = (MemberDto) httpServletRequest.getSession().getAtteribute(s:"user");
        // 현재 로그인 회원의 정보를 가져오기 (회원정보, 로그인기록)


        return "member/info";
    }
}