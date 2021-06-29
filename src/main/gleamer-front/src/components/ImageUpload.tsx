import React, {useEffect, useState} from 'react';
import axios from "axios";


export default function ImageUpload() {
    const [image, setImage] = useState<File | undefined>();
    const [preview, setPreview] = useState<string | undefined>();

    useEffect(() => {
        if (image) {
            const reader = new FileReader();
            reader.onloadend = () => {
                setPreview(reader.result as string);
            };
            reader.readAsDataURL(image);
        } else {
            setPreview(undefined);
        }
    }, [image]);

    const onImageSelected = (event: React.ChangeEvent<HTMLInputElement>) => {
        const files = event.target.files;
        if (files) {
            setImage(files[0]);
        } else {
            setImage(undefined);
        }
    }
    const onFileUpload = () => {
        if (image) {
            const formData = new FormData();
            formData.append(
                "image",
                image,
                image.name
            );
            console.log(image)
            axios.post('http://localhost:8080/images', formData).then(value => console.log(value));
        }
    };
    return (
        <>
            <div>
                <input
                    type="file"
                    accept="image/png"
                    multiple={false}
                    onChange={onImageSelected}
                />
                {image ? <button onClick={onFileUpload}>Upload</button> : null}
            </div>
            {preview ? <img style={{maxWidth: "500px"}} src={preview}/> : null}
        </>
    );


}