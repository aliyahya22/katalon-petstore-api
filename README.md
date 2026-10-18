# Katalon API Automation - JPetStore Swagger API

Repository ini berisi skrip automasi pengujian API untuk **JPetStore Swagger API** (`https://petstore.swagger.io/v2`) menggunakan **Katalon Studio**. Project ini mencakup alur pengujian End-to-End (E2E), pengelolaan data dinamis via Global Variables, serta skenario pengujian positif dan negatif.

---

## Key Features & Implementation
- **Dynamic Data Handling**: Menggunakan Global Variables (`baseUrl`, `petId`, `petName`) untuk menghindari *hardcoded values* dan mendukung data acak secara otomatis.
- **Full E2E Test Flow**: Menguji alur hidup data dari pembuatan hingga penghapusan (Create -> Read -> Update -> Delete).
- **Comprehensive Assertions**: Verifikasi status code HTTP (`200 OK`, `404 Not Found`) dan validasi *response body JSON values*.
- **Report Generation**: Terintegrasi dengan fitur pelaporan Test Suite di Katalon Studio.

---

## Test Coverage

| Method | Endpoint | Scenario Type | Description | Expected Status |
| :--- | :--- | :--- | :--- | :--- |
| **POST** | `/pet` | Positive (E2E) | Membuat data pet baru dengan ID & nama dinamis | `200 OK` |
| **GET** | `/pet/{petId}` | Positive (E2E) | Mengambil data pet yang baru saja dibuat berdasarkan ID | `200 OK` |
| **PUT** | `/pet` | Positive (E2E) | Mengubah nama & status data pet | `200 OK` |
| **DELETE** | `/pet/{petId}` | Positive (E2E) | Menghapus data pet dari database | `200 OK` |
| **GET** | `/pet/{petId}` | Negative | Mencari data pet dengan ID yang tidak terdaftar | `404 Not Found` |
| **POST** | `/pet` | Negative | Mengirim data payload kosong/default | `200 OK` |
| **DELETE** | `/pet/{petId}` | Negative | Menghapus data pet yang ID-nya tidak ada/sudah terhapus | `404 Not Found` |

---

## Project Structure

```text
katalon-petstore-api/
├── Profiles/
│   └── default.glbl                  # Global variables (baseUrl, petId, petName)
├── Object Repository/                # Web Service Requests
│   ├── POST_AddPet.rs
│   ├── GET_PetById.rs
│   ├── PUT_UpdatePet.rs
│   └── DELETE_Pet.rs
├── Test Cases/
│   ├── TC01_Positif_E2E_Petstore     # End-to-End Positive Test Flow
│   └── TC02_Negatif_E2E_Petstore     # Negative Test Flow
├── Test Suites/
│   └── Suite_API_Petstore.ts          # Test Suite untuk eksekusi gabungan
└── Reports/                          # Laporan hasil pengujian (HTML/PDF)


## How to Run Tests
Prerequisites
- Katalon Studio (v8.x atau yang lebih baru)
- Git terinstall di komputer lokal
- Koneksi internet aktif (untuk mengakses endpoint `https://petstore.swagger.io/v2`)

Option A: Via Katalon Studio GUI (Disarankan)
1. **Clone Repository**:
   bash
   git clone https://github.com/aliyahya22/katalon-petstore-api.git
