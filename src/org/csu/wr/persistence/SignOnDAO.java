package org.csu.wr.persistence;

import org.csu.wr.domain.Account;

public interface SignOnDAO {
	public Account FindUser(String username, String password);
}
