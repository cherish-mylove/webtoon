window.addEventListener("load", () => {
    const delete_photos = document.querySelectorAll(".delete_photo");
    
    if(delete_photos) {
        delete_photos.forEach(item => {
            item.addEventListener("click", e => {
                const id = e.target.dataset.photo;  // data-photo

                alert(`삭제 ${id}`);

                fetch(`../delete/photo/${id}`)
                .then(resp => resp.text())
                .then(result => {
                    if(id === result) {
                        alert(`삭제 되었습니다 ${result}`);

                        e.target.closest(".photo").remove();
                    }
                });
            });
        });
    }
});