# 🐍 Java Snake Game

A classic Snake game implementation built with **Java** and the **Swing** library. Navigate the snake, consume apples, and try to achieve the highest score without hitting the walls or yourself!



---

## 📋 Features

* **Dual Control Schemes:** Supports both **Arrow Keys** and **WASD** for navigation.
* **Dynamic Growth:** The snake grows in length with every apple consumed.
* **Collision Detection:** Integrated logic for wall hits and self-collision.
* **Smart Spawning:** Apples are programmed to never spawn inside the snake's current body.
* **Anti-Pivot Logic:** Prevents the snake from making an impossible 180° turn into itself.

---

## 🏗 Project Structure

The project follows a modular approach for better maintainability:

* **`SnakeGame.java`**: The main entry point. Sets up the `JFrame` and window properties.
* **`GamePanel.java`**: The engine of the game. Handles the game loop (Timer), rendering, and core logic.
* **`Snake.java`**: Manages the snake's coordinates (LinkedList), movement, and growth.
* **`Direction.java`**: An Enum defining movement vectors $(dx, dy)$ and opposite direction checks.

---

## 🎮 Getting Started

### Prerequisites
* **JDK 8** or higher installed on your machine.

### Installation & Run
1.  **Clone or download** the source files.
2.  **Navigate** to the `src` directory in your terminal:
    ```bash
    cd path/to/project/src
    ```
3.  **Compile** the source code:
    ```bash
    javac *.java
    ```
4.  **Run** the application:
    ```bash
    java SnakeGame
    ```

---

## ⌨️ Controls

| Action | Primary Keys | Alternative Keys |
| :--- | :--- | :--- |
| **Move Up** | `Up Arrow` | `W` |
| **Move Down** | `Down Arrow` | `S` |
| **Move Left** | `Left Arrow` | `A` |
| **Move Right** | `Right Arrow` | `D` |

---

## 🛠 Technical Specifications

* **Resolution:** $600 \times 600$ pixels.
* **Grid Size:** $25 \times 25$ pixels per unit ($24 \times 24$ playable cells).
* **Tick Rate:** 100ms (defined by `DELAY` in `GamePanel`).
* **Rendering:** Uses `Graphics` object via `paintComponent` for smooth UI updates.

---

## 🚀 Future Improvements
- [ ] Add an on-screen score counter.
- [ ] Implement a "Game Over" restart button.
- [ ] Add sound effects for eating and collisions.
- [ ] Implement a high-score system using local file storage.
