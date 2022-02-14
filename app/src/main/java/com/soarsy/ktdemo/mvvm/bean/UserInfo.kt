package com.soarsy.ktdemo.mvvm.bean

import com.google.gson.annotations.SerializedName

/**
 * NAME：YONG_
 * Created at: 2022/2/14 16
 * Describe:
 */
data class UserInfo(
 val login: String,
 val id: Int,
 @SerializedName("node_id") val nodeId: String,
 @SerializedName("avatar_url") val avatarUrl: String,
 @SerializedName("gravatar_id") val gravatarId: String,
 val url: String,
 @SerializedName("html_url") val htmlUrl: String,
 @SerializedName("followers_url") val followersUrl: String,
 @SerializedName("following_url") val followingUrl: String,
 @SerializedName("gists_url") val gistsUrl: String,
 @SerializedName("starred_url") val starredUrl: String,
 @SerializedName("subscriptions_url") val subscriptionsUrl: String,
 @SerializedName("organizations_url") val organizationsUrl: String,
 @SerializedName("repos_url") val reposUrl: String,
 @SerializedName("events_url") val eventsUrl: String,
 @SerializedName("received_events_url") val receivedEventsUrl: String,
 val type: String,
 @SerializedName("site_admin") val siteAdmin: String,
 val name: String,
 val company: String,
 val blog: String,
 val location: String,
 val email: String,
 val hireable: String,
 val bio: String,
 @SerializedName("public_repos") val publicRepos: Int,
 @SerializedName("public_gists") val publicGists: Int,
 val followers: Int,
 val following: Int,
 @SerializedName("created_at") val createdAt: String,
 @SerializedName("updated_at") val updatedAt: String,
 @SerializedName("private_gists") val privateGists: Int,
 @SerializedName("total_private_repos") val totalPrivateRepos: Int,
 @SerializedName("owned_private_repos") val ownedPrivateRepos: Int,
 @SerializedName("disk_usage") val diskUsage: Int,
 val collaborators: Int,
 @SerializedName("two_factor_authentication") val twoFactorAuthentication: Boolean
)
