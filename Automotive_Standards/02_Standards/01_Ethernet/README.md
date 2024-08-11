# Standards

## Current Network Arch -> Ethernet

### OSI model -> Open Systems Interconnection Model (7 layers)
1. Physical layer -> define the protocol and std for it -> physical frame
2. Data link layer -> define the frame of protocol -> Logical frame
    - CAN located in those two layers only and ethernet too
    - UART isn't std
    - I2C have diff stds
    - if there is multiple network (can -> lin -> i2c) -> use gateways
3. Network 
    - diffrent networks -> IPv4 , IPv6
    - you can't use it as stand alone
    - ex : ipv4 protocol don't have def. in the first 2 layers
    - ipv4 -> def in 2 layers in ethernet or wifi -> use its frame 
    - ipv4 -> adv. in having differnet networks
    - frame will be = ethernet frame + ipv4 frame
4. Transport
    - TCP / UDP
    - frame will be = (eth | wifi) + (ipv4 | v6) + (tcp | UDP)

5. Session
6. Presentation
    - those two layers have n't std definations
7. App
    - https
    - ftp
    - DHCP
    - frame will be = (eth | wifi) + (ipv4 | v6) + (tcp | UDP) + app protcol (data)



### TCP/IP ARCH
1. Link layer = phy layer + data link layer
2. Internet = netwrok layer
3. Transport = transport
4. App = Session + pres + app layers


## security + frame size + speed
- when you delay the security (MAC security) -> better than when the security is in app (TLS)
- can 8 byte || eth 1500 byte size
- can 1 MB speed | eth 200 GB


## 1- Broad-R Reach -> broadcom company
- but for eth -> 6 wires -> 2 send + recieve + power
- just two wires connected between two node -> send and recieve
- they are same data link layer , but diff physical layer
- IEEE give standards for this broad-R Reach

## physical layer ->  eth HW -> two micro controllers 
- two phys (rg 45) -> connect the cable to -> if diff put between them converter
- media dependant interface -> to outside
- media independant interface -> to MAC
- MAC periphral
- wire communicate to MAC through PHY
- MAC speaks to PHY through diff protocols 
    - MII , RMII , RGMMI
- PHY has layers
    - physical coding sublayer (PCS)
        - 3B2 -> from 3 bits to 2 bits -> method for coding and decoding
    - PMA -> physical medium attachement
        - on the bus there is send and recieve data in same time
        - this layer responsible for knowing recieved one

- naming convention 100 Base - T X
    - 100 -> speed
    - HW broadcom
    - T medium
    - PCS coding and decoding method

- MAC and PHY communicate through i2c 

- Micro controller speaks to MAC periphrals -> init clock
    - MAC init clock for the PHY

- when two machines connected through eth wire
    - they make link train to make the connection up
    - make negotiation
    - 


## 2-Data link layer
- ethernet frame
    - DST MAC  6 bytes
        - uni cast 
        - multi cast
        - broadcast
    - SRC MAC  6 bytes
    - len/type 2 byte 
        - define length of payload 
        - if it exceeds 1500 byte -> it will put type
            - ex : 0x800 -> ipv4
                 : 0x0806 -> ARP
                 : 0x86DD -> ipv6 
    - payload  1500 byte


### VLAN -> virtual local area lan
- len/type 2 byte 
    - if it equals 0x8100 
        - there will be tag
        - 2 bytes define VLAN id

### Ethernet Switch
- change topology of thernet  from node to node
    - to multiple nodes 
- it have many PHYs -> ports
- it has its own MAC
- configure it into VLANS (grouping the ports)
- routing upon MAC adderess
- TCAM -> you can filter the traffic in switch configurations
    - Ternary Content Addressable Memory

#### src -> dest
- when src send frame
- switch make fload to know the dest mac
- it has auto learning fetching
- or you can predefined configuration 
    - configure all ports to map it to MAC addressing
- there is switching table = port num  | MAC addr
    - predefined or run time (auto learn)


## 3. network (router device)-> have many lans connected through protocol (ipv4/6)
- frame will be same except for payload
- it will have ipv4 header + ipv4 payload
    - header : src ip + dest ip
- 192.168.1.0/24 -> network from 1 -> 255 device ip
- ips AND subnet mask = 192.168.1.0
- ex : 192.168.1.1 <--> 192.168.1.2
- router interface -> layer 3 device
    - it will take ip from each switch
    - switch one -> 192.168.1.3
    - switch two -> 192.168.2.10
- AVb -> audio video bridge
    - support streaming in layer 3
- clusters of switches in each part of car
- domain controller
    - in the middle of car
    - respossible for most important processing
    - have 32 cores and about 128 GB RAM
    - there is time syncing between nodes
        - ex : take snapshots from differnet ecus in same time
- PTP -> time sensetivty
    - Precision Time Protocol
    - protocol check time

- ARP : Address Resolution Protocol    
    - who has this ip should return its MAC addr

## 4. Transport
- ipv4 has 2 bytes to define protocol in layer 4
    - 6 -> tcp , 18 -> udp

- udp -> User Datagram Protocol
    - connection protocol
    - header + frame 
        - src port + dst port (0-1023) known ports
            - port number 68 DHCP
            - port number 67 DHCP
            - port number 22 ssh
             
        - length + checksum
- use in video and audio

- dhcp -> Dynamic Host configuration Protocol
    - every ecu automatic have ip
    - server and client
        - c -> discover S
        - S -> offer ip
        - c -> request
        - s -> ACK

- tcp -> Transmission Control Protocol
    - has ACK -> confirmation
    - confirm no data loss
    - there are three stages : each stage has its flags
    - 1. stablish connection
        - sync 
            - S -> SYNC flag , seq = 100
            - C -> SYNC flag ,ACK,  seq = 200
            - S -> ACK , seq = 101
        - ACK
    - 2. data exchange
        - S -> DATA
        - C -> ACK
    - 3. finilize connection
        - C -> FIN +ACK
        - S -> ACK
        - S -> FIN + ACK
        - C -> SCK

- wire shark -> trace frames
    - see the layers
    - see the frames send and  recieved
    - you can filter
