# Network Basics

## Key Concepts

### Server and Client
- **Server**: A computer or program that provides services to other computers or programs on a network.
- **Client**: A computer or program that requests services from a server.

### MAC Address
- **MAC Address**: A unique identifier assigned to network interfaces for communications on the physical network segment.

### IP Address
- **IP Address**: Consists of a network part and a host part, used to identify devices on a network.
- **Subnet Mask**: Used to divide an IP address into the network and host portions.

### Subnetting Example
- **75 Devices in a Company**
  - Local Network: `192.168.1.0`
  - Subnet Mask: `255.255.255.180` (or `192.168.1.0/24`)

### OSI Model
1. **Physical Layer**
2. **Data Link Layer**
3. **Network Layer**
4. **Transport Layer**
5. **Application Layer**

### Address Resolution Protocol (ARP)
- **Purpose**: Finds the MAC address associated with an IP address.
- **Operation**: Sends a broadcast message to discover the MAC address for a given IP.

### Network Devices
- **Switch**: Operates at the Data Link layer, used for LAN (Local Area Network).
- **Router**: Operates at the Network layer, used for WAN (Wide Area Network).

### Routing
- **NAT (Network Address Translation)**: Translates private IP addresses to a public IP address for accessing the internet.

## Network Commands
- `arp`: Displays and modifies the ARP cache.
- `ping`: Tests connectivity between devices.
- `ifconfig`: Configures network interfaces.
- `ip a`: Shows IP addresses and network interfaces.
- `route`: Shows/manipulates the IP routing table.
- `traceroute`: Traces the path packets take to a destination.

### Configuring Network Connection by Ethernet
```sh
# Add IP address
sudo ip a add 192.168.1.7/24 dev enp2s0

# Remove IP address
sudo ip a del 192.168.1.7/24 dev enp2s0
```

### Transport Layer Protocols
### TCP (Transmission Control Protocol):

- Ensures reliable, ordered, and error-checked delivery of data.
- 3-way handshake: SYN -> SYN-ACK -> ACK.

### UDP (User Datagram Protocol):

- Connectionless protocol, "fire and forget".
- Used for streaming (e.g., YouTube).

## Application Layer Protocols
- HTTP (Hypertext Transfer Protocol): Used for web communication.
- FTP (File Transfer Protocol): Used for transferring files.
- SSH (Secure Shell): Used for secure remote login and other secure network services.
Sockets

### To connect a server to a client, you need the IP address and port number.
```sh
#Enabling SSH
sudo systemctl enable ssh
#Connecting via SSH
ssh mohamed@10.145.19.245
```
### Network Interface Names
- enp2s0: Ethernet interface, first interface on PCI bus 2.
- wlp3s0: Wireless interface, first interface on PCI bus 3.
