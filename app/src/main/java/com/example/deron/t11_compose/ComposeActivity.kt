package com.example.deron.t11_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deron.R

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Main() {
    val pagerState = rememberPagerState(initialPage = 0) { 3 } // 一共有 3 頁
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column {

            Box {
                Column {
                    // 草原
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .background(color = Color.Green),
                        painter = painterResource(id = R.drawable.grassland),
                        contentDescription = "Benner"
                    )

                    //
                    Column(modifier = Modifier.fillMaxHeight()) {
                        // 資產總額 + 合計 + 前日比
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                        ) {

                            Row(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .height(20.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "資產總額")
                                Space(width = 20.dp)
                                Image(
                                    painter = painterResource(id = R.drawable.ic_launcher_background),
                                    contentDescription = "眼睛圖示"
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .height(45.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(text = "合計")
                                Space(width = 20.dp)
                                Text(
                                    text = "￥88,769",
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .height(22.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.End
                            ) {
                                Text(text = "前日比")
                                Space(width = 20.dp)
                                Text(
                                    text = "￥88,769",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }
                        }

                        Space(height = 20.dp)

                        // 今月の家計簿 + 收支、分担、預算的 ViewPager
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                        ) {
                            Row(modifier = Modifier.padding(10.dp)) {
                                Text(text = "今日の家計簿", fontWeight = FontWeight.Black)
                                Space(width = 10.dp)
                                Text(text = "9/1 ~ 9/30")
                            }
                            Space(height = 5.dp)
                            HorizontalPager(
                                state = pagerState,
                                modifier = Modifier.padding(10.dp)
                            ) { page ->
                                when (page) {
                                    // 收支
                                    0 -> {
                                        val scrollState = rememberScrollState()
                                        Column {
                                            Row(modifier = Modifier.height(140.dp)) {
                                                Image(
                                                    modifier = Modifier.size(140.dp),
                                                    painter = painterResource(id = R.drawable.ic_launcher_background),
                                                    contentDescription = "收支"
                                                )
                                                Space(width = 20.dp)
                                                Column(
                                                    modifier = Modifier.padding(horizontal = 10.dp)
                                                ) {
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .weight(1F),
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Text(text = "收入")
                                                        Text(
                                                            modifier = Modifier.weight(weight = 1f),
                                                            textAlign = TextAlign.End,
                                                            fontSize = 20.sp,
                                                            text = "￥444,178"
                                                        )
                                                    }

                                                    // 分擔
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .weight(1F),
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Text(text = "收入")
                                                        Text(
                                                            modifier = Modifier.weight(weight = 1f),
                                                            textAlign = TextAlign.End,
                                                            fontSize = 20.sp,
                                                            text = "￥-444,178"
                                                        )
                                                    }

                                                    // 預算
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .weight(1F),
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Text(text = "收入")
                                                        Text(
                                                            modifier = Modifier.weight(weight = 1f),
                                                            textAlign = TextAlign.End,
                                                            fontSize = 20.sp,
                                                            text = "￥444,178"
                                                        )
                                                    }
                                                }
                                            }
                                            Space(height = 10.dp, color = Color.LightGray)
                                            Row(
                                                modifier = Modifier
                                                    .horizontalScroll(scrollState)
                                                    .height(20.dp)
                                                    .padding(5.dp)
                                            ) {
                                                FeeType("資產型式")
                                                FeeType("住宅")
                                                FeeType("食費")
                                                FeeType("現金．カード")
                                                FeeType("特別な支出")
                                                FeeType("日用品")
                                                FeeType("衣服．美容")
                                                FeeType("健康．医療")
                                                FeeType("通信費")
                                                FeeType("保險")
                                                FeeType("交際費")
                                                FeeType("その他")
                                            }
                                        }
                                    }

                                    1 -> {
                                        Text(text = "2")
                                    }

                                    2 -> {
                                        Text(text = "3")
                                    }

                                }
                            }
                        }
                    }
                }

                // 狗狗大頭貼
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 95.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.dog1),
                        contentDescription = "Head"
                    )
                    Image(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.dog2),
                        contentDescription = "Head"
                    )
                }
            }
        }
    }
}

@Composable
fun FeeType(type: String) {
    Image(painter = painterResource(id = R.drawable.dog2), contentDescription = type)
    Text(modifier = Modifier.padding(start = 5.dp, end = 10.dp), text = type)
}

@Composable
fun Space(width: Dp = 0.dp, height: Dp = 0.dp, color: Color = Color.White) {
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .background(color)
    )
}
