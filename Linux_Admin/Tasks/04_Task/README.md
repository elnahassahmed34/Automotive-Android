# Task 4
## 1. Create a Supplementary (Secondary) Group
- Create a group called pgroup with a group ID of 30000.

```bash
sudo groupadd -g 30000 pgroup
```

## 2. Lock a User Account
- Lock a user account so the user cannot log in.

```bash
username="yourUser"  # Replace 'yourUser' with the actual username
sudo passwd -l "$username"
echo "User $username locked."
```
3. Delete a User Account
Delete a user account and its home directory.

```bash
sudo userdel -r "$username"
```

## 4. Delete a Group Account
- Delete a group account.

```bash
sudo groupdel "$groupname"
```

## 5. Difference between adduser and useradd

### useradd
- useradd: A low-level utility for adding users. It does not set up home directories or copy files.
- Example: sudo useradd -m newuser

### adduser
- adduser: A high-level utility that uses useradd in the background, providing a more interactive and user-friendly way to add users.
Example: sudo adduser newuser