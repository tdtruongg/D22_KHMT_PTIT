import socket
import threading
clients=[]

def handle_receive(client_socket):
    while True:
        try:
            message = client_socket.recv(1024).decode("utf8")
            if not message:
                print("Disconnected from server")
                break
            print(message)
        except ConnectionResetError:
            print("Connection with server was forcibly closed")
            break
        except Exception as e:
            print(f"Error receiving message: {e}")
            break
    client_socket.close()

def handle_send(client_socket):
    while True:
        try:
            message = input("Client: ")
            client_socket.send(message.encode("utf8"))
        except BrokenPipeError:
            print("Connection with server was forcibly closed")
            break
        except Exception as e:
            print(f"Error sending message: {e}")
            break
    client_socket.close()

def main():
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        client.connect(("10.21.4.156", 65432))
        print("Connected to server at 127.0.0.1:65432")

        # Create and start threads for sending and receiving messages
        receive_thread = threading.Thread(target=handle_receive, args=(client,))
        send_thread = threading.Thread(target=handle_send, args=(client,))

        receive_thread.start()
        send_thread.start()

    except Exception as e:
        print(f"Connection error: {e}")

if __name__ == "__main__":
    main()
