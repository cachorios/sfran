package com.gmail.cacho.slbase.security;

public abstract class Events {
    public static final class UserLoginEvent {
        private final String username, password;

        public UserLoginEvent(final String username, final String password) {
            this.username = username;
            this.password = password;
        }

        public String getUserName() {
            return this.username;
        }

        public String getPassword() {
            return this.password;
        }
    }

    public static class UserLogoutEvent {}

    public static class MenuEvent {}
}
