package com.example.deron.t8_Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.deron.databinding.FragmentOneBinding

class MyFragmentOne : Fragment() {

    lateinit var binding: FragmentOneBinding
    private val ac: MyFragmentActivity by lazy { activity as MyFragmentActivity }
    private val viewModel: MyFragmentViewModel by activityViewModels()


    /**
     *  Fragment 被建立，但還沒有 UI。
     *  1. 初始化一些 與 UI 無關的資料（例如變數、ViewModel、Adapter 資料來源）。
     *  2. 處理從 arguments 傳進來的參數。
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    /**
     *  需要建立 Fragment 的 View。
     *  1. inflate fragment 的 layout。
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     *  Fragment 的 view 已經被建立，準備可以操作 UI。
     *  1. 設定畫面元件、綁定事件（Button click、RecyclerView adapter）。
     *  2. 與 ViewModel 綁定 LiveData observer。
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {
            ac.goToFragmentTwo()
        }

        binding.btnData.setOnClickListener {
            viewModel.updateData()
        }

        // Fragment View 常常被銷毀重建 (EX:ViewPager)，如果 Owner 設定 this 可能導致喚起已經死掉的 view，因此這邊要綁 View
        viewModel.data.observe(viewLifecycleOwner) { data ->
            binding.tvData.text = data
        }
    }


    /**
     *  Fragment 已經對使用者可見，但還不能互動。
     *  1. 開始播放動畫、啟動一些需要可見但不互動的東西（例如地圖、影片 preload）。
     */
    override fun onStart() {
        super.onStart()

    }

    /**
     *  手機背景回前景需要做的事情
     */
    override fun onResume() {
        super.onResume()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyFragmentOne()
    }
}