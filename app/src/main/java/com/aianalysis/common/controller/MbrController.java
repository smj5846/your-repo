package com.aianalysis.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aianalysis.common.model.MbrPageResponse;
import com.aianalysis.common.model.MbrVO;
import com.aianalysis.common.model.PasswordUtil;
import com.aianalysis.common.service.MbrService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MbrController {
	@Autowired
	private MbrService mbrService;
	
	@GetMapping("/api/mbr/cookiechk")
	public ResponseEntity<Map<String, Object>> checkCookie(@CookieValue(name = "JSESSIONID", required = false) String cookieValue, HttpSession httpSession) {
		Map<String, Object> response = new HashMap<>();
	    if (cookieValue != null) {
	    	
	    	response.put("email", httpSession.getAttribute("email"));
	        response.put("grade", httpSession.getAttribute("grade"));
	        
	        return ResponseEntity.ok(response);
	    } else {
	    	
	    	if(httpSession.getAttribute("email") != null) {
	    		httpSession.invalidate(); // 세션 무효화
	    	}
	    	
	    	
	        return ResponseEntity.ok(response);
	    }
	}
	
	// 회원정보 삭제
	@PostMapping("/api/mbr/mbrdelete")
	public int mbrDelete(@RequestBody MbrVO mbrvo) {
		return mbrService.mbrDelete(mbrvo.getEmail());
	}
		
	// 회원정보 수정
	@PostMapping("/api/mbr/mbrupdate")
	public ResponseEntity<String> mbrUpdate(@RequestBody MbrVO mbrvo) {
		
		mbrService.mbrUpdate(mbrvo);
        return ResponseEntity.ok("수정되었습니다.");
	}
		
	// 회원정보
	@PostMapping("/api/mbr/getmbr")
	public MbrVO getmbr(@RequestBody MbrVO mbrvo) {
		return mbrService.getMbr(mbrvo.getEmail());
	}
	
	//회원가입
	@PostMapping("/api/mbr/join")
	public ResponseEntity<String> mbrJoin(@RequestBody MbrVO mbrvo) throws Exception {
		try {
	        if (mbrService.getMbr(mbrvo.getEmail()) != null) {
	            throw new Exception("이메일이 이미 존재합니다.");
	        }
	        mbrService.saveMbr(mbrvo);
	        return ResponseEntity.ok("등록되었습니다.");
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}
		
	@PostMapping("/api/mbr/index")
	public MbrPageResponse mbrPageIndex(@RequestBody Map<String, ?> params) {
		
		return new MbrPageResponse(mbrService.getMbrPageIndex(params),mbrService.getMbrIndex(params).size());
	}
	
    
 // 로그아웃 (세션 삭제)
    @PostMapping("/api/mbr/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpSession httpSession,HttpServletRequest request,HttpServletResponse response) {
    	HttpSession session = request.getSession(false); // 세션이 존재하는 경우 가져옴
	    Map<String, Object> responseBody = new HashMap<>();
	    
	    if (httpSession.getAttribute("email") != null) {
	    	
	    	httpSession.invalidate(); // 세션 무효화
	    }

	    // JSESSIONID 쿠키 삭제 (쿠키 만료)
	    Cookie cookie = new Cookie("JSESSIONID", null);
	    cookie.setMaxAge(0); // 즉시 만료
	    cookie.setPath("/"); // 쿠키 경로 설정
	    response.addCookie(cookie);

	    // 응답 헤더에 쿠키 만료 설정
	    response.setHeader("Set-Cookie", "JSESSIONID=; Path=/; HttpOnly; Max-Age=0");

	    responseBody.put("message", "Logout successful");
	    return ResponseEntity.ok(responseBody);
    }
    
    
	
	//로그인
	@PostMapping("/api/mbr/lgn")
	public ResponseEntity<Map<String, Object>> mbrLgn(@RequestBody MbrVO vo, HttpSession httpSession) {
		Map<String, Object> response = new HashMap<>();
		if(vo == null) return ResponseEntity.ok(response);
		
		String email = vo.getEmail();
		String password = PasswordUtil.encryptSHA256(vo.getPassword());
		int grade = vo.getGrade();
		String name = "";
		
		MbrVO loginVo = mbrService.getMbrByLgn(email, password, grade);
		if(loginVo != null) {
			email = loginVo.getEmail();
			name = loginVo.getName();
			grade = loginVo.getGrade();
		}
		
		
		if(loginVo == null) {
			//실패 시 0
			return ResponseEntity.ok(response);
		} else {
			httpSession.setAttribute("email", email);
			httpSession.setAttribute("name", name);
			httpSession.setAttribute("grade", grade);
			
			response.put("sessionId", httpSession.getId());
	        response.put("email", httpSession.getAttribute("email"));
	        response.put("grade", httpSession.getAttribute("grade"));
	       
			//성공 시 1 반환
			return ResponseEntity.ok().header("Set-Cookie", "JSESSIONID=" + httpSession.getId() + "; Path=/; HttpOnly; SameSite=None; Secure").body(response);

		}
	}
	
}