#  Plant Diseases Detection with Solution

A mobile application developed as part of a Mobile Computing project, which identifies plant diseases from images and provides treatment suggestions using AI.

##  Features

- **Disease Detection** using image classification (ResNet-50)
- **LLM-based Advisory System** (Local/Offline GPT models)
- **Offline Support** – no need for internet to detect diseases
- **Camera & Gallery Integration**
- **Theme Support** (Light/Dark)
- **Dynamic Confidence Thresholds** (User-configurable 10–90%)
- **Message Persistence** in chat system
- **Multi-disease result display**

---

##  Core Components

### Frontend
- **Jetpack Compose UI**
- **Navigation Component**
- **CameraX API**

### Backend
- **PyTorch Mobile** for model inference
- **OpenAI Kotlin SDK** (fallback to local LLMs due to API limits)

---

##  Key Modules

- `MainActivity.kt`: Handles app setup, theming, and navigation
- `ModelFileHelper.kt`: Loads and initializes the disease model
- `DetectionEngine.kt`: Runs preprocessing and inference using PyTorch
- `ChatSystem.kt`: Suggests solutions via local or remote LLMs

---

##  AI & Model Details

- **Model**: `PlantDiseasesModel.pt`
- **Base**: ResNet-50
- **Output Classes**: 38 plant diseases
- **Accuracy**: ~96% (on similar dataset)
- **Label Mapping**: JSON file supporting 45+ plant species

### Disease Detection Pipeline
1. Load model
2. Preprocess image
3. Run inference (`model.forward()`)
4. Apply softmax for probabilities
5. Display top 3 results

---

##  Chat System Architecture

- **MessageRecyclerView** for display
- **LLM Routing**:
  - If input contains disease keywords → uses **Local LLM (Llama-2/phi-2)**
  - Else → uses **OpenAI GPT (if available)**
- **Caching** for offline replies

---

##  Performance

- **App Size**: ~450MB (due to offline model)
- **Latency**: Faster offline processing
- **Trade-off**: Online model would reduce size but add latency

---

##  Challenges Solved

- Real-time image classification on mobile
- Permissions handling for camera/gallery
- Offline LLM integration
- Theme toggle and UI management

---

##  Future Roadmap

### Short-Term
- Real-time camera-based detection
- Disease progression tracking

### Long-Term
- AR visualization of disease spread
- Satellite data integration
- Global disease mapping
- Farmer community support features

---

##  Setup Instructions

1. Clone this repository.
2. Open in **Android Studio**.
3. Load PyTorch `.pt` model into `assets/`.
4. Build and run on a real device (CameraX requires physical hardware).
5. Internet required for OpenAI integration (optional fallback to local LLMs).

---

##  Author

**Himanshu Kumar**  
Mobile Computing Project (2022215)

---

