Project created in INTELLIJ Idea

NOTE:
For Unit-8 -SSLServerSocket topic you need to generate the SSL key for both client and Server before running code using keytool Command:

```sh
# Generate a keystore for the server
keytool -genkeypair -alias server -keyalg RSA -keystore server.keystore -validity 365 -storepass changeit -keypass changeit

# Generate a keystore for the client
keytool -genkeypair -alias client -keyalg RSA -keystore client.keystore -validity 365 -storepass changeit -keypass changeit

# Export the server certificate
keytool -export -alias server -keystore server.keystore -file server.cer -storepass changeit

# Import the server certificate into the client's keystore
keytool -import -alias server -file server.cer -keystore client.keystore -storepass changeit
