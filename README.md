# Earthquake Task!

I created a simple Android app that displays a list of earthquakes from a desired API service. I implemented it using the MVVM architecture and Retrofit for the API call. Additionally, I incorporated view binding, even though it wasn't required

## Project Description

1. From the API endpoint extract the following variables and present them in Recyclerview.
2. From properties JSON object get:
   • title place
   • time (convert millis to date format mm/dd/yyyy)
   • mag
   • type
3. Clicking on an item in the RecyclerView app should open the default browser, providing the url from the properties.
4. UI/UX is optional but material design should be used.
5. Technical project specification:
   • Java
   • Retrofit
   • Gson for conversion of JSON objects into Java objects
   • Adapter
   • Model
   • Single Activity with one fragment
   • API endpoint: https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2023-01-01&endtime=2023-01-02
   • Nice to have, but not required: MVVM, LiveData

## ScreenShots

|                |Default browser                          |
|----------------|-------------------------------|
| ![Screenshot_20250108_180434_com nejracoric earthquaketask](https://github.com/user-attachments/assets/818104d5-07f2-4422-9bbf-8e27b132ff37) | ![Screenshot_20250108_180442_com android chrome](https://github.com/user-attachments/assets/c098084c-ab68-4024-9135-538aed98cca7) |

## Used Dependencies

- androidx.navigation:navigation - used to add fragment screen to activity. Adding new fragments on top of this would be easier since nav_graph was introduced and set as it would be in projects with more then one screen
- com.squareup.retrofit2:retrofit - used to make API call. Structured in way so RetrofitAPI can hold multiple endpoints while RetrofitClient has one base url used by all of calls
