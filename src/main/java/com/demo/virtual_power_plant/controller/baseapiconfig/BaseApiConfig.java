package com.demo.virtual_power_plant.controller.baseapiconfig;

import com.demo.virtual_power_plant.enums.ResponseStatus;
import com.demo.virtual_power_plant.pojo.api.GlobalApiResponse;
import com.demo.virtual_power_plant.utill.CustomMessageSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
public class BaseApiConfig {



        /**
         * ObjectMapper instance
         */
        public ObjectMapper objectMapper = new ObjectMapper();

        /**
         * API Success ResponseStatus
         */
        protected final ResponseStatus API_SUCCESS_STATUS = ResponseStatus.SUCCESS;

        /**
         * API Error ResponseStatus
         */
        protected final ResponseStatus API_ERROR_STATUS = ResponseStatus.FAIL;

        /**
         * Message Source Instance
         */
        @Autowired
        protected CustomMessageSource customMessageSource;

        /**
         * Module Name
         */
        protected String moduleName;
        protected String permissionName;
        protected String screenName;

        /**
         * This module is used to fetch the available permissions of current user in particular module
         */
        protected String module;


        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        /**
         * Function that sends successful API Response
         *
         * @param message
         * @param data
         * @return
         */
        protected GlobalApiResponse successResponse(String message, Object data) {
            GlobalApiResponse globalApiResponse = new GlobalApiResponse();
            globalApiResponse.setStatus(API_SUCCESS_STATUS);
            globalApiResponse.setDateTime(new Date());
            globalApiResponse.setMessage(message);

            globalApiResponse.setData(data);
            return globalApiResponse;
        }

        /**
         * Function that sends error API Response
         *
         * @param message
         * @param errors
         * @return
         */
        protected GlobalApiResponse errorResponse(String message, Object errors) {
            GlobalApiResponse globalApiResponse = new GlobalApiResponse();
            globalApiResponse.setStatus(API_ERROR_STATUS);
            globalApiResponse.setMessage(message);
            globalApiResponse.setData(errors);
            return globalApiResponse;
        }

        public String getPermissionName() {
            return permissionName;
        }

    }


