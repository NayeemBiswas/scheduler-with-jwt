package com.example.demo.utill;

import org.springframework.stereotype.Component;

import com.example.demo.constants.MessageConstants;
import com.example.demo.response.CommonResponse;

import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class CommonUtils implements MessageConstants{
		
	//================================== *** ==================================
	//									Server Message
	//================================== *** ==================================
	
	public CommonResponse generateSuccessResponse(Object obj, String... message) {
		CommonResponse response = new CommonResponse();
		response.setStatus(true);
		response.setData(obj);
		if (message.length > 1 && message[0] != null && message[1] != null) {
			response.setMessage(message[0]);
			response.setMessageBn(message[1]);
        }
		return response;
	}

    public CommonResponse generateErrorResponse(Exception e) {
		CommonResponse response = new CommonResponse();
		response.setStatus(false);
		String msgType = getMessageType(e.getMessage());
		if(msgType.equals("uk") || msgType.equals("re")) {
			response.setMessage(DATA_ALRADY_EXISTS_MESSAGE);
			response.setMessageBn(DATA_ALRADY_EXISTS_MESSAGE_BN);
		}else if(msgType.equals("fk")) {
			response.setMessage(CHILD_RECORD_FOUND);
			response.setMessageBn(CHILD_RECORD_FOUND_BN);
		}else {
			response.setMessage(e.getMessage());
		}
		
//		e.printStackTrace();
		
//		System.out.println(e.getMessage());
		return response;
	}

   

	//================================== *** ==================================
	//									Helper
	//================================== *** ==================================
	


    private String getMessageType(String message) {
		if(message != null && message.length() > 55) {
			return message.substring(52,54);
		}
		return "";
	}
	
	 
	
}
