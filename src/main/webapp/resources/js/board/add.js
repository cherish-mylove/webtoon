window.addEventListener("load", () => {
    const remove = e => {
        e.target.closest("li").remove();
    };

    document.getElementById("add_photo").addEventListener("click", e => {
        const temp_photo = document.getElementById("temp_photo");
        // console.log(temp_photo.innerHTML);

        const li = document.createElement("li");
        li.innerHTML = temp_photo.innerHTML;
        // console.log(li.outerHTML);

        li.querySelector("button").addEventListener("click", remove);

        const list_photo = document.getElementById("list_photo");
        list_photo.append(li);
    });
});