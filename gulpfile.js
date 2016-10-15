'use strict';

var gulp = require('gulp'),
	concat = require('gulp-concat'),
	htmlmin = require('gulp-htmlmin'),
	templateCache = require('gulp-angular-templatecache'),
	sass = require('gulp-sass'),
	imagemin = require('gulp-imagemin'),
	cleanCSS = require('gulp-clean-css'),
	uglify = require('gulp-uglify');


gulp.task('angular', function(){
	return gulp
        .src('src/main/resources/angular-src/**/*.js')
        .pipe(concat('angular.app.js'))
        .pipe(gulp.dest('src/main/resources/static/'));
});

gulp.task('ngtemplates', function () {
	  return gulp.src('src/main/resources/angular-src/views/**/*.html')
	  	.pipe(htmlmin({collapseWhitespace: true}))
	    .pipe(templateCache('angular.views.js', { module:'angular.app.views', standalone:true }))
	    .pipe(gulp.dest('src/main/resources/static/'));
});

gulp.task('sass', function(){
	  return gulp.src('src/main/resources/static/assets/css/*.scss')
	  	.pipe(sass())
	  	.pipe(cleanCSS())
	    .pipe(gulp.dest('src/main/resources/static/assets/css'));
});

gulp.task('images', function() {
	return gulp.src('src/main/resources/images-src/*')
		.pipe(imagemin({
			progressive: true
		}))
		.pipe(gulp.dest('src/main/resources/static/assets/images'));
});

gulp.task('htmlmin', function() {
  return gulp.src('src/main/resources/static/*.html')
    .pipe(htmlmin({collapseWhitespace: true}))
    .pipe(gulp.dest('src/main/resources/static'));
});

gulp.task('watch-js', function() {
    return gulp.watch('src/main/resources/angular-src/**/*.js', ['angular']);
});

gulp.task('watch-ngtemplates', function() {
    return gulp.watch('src/main/resources/angular-src/views/**/*.html', ['ngtemplates']);
});

gulp.task('watch-sass', function() {
    return gulp.watch('src/main/resources/static/assets/css/**/*.scss', ['sass']);
});

gulp.task('watch-images', function() {
    return gulp.watch('src/main/resources/images-src/**/*', ['images']);
});

gulp.task('watch-htmlmin', function() {
    return gulp.watch('src/main/resources/angular-src/*.html', ['htmlmin']);
});

gulp.task('default', ['sass', 'angular', 'ngtemplates', 'images', 'htmlmin', 'watch-sass',
 'watch-js', 'watch-js', 'watch-ngtemplates', 'watch-images', 'watch-htmlmin']);