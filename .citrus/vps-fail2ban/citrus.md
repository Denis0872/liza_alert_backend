# CITRUS Delivery Record

- Change set: `vps-fail2ban`
- Goal: reduce SSH brute-force noise and automatically ban abusive IPs on the VPS

## Environment

- Host: `185.21.8.116:2222`
- OS: `Ubuntu 24.04.3 LTS`

## Actions performed

- installed `fail2ban`
- created SSH jail config at `/etc/fail2ban/jail.d/sshd.local`
- created nginx jail config at `/etc/fail2ban/jail.d/nginx.local`
- configured:
  - `port = 2222`
  - `backend = systemd`
  - `maxretry = 5`
  - `findtime = 10m`
  - `bantime = 1h`
  - incremental ban growth enabled
- added a safe `ignoreip` entry for localhost and the admin IP `46.32.66.81`
- enabled and started `fail2ban`
- enabled additional nginx protections:
  - `nginx-botsearch`
  - `nginx-bad-request`

## Validation

- `fail2ban-client ping`
- `fail2ban-client status`
- `fail2ban-client status sshd`

## Outcome

- fail2ban is active
- sshd jail is active on custom port `2222`
- nginx bot/scanner jails are active
- at least one hostile IP was already banned automatically

## Notes

- fail2ban now protects both SSH and selected nginx attack patterns
