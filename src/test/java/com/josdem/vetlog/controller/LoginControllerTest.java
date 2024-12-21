/*
Copyright 2024 Jose Morales contact@josdem.io

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.josdem.vetlog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("getting login page")
    void shouldGetLogin(TestInfo testInfo) throws Exception {
        log.info(testInfo.getDisplayName());
        mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("login/login"));
    }

    @Test
    @DisplayName("getting login error")
    void shouldGetLoginErrorMessage(TestInfo testInfo) throws Exception {
        log.info(testInfo.getDisplayName());
        mockMvc.perform(get("/login").param("error", "invalid credentials"))
                .andExpect(status().isOk())
                .andExpect(view().name("login/login"));
    }

    @Test
    @DisplayName("logging out")
    void shouldLogout(TestInfo testInfo) throws Exception {
        log.info(testInfo.getDisplayName());
        mockMvc.perform(get("/logout")).andExpect(status().is3xxRedirection());
    }
}
