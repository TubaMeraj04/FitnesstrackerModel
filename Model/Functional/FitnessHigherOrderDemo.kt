/**
 * 🏋️ Fitness Tracker — Lambdas & Higher-Order Functions Demo
 *
 * Demonstrates:
 * - Data classes
 * - Higher-order functions
 * - Lambdas
 * - Function type alias
 * - Reusable filtering logic
 */

// ----------------------
// Data Model
// ----------------------

data class Workout(
    val workoutName: String,
    val durationMinutes: Int,
    val caloriesBurned: Int,
    val isCompleted: Boolean
)

// ----------------------
// Higher-Order Function
// ----------------------

fun filterWorkouts(
    workouts: List<Workout>,
    condition: (Workout) -> Boolean
): List<Workout> {
    return workouts.filter(condition)
}

// ----------------------
// Type Alias Example
// ----------------------

typealias WorkoutRule = (Workout) -> Boolean

fun applyWorkoutRule(
    workouts: List<Workout>,
    rule: WorkoutRule
): List<Workout> {
    return workouts.filter(rule)
}

// ----------------------
// Helper Print Function
// ----------------------

fun printWorkouts(title: String, workouts: List<Workout>) {
    println("\n--- $title ---")
    if (workouts.isEmpty()) {
        println("No workouts found.")
        return
    }

    workouts.forEach {
        println(
            "Workout: ${it.workoutName} | " +
            "Duration: ${it.durationMinutes} min | " +
            "Calories: ${it.caloriesBurned} | " +
            "Completed: ${it.isCompleted}"
        )
    }
}

// ----------------------
// Main Function
// ----------------------

fun main() {

    val workoutList = listOf(
        Workout("Morning Cardio", 30, 250, true),
        Workout("Strength Training", 45, 400, false),
        Workout("Evening Yoga", 20, 120, true),
        Workout("HIIT Session", 50, 500, false),
        Workout("Cycling", 60, 550, true)
    )

    // 1️⃣ Filter completed workouts
    val completedWorkouts = filterWorkouts(workoutList) { it.isCompleted }

    // 2️⃣ Filter long workouts (> 40 mins)
    val longWorkouts = filterWorkouts(workoutList) { it.durationMinutes > 40 }

    // 3️⃣ Filter high calorie workouts (> 300)
    val highCalorieWorkouts = filterWorkouts(workoutList) { it.caloriesBurned > 300 }

    // Using typealias + rule
    val intenseRule: WorkoutRule = { it.caloriesBurned > 450 }
    val intenseWorkouts = applyWorkoutRule(workoutList, intenseRule)

    // Print results
    printWorkouts("All Workouts", workoutList)
    printWorkouts("Completed Workouts", completedWorkouts)
    printWorkouts("Long Workouts (>40 mins)", longWorkouts)
    printWorkouts("High Calorie Workouts (>300)", highCalorieWorkouts)
    printWorkouts("Intense Workouts (>450 calories)", intenseWorkouts)
}
