package de.metas.ui.web.login.json;

import org.adempiere.util.Check;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Value;

/*
 * #%L
 * metasfresh-webui-api
 * %%
 * Copyright (C) 2018 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@Value
public class JSONResetPassword
{
	@JsonProperty("fullname")
	String fullname;

	@JsonProperty("email")
	String email;

	@JsonProperty("token")
	String token;

	@Builder
	@JsonCreator
	private JSONResetPassword(
			@JsonProperty("fullname") final String fullname,
			@JsonProperty("email") final String email,
			@JsonProperty("token") final String token)
	{
		Check.assumeNotEmpty(email, "email is not empty");
		Check.assumeNotEmpty(token, "token is not empty");

		this.fullname = fullname;
		this.email = email;
		this.token = token;
	}
}