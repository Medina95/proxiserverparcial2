 function loadGetMsg() {
            const list = document.getElementById("list").value;
            const value = document.getElementById("value").value;
            const operation = document.getElementById("searchType").value === "linear" ? "/linearsearch" : "/binarysearch";

fetch(operation+"?list=" + list + "&value=" + value)
                .then(response => response.json())
                .then(data => {
                    document.getElementById('getrespmsg').textContent = JSON.stringify(data, null, 2);
                });
        }