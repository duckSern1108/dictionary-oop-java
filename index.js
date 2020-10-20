//init firebase
var firebaseConfig = {
    apiKey: "AIzaSyD8pcYlXFHppnm1Y7ZYEhUHdDHEBfhEgmw",
    authDomain: "dictionary-506cb.firebaseapp.com",
    databaseURL: "https://dictionary-506cb.firebaseio.com",
    projectId: "dictionary-506cb",
    storageBucket: "dictionary-506cb.appspot.com",
    messagingSenderId: "158247458955",
    appId: "1:158247458955:web:9913e0474eed8cbbc21c8e",
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
const db = firebase.firestore();

//app
const deleteWord = (e) => {
    const word = e.target.id;
    db.collection(`${word.length}`)
        .doc(word)
        .delete()
        .then(() => console.log("delete"))
        .catch((error) => console.log("error", error));
};

const editWord = (e) => {
    const word = e.target.id
    const editWord = document.getElementById(`meaning-${word}`).value
    db.collection(`${word.length}`).doc(word).update({
        meaning : editWord
    }).then(() => console.log('edit succes'))
    
};

function searchDict(e) {
    const txtBox = document.getElementById("searchBox");
    const searchResult = document.getElementById("search-result");
    e.preventDefault();
    let word = txtBox.value.toLowerCase();
    db.collection(`${word.length}`)
        .get()
        .then((querySnapshot) =>
            querySnapshot.forEach((doc) => {
                if (doc.id.includes(word)) {
                    const wordContainer = document.createElement("div");
                    wordContainer.classList.add("word-container");
                    const word = document.createElement("h3");
                    word.innerHTML = doc.id;
                    const meaning = document.createElement("input");
                    meaning.id = `meaning-${doc.id}`
                    const editButton = document.createElement("button");
                    editButton.innerHTML = "Edit";
                    editButton.id = doc.id;
                    editButton.classList.add("edit-button");
                    editButton.onclick = (e) => editWord(e);
                    //delete button
                    const deleteButton = document.createElement("button");
                    deleteButton.innerHTML = "Delete";
                    deleteButton.id = doc.id;
                    deleteButton.classList.add("delete-button");
                    deleteButton.onclick = (e) => deleteWord(e);
                    meaning.value = doc.data().meaning;

                    wordContainer.appendChild(word);
                    wordContainer.appendChild(meaning);
                    wordContainer.appendChild(deleteButton);
                    wordContainer.appendChild(editButton)
                    searchResult.appendChild(wordContainer);
                }
            })
        );
}

function addWord(e) {
    e.preventDefault();
    const word = document.getElementById("word").value.toLowerCase();
    const meaning = document.getElementById("meaning").value;
    db.collection(`${word.length}`)
        .doc(word)
        .set({
            meaning: meaning,
        })
        .then(() => console.log("add succees"));
}

document.getElementById("searchBtn").addEventListener("click", searchDict);
document.getElementById("addBtn").addEventListener("click", addWord);