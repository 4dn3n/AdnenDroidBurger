package fr.isen.kaddouri.droidburger
import CommandeConfirmationActivity
import android.content.Intent
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import fr.isen.kaddouri.droidburger.ui.main.MainFragment

private lateinit var spinner: Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinner)


        //partie bouton commander
        val buttonCommander: Button = findViewById(R.id.buttonCommander)
        val editTextName: EditText = findViewById(R.id.editTextTextPersonName)
        val editTextLastName: EditText = findViewById(R.id.editTextTextPersonName2)
        val editTextAddress: EditText = findViewById(R.id.editTextTextPostalAddress)
        val editTextPhone: EditText = findViewById(R.id.editTextPhone)


        buttonCommander.setOnClickListener {
            // Vérifier si l'un des champs est vide
            if (editTextName.text.isEmpty()) {
                // Afficher un message d'erreur
                Toast.makeText(
                    this,
                    "Veuillez remplir tous les champs du formulaire",
                    Toast.LENGTH_SHORT
                ).show()}
            if (editTextAddress.text.isEmpty()) {
                // Afficher un message d'erreur
                Toast.makeText(
                    this,
                    "Veuillez remplir tous les champs du formulaire",
                    Toast.LENGTH_SHORT
                ).show()}
            if (editTextPhone.text.isEmpty()) {
                // Afficher un message d'erreur
                Toast.makeText(
                    this,
                    "Veuillez remplir tous les champs du formulaire",
                    Toast.LENGTH_SHORT
                ).show()}
            if (editTextLastName.text.isEmpty() ) {
                // Afficher un message d'erreur
                Toast.makeText(
                    this,
                    "Veuillez remplir tous les champs du formulaire",
                    Toast.LENGTH_SHORT
                ).show()}
            else {
                // Récupérer les informations de commande depuis les champs
                val nom = editTextName.text.toString()
                val prenom = editTextLastName.text.toString()
                val adresse = editTextAddress.text.toString()
                val numero = editTextPhone.text.toString()
                val burgerSelectionne = Spinner.AUTOFILL_TYPE_TEXT.toString()

                // Créer un Intent pour passer les données à l'activité de confirmation
                val intent = Intent(this, CommandeConfirmationActivity::class.java)
                intent.putExtra("NOM", nom)
                intent.putExtra("PRENOM", prenom)
                intent.putExtra("ADRESSE", adresse)
                intent.putExtra("NUMERO", numero)
                intent.putExtra("BURGER_SELECTIONNE", burgerSelectionne)

                // Démarrer l'activité de confirmation
                startActivity(intent)

                // Afficher un message de confirmation
                Toast.makeText(
                    this,
                    "Commande confirmée",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }



        //partie spinner
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        val burgerSpinner: Spinner = findViewById(R.id.spinner)

        // Récupérer la liste de burgers depuis les ressources
        val burgerArray = resources.getStringArray(R.array.burger_list)

        // Créer un adaptateur pour le Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, burgerArray)

        // Spécifier la mise en page pour les choix déroulants
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Appliquer l'adaptateur au Spinner
        burgerSpinner.adapter = adapter
    }
}

