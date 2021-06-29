# README #

## Rules 

- Backend
    - Code must be in Spring boot
- Frontend
    - Code must be in TypeScript React
    

## Your mission

Create a REST API:

- POST /images : Uploads and stores images on backend (only grayscale PNG).

Expected response:
```javascript
{
    "id": "image-id", // The image id returned by the API
    "name": "sunset.png", // The image name
    "rows": 100, // The theoritical value range
    "columns" : 200, // The effective minimum value
    "resolution" : 20000, // The image resolution
    "createdAt" : "2020-04-01T23:45:23Z" // ISO created date
}
```

- GET /images/{id}/histogram : Get the histogram data of a previous stored image.

Expected response:
```javascript
{ 
    "histogram": [0, 0, 23, ..., 10], // The image historgam
    "valueRange": [0, 1024], // The theoritical value range
    "minValue" : 5, // The effective minimum value
    "maxValue" : 1012 // The effective maximum value
}
```

- GET /images/{id}/equalization : Get image applying [histogram equalization](https://en.wikipedia.org/wiki/Histogram_equalization).
- Add endpoint as needed ...
    

Add to the webapp, the following features:

- Select local file and upload it
- Display the image list with original preview and information (rows, columns, etc...)
- Add a quick filter field that allow to filter list by name or resolution, ex:
    - "sun" matches "sunset.png"
    - "0-100000" matches the 20000 resolution
- Click on image to display histogram data and equalized preview.
