from flask import Flask
import pymysql
import os

app = Flask(__name__)

@app.route("/")
def home():
    return "Backend is running 🚀"

@app.route("/test-db")
def test_db():
    try:
        connection = pymysql.connect(
            host=os.environ.get("DB_HOST"),
            user=os.environ.get("DB_USER"),
            password=os.environ.get("DB_PASSWORD"),
            database=os.environ.get("DB_NAME")
        )
        return "Database connection successful ✅"
    except Exception as e:
        return f"Database error: {e}"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)