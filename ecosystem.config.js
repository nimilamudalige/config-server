module.exports = {
  apps: [
    {
      name: "config-server",
      script: "java",
      args: "-jar config-server.jar",
      cwd: "/opt/pulsefit/config-server",
      env: {
        SERVER_PORT: "8888",
        EUREKA_SERVER_URL: "http://localhost:8761/eureka" // point at the internal DNS name / IP of platform-a when deployed
      },
      autorestart: true,
      max_restarts: 10,
      min_uptime: "10s",
      restart_delay: 3000,
      out_file: "/var/log/pm2/config-server-out.log",
      error_file: "/var/log/pm2/config-server-error.log",
      log_date_format: "YYYY-MM-DD HH:mm:ss"
    }
  ]
};
