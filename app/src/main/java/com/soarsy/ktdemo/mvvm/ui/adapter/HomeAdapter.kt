package com.soarsy.ktdemo.mvvm.ui.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.soarsy.ktdemo.R
import com.soarsy.ktdemo.mvvm.bean.ReposItem
import de.hdodenhof.circleimageview.CircleImageView

/**
 * NAME：YONG_
 * Created at: 2022/2/15 15
 * Describe:
 */
class HomeAdapter: BaseQuickAdapter<ReposItem, BaseViewHolder>(R.layout.item_repos_repo) {
    override fun convert(holder: BaseViewHolder, item: ReposItem) {
        //获取控件ID
        val ivAvatar = holder.getView<ImageView>(R.id.ivAvatar)
        val ivLanguageColor = holder.getView<CircleImageView>(R.id.ivLanguageColor)

        Glide.with(ivAvatar.context)
            .load(item.owner.avatar_url)
            .apply(RequestOptions().circleCrop())
            .into(ivAvatar)
        ivLanguageColor.setImageDrawable(getLanguageColor(item.language))
        ivLanguageColor.visibility = if (item.language == null) View.GONE else View.VISIBLE

        //直接设置文本内容
        holder.setText(R.id.tvOwnerName, item.owner.login)
        holder.setText(R.id.tvRepoName, item.full_name)
        holder.setText(R.id.tvRepoDesc, item.description ?: "(No description, website, or topics provided.)")
        holder.setText(R.id.tvLanguage, item.language)

        holder.setText(R.id.tvStar, "${item.stargazers_count}")
        holder.setText(R.id.tvIssue, "${item.open_issues_count}")
        holder.setText(R.id.tvFork, "${item.forks_count}")
    }

    private fun getLanguageColor(language: String?): Drawable {
        if (language == null) return ColorDrawable(Color.TRANSPARENT)

        val colorProvider: (Int) -> Drawable = { resId ->
            ColorDrawable(ContextCompat.getColor(context, resId))
        }

        return colorProvider(
            when (language) {
                "Kotlin" -> R.color.color_language_kotlin
                "Java" -> R.color.color_language_java
                "JavaScript" -> R.color.color_language_js
                "Python" -> R.color.color_language_python
                "HTML" -> R.color.color_language_html
                "CSS" -> R.color.color_language_css
                "Shell" -> R.color.color_language_shell
                "C++" -> R.color.color_language_cplus
                "C" -> R.color.color_language_c
                "ruby" -> R.color.color_language_ruby
                else -> R.color.color_language_other
            })
    }
}