# Star Topology Network Modeling with Huffman Compression

## Overview
This Java project implements a model of a computer network using a star topology, where multiple client nodes are connected to a central server node. Each client node can send messages to other clients via the central server node. Additionally, the project incorporates data compression techniques, specifically Huffman coding, to compress messages sent between clients, optimizing bandwidth usage.

## Project Structure
- **ClientNode.java**: Defines the client node class, including methods for sending and receiving messages.
- **ServerNode.java**: Implements the server node class, responsible for brokering messages between client nodes.
- **Star.java**: Represents the model of the network, providing methods to insert and delete client nodes.
- **HuffmanCoding.java**: Contains the implementation of Huffman coding algorithm for data compression.
- **Main.java**: Entry point of the program, where the network is instantiated, and operations are performed.

## Usage
1. Compile the Java files: `javac *.java`
2. Run the Main class: `java Main`
3. Follow the prompts to interact with the simulated network, including adding/deleting client nodes and sending messages.
4. The compressed and decompressed messages will be displayed along with the network operations.

## Data Compression
Huffman coding is employed for compressing messages exchanged between client nodes. This lossless compression algorithm assigns variable-length codes to characters based on their frequencies, resulting in efficient data compression.

## Contributors
1. Ismael N Mudjanima
2. Mitchum W Januarie
3. Hendrina Shikonda
4. Erastus Shindinge
5. Brito Manuel
6. Simeon Tuyoleni
