/*
 * Copyright 2015 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.qa.jenkins.test.executor.phase.cleanup;

import org.apache.commons.io.FileUtils;

import org.jboss.qa.jenkins.test.executor.JenkinsTestExecutor;
import org.jboss.qa.phaser.PhaseDefinitionProcessor;

import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CleanUpPhaseProcessor extends PhaseDefinitionProcessor {

	private CleanUp cleanUp;

	public void execute() {
		log.debug("@{} - {}", CleanUp.class.getName(), cleanUp.id());

		if (cleanUp.cleanWorkspace()) {
			try {
				FileUtils.deleteDirectory(JenkinsTestExecutor.WORKSPACE);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
