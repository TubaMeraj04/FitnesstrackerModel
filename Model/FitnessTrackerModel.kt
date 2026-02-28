// Fitness Tracker Console Application
// Demonstrates class design, constructors, init block, and methods

class Workout(
    val workoutName: String,
    val durationMinutes: Int,
    val caloriesBurned: Int,
    var isCompleted: Boolean,
    val exercises: List<String>
) {

    // Init block for validation
    init {
        if (durationMinutes <= 0) {
            println("Warning: Workout duration must be greater than zero.")
        }
    }

    // Mark workout as completed
    fun markCompleted() {
        isCompleted = true
        println("$workoutName marked as completed.")
    }

    // Calculate calories burned per minute
    fun caloriesPerMinute(): Double {
        return if (durationMinutes > 0)
            caloriesBurned.toDouble() / durationMinutes
        else
            0.0
    }

    // Display workout summary
    fun workoutSummary(): String {
        return "Workout: $workoutName | Duration: $durationMinutes min | Calories: $caloriesBurned kcal | Completed: $isCompleted"
    }
}

fun main() {

    println("=== Fitness Tracker App ===")

    // Creating object instances
    val workout1 = Workout(
        "Morning Cardio",
        30,
        300,
        false,
        listOf("Running", "Jump Rope")
    )

    val workout2 = Workout(
        "Strength Training",
        45,
        450,
        false,
        listOf("Push-ups", "Squats", "Deadlifts")
    )

    println("\n--- Workout Details ---")
    println(workout1.workoutSummary())
    println(workout2.workoutSummary())

    println("\n--- Calories Per Minute ---")
    println("${workout1.workoutName}: ${workout1.caloriesPerMinute()} kcal/min")
    println("${workout2.workoutName}: ${workout2.caloriesPerMinute()} kcal/min")

    println("\n--- Marking First Workout Completed ---")
    workout1.markCompleted()

    println("\n--- Updated Workout Details ---")
    println(workout1.workoutSummary())
}
